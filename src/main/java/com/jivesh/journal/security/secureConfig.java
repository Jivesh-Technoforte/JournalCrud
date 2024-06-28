package com.jivesh.journal.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

@Configuration
public class secureConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "SELECT user_id, pw, enabled FROM members WHERE user_id = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT user_id, role FROM roles WHERE user_id = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(configurer ->
            configurer
                .requestMatchers(HttpMethod.GET, "/crud").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/crud/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/crud").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/crud/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/crud/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
