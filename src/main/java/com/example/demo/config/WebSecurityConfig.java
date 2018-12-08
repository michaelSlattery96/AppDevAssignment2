package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/css/**", "/", "/projects", "/projectdetails/**",
				"/signup").permitAll()
			.antMatchers("/newproject/", "/profile/").hasAnyRole("USER", "ADMIN")
			.and()
			.formLogin().loginPage("/login").permitAll()
			.usernameParameter("email")
			.and()
			.httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select member.memberEmail, member.memberPassword, member.memberEnabled from member where member.memberEmail=?")
		.authoritiesByUsernameQuery("SELECT role.memberEmail, role.type FROM role WHERE role.memberEmail=?")
		;
	} 
}
