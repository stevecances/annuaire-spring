/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "fr.cances.steve.annuaire.spring", excludeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern = "fr.cances.steve.annuaire.spring.model.persistence.config.PersitenceConfig") })
public class TestPersistenceConfig {

    public static final String PERSITENCE_UNIT_NAME = "testPersistenceUnit";

    private static final String DATABASE_DRIVER = "org.hsqldb.jdbcDriver";
    private static final String DATABASE_URL = "jdbc:hsqldb:mem:testdb";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "";

    private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.HSQLDialect";
    private static final String HIBERNATE_HBM2DDL_AUTO = "create";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }

    private Properties jpaHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", HIBERNATE_DIALECT);
        properties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName(PERSITENCE_UNIT_NAME);
        entityManagerFactoryBean.setDataSource(this.dataSource());
        entityManagerFactoryBean.setPackagesToScan(PersitenceConfig.PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
