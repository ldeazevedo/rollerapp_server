package com.atiq.rollerapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("rollerapp").password("{noop}todonja112").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/ping").permitAll();
        http.authorizeRequests().antMatchers("/rest/**").hasRole("ADMIN");
        http.httpBasic();
        http.csrf().disable();
        http.formLogin().disable();
        http.logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }
}