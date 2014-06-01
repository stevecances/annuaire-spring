/**
 *
 */
package fr.cances.steve.annuaire.spring.ws.config;

import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;
import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebMvcSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcSecurityConfig.class);

    @Inject
    private SecurityUserAuthenticationProvider securityUserAuthenticationProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        LOGGER.info("authenticationManagerBean");

        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        LOGGER.info("Configuration du AuthenticationManager");

        auth.authenticationProvider(this.securityUserAuthenticationProvider);

        // auth.inMemoryAuthentication()
        // .withUser("user").password("user").roles("USER").and()
        // .withUser("admin").password("admin").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {

        LOGGER.info("Configuration du HttpSecurity");

        httpSecurity
                .csrf().disable();
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Ajout du BasicAuthenticationFilter
        final BasicAuthenticationFilter basicAuthenticationFilter = new BasicAuthenticationFilter(authenticationManagerBean());

        httpSecurity.addFilter(basicAuthenticationFilter);
    }
}
