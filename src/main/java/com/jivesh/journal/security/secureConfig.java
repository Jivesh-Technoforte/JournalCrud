package com.jivesh.journal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class secureConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        
        UserDetails jivesh = User.builder()
                .username("jivesh")
                .password("{noop}kumar")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        
        UserDetails lochan = User.builder()
                .username("lochan")
                .password("{noop}kumar")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        
        UserDetails rohit = User.builder()
                .username("rohit")
                .password("{noop}kumar")
                .roles("EMPLOYEE")
                .build();
        
        return new InMemoryUserDetailsManager(jivesh, lochan, rohit);
    }
}
