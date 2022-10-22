package com.govardhans.cucumber;

import com.govardhans.cucumber.context.ContextConfig;
import com.govardhans.cucumber.impl.HomePageImpl;
import com.govardhans.cucumber.impl.SearchResultPageImpl;
import com.govardhans.cucumber.pages.YouTubePage;
import com.govardhans.cucumber.utils.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;

@Lazy
@CucumberContextConfiguration
@ContextConfiguration(
        classes = {
                TestConfig.class,
                ContextConfig.class,
                HomePageImpl.class,
                SearchResultPageImpl.class,
                YouTubePage.class

        })

public class CucumberSpringConfiguration {

}