package com.shev8987.spring.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {



    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement((sessionManagement) -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(
                        (authorizeRequest) -> authorizeRequest
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/admin/**").hasRole(RoleEnum.ADMIN.getName())
                                .requestMatchers("/api/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/service-api/**").permitAll()
                                .anyRequest()
                                .authenticated()
                         )
                .formLogin((form) -> form
                        .loginPage("/api/auth/login")
                        .permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();

    }


}
