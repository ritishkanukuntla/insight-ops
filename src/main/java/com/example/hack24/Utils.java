package com.example.hack24;

import org.springframework.http.HttpHeaders;

public final class Utils {

    private Utils(){
        throw new UnsupportedOperationException("This class should not be instantiated");
    }

    public static HttpHeaders getResponseHeaders(Hack24ConfigurationProperties hack24ConfigurationProperties){
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("application-version", hack24ConfigurationProperties.getApplicationVersion());
        return httpHeaders;
    }
}
