package com.example.demojpa.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class DefaultSecurityConfig {
    
    private final PasswordEncoder encoder;
    public DefaultSecurityConfig() {
        encoder = new BCryptPasswordEncoder();
    }
    @Bean   
    public SecurityFilterChain routesFilter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            (requests) -> requests.requestMatchers(HttpMethod.POST,"/register").permitAll()
                                  //.requestMatchers("/csrf").permitAll()
                                  .requestMatchers(HttpMethod.POST,"/api/users").hasRole("ADMIN")
                                  .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return this.encoder;
    }
}
