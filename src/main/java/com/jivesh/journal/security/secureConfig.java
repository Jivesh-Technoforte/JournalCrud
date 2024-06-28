package com.jivesh.journal.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

@Configuration
public class secureConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() {
	 * 
	 * UserDetails jivesh = User.builder() .username("jivesh")
	 * .password("{noop}kumar") .roles("EMPLOYEE", "MANAGER", "ADMIN") .build();
	 * 
	 * UserDetails lochan = User.builder() .username("lochan")
	 * .password("{noop}kumar") .roles("EMPLOYEE", "MANAGER") .build();
	 * 
	 * UserDetails rohit = User.builder() .username("rohit")
	 * .password("{noop}kumar") .roles("EMPLOYEE") .build();
	 * 
	 * return new InMemoryUserDetailsManager(jivesh, lochan, rohit); }
	 */
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
        http.authorizeRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/crud").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/crud/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/crud").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/crud/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/crud/**").hasRole("ADMIN")
        );
    	
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
    	
        return http.build();
    }
}
