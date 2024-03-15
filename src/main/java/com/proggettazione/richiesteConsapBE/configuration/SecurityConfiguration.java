package com.proggettazione.richiesteConsapBE.configuration;


import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import com.proggettazione.richiesteConsapBE.filters.CustomAuthenticationFilter;
import com.proggettazione.richiesteConsapBE.filters.CustomAuthorizationFilter;
import com.proggettazione.richiesteConsapBE.model.UserEntity;
import com.proggettazione.richiesteConsapBE.service.RoleService;
import com.proggettazione.richiesteConsapBE.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {
            roleService.save(new RoleEntity(null, "ROLE_USER"));
            roleService.save(new RoleEntity(null, "ROLE_ADMIN"));

            userService.save(new UserEntity(null, "rossi", "1234", new ArrayList<>()));
            userService.save(new UserEntity(null, "bianchi", "1234", new ArrayList<>()));

            userService.addRoleToUser("rossi", "ROLE_USER");
            userService.addRoleToUser("bianchi", "ROLE_ADMIN");
            userService.addRoleToUser("bianchi", "ROLE_USER");
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers("/registrazione/**").permitAll()
                        .requestMatchers("/v3/**", "/configuration/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilter(new CustomAuthenticationFilter(authenticationManager))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.cacheControl(cacheControl -> cacheControl.disable()));

        return http.build();
    }
}
