package com.example.jbdl.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NoOpCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/view/**").hasAnyAuthority("adm", "std")
                .antMatchers("/admin/**").hasAuthority("adm")
                .antMatchers("/student/**").hasAuthority("std")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }

}
