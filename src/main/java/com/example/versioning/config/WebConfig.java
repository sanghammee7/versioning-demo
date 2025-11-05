package com.example.versioning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /*
     * path-segment /v1/user
     * request header
     * query param
     * media type param
     */
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configuer){
        configuer.addSupportedVersions("1.0","1.1","2.0")
                .setDefaultVersion("1.0")
                .usePathSegment(1);
                //.useRequestHeader("X-API-Version")
                //.setVersionParser(new ApiVersionParser());

    }
}
