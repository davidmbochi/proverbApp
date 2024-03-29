package com.spring.proverbApp.config;

import com.spring.proverbApp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class proverbAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private userService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                .antMatchers("/saveProverb").hasAnyRole("EMPLOYEE","MANAGER")
                .antMatchers("/updateProverb").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/deleteProverb").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/showLoginForm")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
    }
    @Bean
    public  BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());

        return auth;

    }



}
