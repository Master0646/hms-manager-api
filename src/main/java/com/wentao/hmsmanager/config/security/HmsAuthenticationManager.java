package com.wentao.hmsmanager.config.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class HmsAuthenticationManager implements AuthenticationManager {

    private final HmsAuthenticationProvider hmsAuthenticationProvider;

    public HmsAuthenticationManager(HmsAuthenticationProvider hmsAuthenticationProvider) {
        this.hmsAuthenticationProvider = hmsAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = hmsAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }
}
