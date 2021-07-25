package com.example.gfg.libraryapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityCustomConfig extends WebSecurityConfigurerAdapter {

    @Value("${admin.authority}")
    private String ADMIN_AUTHORITY;

    @Value("${student.authority}")
    private String STUDENT_AUTHORITY;


    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("piyush")
//                .password("piyush1234")
//                .authorities(STUDENT_AUTHORITY)
//                .and()
//                .withUser("karan")
//                .password("karan1234")
//                .authorities(ADMIN_AUTHORITY);

        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/student/create").permitAll()
                .antMatchers(HttpMethod.GET, "/student/**").hasAnyAuthority(ADMIN_AUTHORITY, STUDENT_AUTHORITY)
                .antMatchers("/student/**", "/transaction/**" ).hasAuthority(STUDENT_AUTHORITY)
                .antMatchers(HttpMethod.GET, "/book/**").hasAnyAuthority(STUDENT_AUTHORITY, ADMIN_AUTHORITY)
                .antMatchers("/book/**").hasAuthority(ADMIN_AUTHORITY)
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
