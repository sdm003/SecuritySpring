package com.example.Security.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                //.authorizeRequests()
                //.anyRequest()
                //.authenticated()
                .authorizeRequests().antMatchers("/shared")
                .permitAll()

                .antMatchers("/check").hasRole("SUPERVISOR")
                .antMatchers("/cashier").hasRole("TELLER")
                .antMatchers("/general").hasRole("SUPERVISOR")
                .antMatchers("/general").hasRole("TELLER")

                .and()
                .httpBasic()
                .and().logout();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("SUPERVISOR")
                .password("{noop}1")
                .roles("SUPERVISOR")
                .and()
                .withUser("TELLER")
                .password("{noop}2")
                .roles("TELLER");



}}
