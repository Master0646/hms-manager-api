package com.wentao.hmsmanager.config.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wentao.hmsmanager.config.security.HmsAuthenticationManager;
import com.wentao.hmsmanager.config.security.HmsUserDetails;
import com.wentao.hmsmanager.config.security.SecurityConstants;
import com.wentao.hmsmanager.entity.HmsUser;
import com.wentao.hmsmanager.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 登录验证过滤器
 */
@Component
public class HmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public HmsAuthenticationFilter(HmsAuthenticationManager authenticationManager) {
        super(SecurityConstants.AUTH_LOGIN_URL);
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ServletInputStream inputStream = request.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            HmsUser hmsUser = objectMapper.readValue(inputStream, HmsUser.class);
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(hmsUser.getUsername(), hmsUser.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        HmsUserDetails userDetails = (HmsUserDetails) authResult.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        // 创建 Token
        String token = JwtUtils.createToken(userDetails.getUsername(), roles.get(0), false);
        // Http Response Header 中返回 Token
        response.setHeader(SecurityConstants.TOKEN_HEADER, token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed)
            throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, failed.getMessage());
    }
}
