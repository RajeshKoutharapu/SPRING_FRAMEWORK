package com.SpringSecurity.coustomMulUsers.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
   @Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
	   http.csrf(customizer->customizer.disable())
		.authorizeHttpRequests(request->request.anyRequest().authenticated())
		//http.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	          return http.build();
	}
   @Bean
   public UserDetailsService customdetails() {
	   UserDetails user1= User.withDefaultPasswordEncoder()
			             .username("rajesh")
			             .password("tt")
			             .roles("user")
			             .build();
	   UserDetails user2= User.withDefaultPasswordEncoder()
	             .username("raj")
	             .password("tt")
	             .roles("admin")
	             .build();
			   
			   return new InMemoryUserDetailsManager(user1,user2);
			   
   }
	
}
