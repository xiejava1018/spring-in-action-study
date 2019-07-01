package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	DataSource dataSource;
	
	 @Bean
	  public PasswordEncoder encoder() {
	    return new StandardPasswordEncoder("53cr3t");
	  }
	/*
	 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 * { auth .inMemoryAuthentication() .withUser("buzz") .password("infinity")
	 * .authorities("ROLE_USER") .and() .withUser("woody") .password("bullseye")
	 * .authorities("ROLE_USER"); }
	 */
	 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth .jdbcAuthentication() .dataSource(dataSource); }
	 */
	 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth .jdbcAuthentication() .dataSource(dataSource)
	 * .usersByUsernameQuery( "select username, password, enabled from Users " +
	 * "where username=?") .authoritiesByUsernameQuery(
	 * "select username, authority from UserAuthorities " + "where username=?"); }
	 */
	 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth .ldapAuthentication() .userSearchBase("ou=people")
	 * .userSearchFilter("(uid={0})") .groupSearchBase("ou=groups")
	 * .groupSearchFilter("member={0}") .passwordCompare() .passwordEncoder(new
	 * BCryptPasswordEncoder()) .passwordAttribute("passcode") .contextSource()
	 * .root("dc=tacocloud,dc=com") .ldif("classpath:users.ldif"); }
	 */
	 
	 protected void configure(HttpSecurity http) throws Exception{
		 http.authorizeRequests().antMatchers("/design","/orders")
		 .access("hasRole('ROLE_USER')").antMatchers("/","/**")
		 .access("permitAll")
		 .and().formLogin().loginPage("/login")
		 .and()
	        .logout()
	          .logoutSuccessUrl("/");
	 }
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	 }
	 
	 
}
