package io.restApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new Pbkdf2PasswordEncoder("MyS3cr3t");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin","/administration", "/settings")
                .hasRole("ADMIN")
                .antMatchers("/", "/prediction", "/register")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/prediction")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                //because of lack of client-side implementation, i disabled the headers and the csrf to let the app work
                .headers().frameOptions().disable();
        http
                .csrf().disable();
    }
}

