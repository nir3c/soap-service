package com.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Nir.
 */
@Component
@ConfigurationProperties(prefix = "soap.security")
@Getter @Setter
public class AppSecurityProperties {

    private String username;
    private String password;
    private String role;

}
