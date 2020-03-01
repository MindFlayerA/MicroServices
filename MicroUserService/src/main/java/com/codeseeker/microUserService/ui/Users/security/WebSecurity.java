package com.codeseeker.microUserService.ui.Users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.codeseeker.microUserService.ui.userservice.UserServiceProvider;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	protected Environment env;
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserServiceProvider userDetailsService;

	@Autowired
	public WebSecurity(Environment env, BCryptPasswordEncoder bCryptPasswordEncoder,
			UserServiceProvider userDetailsService) {
		this.env = env;
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip"))
				.and()
				.addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}

	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter filter = new AuthenticationFilter(userDetailsService, env, authenticationManager());
		// filter.setAuthenticationManager(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		
	}

}
