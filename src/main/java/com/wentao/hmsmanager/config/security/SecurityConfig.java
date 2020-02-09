package com.wentao.hmsmanager.config.security;

import com.wentao.hmsmanager.config.security.exception.HmsAccessDeniedHandler;
import com.wentao.hmsmanager.config.security.exception.HmsAuthenticationEntryPoint;
import com.wentao.hmsmanager.config.security.filter.HmsAuthenticationFilter;
import com.wentao.hmsmanager.config.security.filter.HmsAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HmsAuthenticationFilter authenticationFilter;
    @Autowired
    private HmsAuthorizationFilter authorizationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .antMatchers("/api/v1/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/v1/**").hasRole("admin")
                .anyRequest().permitAll()
                .and()
                .addFilterAt(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authorizationFilter, BasicAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(new HmsAuthenticationEntryPoint())
                .accessDeniedHandler(new HmsAccessDeniedHandler());
        http.headers().frameOptions().disable();
    }
}
