package fr.cances.steve.annuaire.spring.model.persistence.config;

import java.util.Properties;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Fichier de configuration Spring pour gérer la persistance.
 * <p>
 * Se base sur les fichiers de properties :
 * </p>
 * <ul>
 * <li>persistence/database.properties</li>
 * <li>persistence/hibernate.properties</li>
 * </ul>
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@PropertySource(value = { "classpath:persistence/database.properties", "classpath:persistence/hibernate.properties" })
@EnableTransactionManagement
public class PersitenceConfig {

    public static final String PERSITENCE_UNIT_NAME = "productionPersistenceUnit";

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_IMPORT_FILES = "hibernate.hbm2ddl.import_files";

    /**
     * Package contenant les @Entity
     */
    public static final String PACKAGES_TO_SCAN = "fr.cances.steve.annuaire.spring.model.persistence.entity";

    /**
     * Accès aux properties
     */
    @Inject
    private Environment env;

    /**
     * La source de données.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return La source de données.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        return dataSource;
    }

    /**
     * Les propriétés Hibernate (jpa).
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return Les propriétés Hibernate (jpa).
     */
    private Properties jpaHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        final String propertyImportFiles = this.env.getProperty(PROPERTY_NAME_HIBERNATE_IMPORT_FILES);
        if (StringUtils.isNotBlank(propertyImportFiles)) {
            properties.put(PROPERTY_NAME_HIBERNATE_IMPORT_FILES, propertyImportFiles);
        }
        properties.put("hibernate.enable_lazy_load_no_trans", true);
        return properties;
    }

    /**
     * L'entity manager factory.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return L'entity manager factory.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName(PERSITENCE_UNIT_NAME);
        entityManagerFactoryBean.setDataSource(this.dataSource());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }

    /**
     * Le gestonnaire de transactions.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return Le gestonnaire de transactions.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return transactionManager;
    }

}
