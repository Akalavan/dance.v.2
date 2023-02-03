package ru.akalavan.dance.security;

/**
 * Class SecurityConstants
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
public class SecurityConstants {
    public static final String SING_UP_URLS = "/api/auth/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000; // через сколько потребуется повторная авторизация
}
