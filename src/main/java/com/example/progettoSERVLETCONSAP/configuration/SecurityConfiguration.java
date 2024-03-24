package com.example.progettoSERVLETCONSAP.configuration;


//import com.example.progettoSERVLETCONSAP.Servlet.CustomDispatcherServlet;
import com.example.progettoSERVLETCONSAP.auth.RoleEntity;
import com.example.progettoSERVLETCONSAP.filters.CustomAuthenticationFilter;
import com.example.progettoSERVLETCONSAP.filters.CustomAuthorizationFilter;
import com.example.progettoSERVLETCONSAP.filters.CustomTokenFilter;
import com.example.progettoSERVLETCONSAP.model.UserEntity;
import com.example.progettoSERVLETCONSAP.service.RoleService;
import com.example.progettoSERVLETCONSAP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.awt.*;
import java.util.ArrayList;

import static org.springframework.security.config.http.MatcherType.mvc;

@Configuration

public class SecurityConfiguration {

    private final HandlerMappingIntrospector handlerMappingIntrospector;

    @Autowired
    public SecurityConfiguration(HandlerMappingIntrospector handlerMappingIntrospector) {
        this.handlerMappingIntrospector = handlerMappingIntrospector;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {

/*
            roleService.save(new RoleEntity(null, "ROLE_USER"));
            roleService.save(new RoleEntity(null, "ROLE_ADMIN"));

            userService.save(new UserEntity(null, "rossi", "1234", new ArrayList<>()));
            userService.save(new UserEntity(null, "bianchi", "1234", new ArrayList<>()));

            userService.addRoleToUser("rossi", "ROLE_USER");
            userService.addRoleToUser("bianchi", "ROLE_ADMIN");
            userService.addRoleToUser("bianchi", "ROLE_USER");
*/


        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

            http
                    .csrf(csrf -> csrf.disable())
                    .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests((auth) -> auth
                            .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                            .requestMatchers(HttpMethod.POST,"/api/richiesta/**").permitAll()
                            .requestMatchers("/registrazione/**").permitAll()
                            .requestMatchers("/v3/**", "/configuration/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**", "/api/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/addRoleToUser").hasAuthority("ROLE_ADMIN")
                            .anyRequest().authenticated()

                    )
                    .addFilter(new CustomAuthenticationFilter(authenticationManager))
                    .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .headers(headers -> headers.cacheControl(cacheControl -> cacheControl.disable()));

            return http.build();
    }
    */

/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        //.requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(new MvcRequestMatcher(handlerMappingIntrospector,"/login/**")).permitAll()

                        //.requestMatchers( "/login/**").permitAll()
                        .requestMatchers("/registrazione/**").permitAll()
                        .requestMatchers("/**").authenticated()
                        .requestMatchers("/v3/**", "/configuration/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/richiesta/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/addRoleToUser").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()

                )
                .addFilter(new CustomAuthenticationFilter(authenticationManager))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.cacheControl(cacheControl -> cacheControl.disable()));

        return http.build();
    }

*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        //.requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
                       // .requestMatchers(new MvcRequestMatcher(handlerMappingIntrospector,"/login/**")).permitAll()

                        //.requestMatchers( "/login/**").permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/registrazione/**")).permitAll()
                        //.requestMatchers(new AntPathRequestMatcher("/addRoleToUser/**")).permitAll()
                       // .requestMatchers("/**").authenticated()
                      //  .requestMatchers("/v3/**", "/configuration/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**").permitAll()
                        //.requestMatchers(HttpMethod.POST,"/api/richiesta/**").authenticated()
                      //  .requestMatchers(HttpMethod.POST, "/addRoleToUser").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                )

                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.cacheControl(cacheControl -> cacheControl.disable()));

        return http.build();
    }








}
