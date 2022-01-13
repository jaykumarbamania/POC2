package com.poc2.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
public class SpringSecurityBasicAuth extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	MyUserDetailsService userDetailsService;
	
	//create 2 users for demo
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// hard coded values
		auth.inMemoryAuthentication().withUser("user").password("{noop}user123").roles("USER")
		.and().withUser("admin").password("{noop}admin123").roles("USER","ADMIN");
		
		//Database Values
		
//		auth.userDetailsService(userDetailsService)
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/insert/student").hasAnyRole("ADMIN","USER")
		.and()
		.csrf().disable();
	}
}
