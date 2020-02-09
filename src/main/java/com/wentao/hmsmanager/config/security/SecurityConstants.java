package com.wentao.hmsmanager.config.security;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/auth/login";

    public static final String HEADER = "X-Token";

    public static final String ROLE_CLAIMS = "role";

    /**
     * rememberMe 为 false 的时候过期时间是1个小时
     */
    public static final long EXPIRATION = 60L * 60L;
    /**
     * rememberMe 为 true 的时候过期时间是7天
     */
    public static final long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;
    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";

    private SecurityConstants() {
    }
}
