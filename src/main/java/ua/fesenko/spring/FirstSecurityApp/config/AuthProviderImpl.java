package ua.fesenko.spring.FirstSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.fesenko.spring.FirstSecurityApp.servicies.PersonDetailsService;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        UserDetails userDetails = personDetailsService.loadUserByUsername(name);
        String pass = authentication.getCredentials().toString();
        if (!pass.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Not correct password");
        return new UsernamePasswordAuthenticationToken(userDetails, pass, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
