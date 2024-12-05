package com.example.OptimaTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  // Desactivar CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuarios").permitAll()
                        .requestMatchers("/usuarios/login").permitAll()
                        .requestMatchers("/citas").permitAll() // O si solo es POST /citas
                        .requestMatchers("/citas/**").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
