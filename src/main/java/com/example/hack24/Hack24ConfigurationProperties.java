package com.example.hack24;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "configuration")
public class Hack24ConfigurationProperties {

    private String applicationVersion;
}
