package fr.cances.steve.annuaire.spring.model.service.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PojoMappingConfig {

	@Bean
	public DozerBeanMapper dozerMapper() {
		return new DozerBeanMapper();
	}
}
