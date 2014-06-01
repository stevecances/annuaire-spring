package fr.cances.steve.annuaire.spring.ws.security;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.cances.steve.annuaire.spring.model.service.api.ServiceSecurityUser;

/**
 * Security {@link AuthenticationProvider} se basant sur {@link ServiceSecurityUser}
 * .
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Inject
    private ServiceSecurityUser serviceSecurity;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (name.equals("admin") && password.equals("system")) {
            List<GrantedAuthority> grantedAuths = Lists.newArrayList();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
        } else {
            throw new BadCredentialsException("Identifiants invalides");
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
