package fr.cances.steve.annuaire.spring.model.service.impl.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Classe de configuration Spring permettant de gérer la validation.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class ValidationConfig {

    /**
     * Retourne le validator.
     * 
     * @return Retourne le validator.
     */
    @Bean
    public Validator validator() {

        return new LocalValidatorFactoryBean();
    }

}
