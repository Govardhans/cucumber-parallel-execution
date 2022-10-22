package com.govardhans.cucumber.context;

import com.govardhans.cucumber.config.WebDriverFactory;
import com.govardhans.cucumber.impl.HomePageImpl;
import com.govardhans.cucumber.impl.SearchResultPageImpl;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ContextConfig {

    @Autowired
    HomePageImpl homePage;

    @Autowired
    SearchResultPageImpl searchResultPage;

    @Bean
    @ScenarioScope
    public WebDriver getDriver(){
        return new WebDriverFactory().getWebDriver();
    }

}
