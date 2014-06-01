package fr.cances.steve.annuaire.spring.ws.config;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceSecurityUser;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.SecurityUserVo;
import javax.inject.Inject;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * {@link AuthenticationProvider} se basant sur le service
 * {@link ServiceSecurityUser}.
 * 
 * @author Steve Cances <steve.cances@gmail.com>
 */
@Component
public class SecurityUserAuthenticationProvider implements AuthenticationProvider {

    private static final String ROLE_PREFIX = "ROLE_";

    @Inject
    private ServiceSecurityUser serviceSecurityUser;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        SecurityUserVo securityUserVo = this.serviceSecurityUser.authenticate(username, password);
        if (securityUserVo != null) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    Lists.newArrayList(FluentIterable
                            .from(securityUserVo.getRoles())
                            .transform(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role))
                    ));
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
