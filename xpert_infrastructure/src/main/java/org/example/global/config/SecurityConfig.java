package org.example.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.global.filter.ExceptionFilter;
import org.example.global.filter.JwtFilter;
import org.example.global.security.jwt.JwtParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtParser jwtParser;
    private final ObjectMapper objectMapper;

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder () { return new BCryptPasswordEncoder(); }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(authorization -> {
                    authorization
                        .requestMatchers(HttpMethod.POST, "/user/signup").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/attribute").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/mail/code").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/verify/code").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/profile").authenticated();

                    authorization
                        .requestMatchers(HttpMethod.GET, "/news/list").permitAll()
                        .requestMatchers(HttpMethod.GET, "/news/detail").permitAll();


                    authorization
                        .requestMatchers(HttpMethod.GET, "/gold/price").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/gold/buy").authenticated()
                        .requestMatchers(HttpMethod.GET, "/gold/own").authenticated();

                    authorization
                        .requestMatchers(HttpMethod.POST, "/post").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/post/{postId}").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/post/{postId}").authenticated();

                    authorization
                        .requestMatchers(HttpMethod.POST, "/comment/{postId}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/comment/{commentId}").authenticated();

                    authorization
                        .anyRequest().denyAll();
                })

                .sessionManagement(session
                        -> { session.sessionCreationPolicy(SessionCreationPolicy.STATELESS); }
                )

                .headers(header
                        -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )

                .addFilterBefore(new JwtFilter(jwtParser), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new ExceptionFilter(objectMapper), JwtFilter.class)

                .build();
    }
}
