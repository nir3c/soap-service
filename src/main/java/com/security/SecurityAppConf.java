package com.security;

import com.properties.AppSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Nir.
 */

@Configuration
@EnableWebSecurity
public class SecurityAppConf extends WebSecurityConfigurerAdapter {

    private AppSecurityProperties properties;

    @Autowired
    public void setProperties(AppSecurityProperties properties) {
        this.properties = properties;
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(properties.getUsername())
                .password(properties.getPassword())
                .roles(properties.getRole());
    }

}

