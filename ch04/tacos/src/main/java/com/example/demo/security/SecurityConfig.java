package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Bean
	  public PasswordEncoder encoder() {
	    return new StandardPasswordEncoder("53cr3t");
	  }
	 
	protected void configure(AuthenticationManagerBuilder auth)
			 throws Exception {
		auth
		 .inMemoryAuthentication()
		 .withUser("buzz")
		 .password("infinity")
		 .authorities("ROLE_USER")
		 .and()
		 .withUser("woody")
		 .password("bullseye")
		 .authorities("ROLE_USER");
		}
}
