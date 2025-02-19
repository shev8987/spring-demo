package com.shev8987.spring.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
        http.cors().disable();
        http.csrf().disable();
        http.authorizeHttpRequests(
                        (authorizeRequest) -> authorizeRequest
                                .requestMatchers("/**").permitAll()
                                .anyRequest()
                                .authenticated()
                         ).httpBasic(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails guest = User.builder()
                .username("guest")
                .password(encoder().encode("guest"))
                .roles(RoleEnum.USER.getName())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder().encode("admin"))
                .roles(RoleEnum.ADMIN.getName())
                .build();

        return new InMemoryUserDetailsManager(guest,admin);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }




}
