package com.makemake.testsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// the way to configure authentication in spring security is
// affecting authentication manager (manages authentication in spring security)
// you can imaging authentication manager sitting in spring security app doing the authentication
// Authentication manager actually has a method called authenticate which either returns a successful authentication or
// or throws an exception when it comes

// Step 1: Get hold of AuthenticationManagerBuilder
// Step 2: Set the configuration on it
// After this you can imaging a new authentication manager being created somehow

// How do I get authentication manager builder?
// By leveraging a hook that's already available in the spring security app
// the spring security framework calls the configure method and passes in the authentication manager builder
@EnableWebSecurity // tells spring security this is web security configuration, another is application/method security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("USER")
                .and()
                .withUser("foo")
                .password("foo")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
