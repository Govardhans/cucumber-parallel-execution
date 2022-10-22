package com.govardhans.cucumber.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/${env:qa}.properties")
public class TestConfig {

    @Value( "${url}" )
    private String url;

    @Value( "${userName}" )
    private String userName;

    @Value( "${password}" )
    private String password;

    @Override
    public String toString() {
        return "TestConfig{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
