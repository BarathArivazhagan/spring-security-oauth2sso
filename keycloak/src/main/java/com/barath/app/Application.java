package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@SpringBootApplication
@EnableOAuth2Sso
public class Application extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
    

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
			.authorizeRequests()
				.antMatchers("/", "/health", "/login**", "/webjars/**").permitAll()
				.anyRequest().authenticated()
			.and().logout().logoutSuccessUrl("/").permitAll()
			.and().csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
	}
    

    

}
