package com.example.notesapi;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            // allow anonymous access to the root page
            .antMatchers("/").permitAll()
            // all other requests
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer().jwt(); // replace .jwt() with .opaqueToken() for Opaque Token case

        // Send a 401 message to the browser (w/o this, you'll see a blank page)
        Okta.configureResourceServer401ResponseBody(http);
    }
}