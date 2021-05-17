package com.govardhans.cucumber.context;

import com.govardhans.cucumber.config.WebDriverFactory;
import com.govardhans.cucumber.fixtures.HomePageFixture;
import com.govardhans.cucumber.fixtures.SearchResultPageFixture;
import com.govardhans.cucumber.pages.HomePage;
import com.govardhans.cucumber.pages.SearchResultPage;
import com.govardhans.cucumber.utils.SeleniumUtil;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;


public class ContextConfig {

    @Bean
    @Lazy(value = true)
    HomePage getHomePage() {
        return new HomePage();
    }

    @Bean
    @Lazy
    HomePageFixture getHomePageFixture() {
        return new HomePageFixture();
    }

    @Autowired
    WebDriver driver;

    @Autowired
    @Lazy
    WebDriverWait webDriverWait;

    @Bean
    @ScenarioScope
    public WebDriver getDriver() {
        return new WebDriverFactory().getWebDriver();
    }

    @Bean
    public SeleniumUtil getSeleniumUtil() {
        return new SeleniumUtil(driver, webDriverWait);
    }

    @Bean
    @Lazy
    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 60);
    }

    @Bean
    @Lazy
    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage() ;
    }

    @Bean
    public SearchResultPageFixture getSearchResultPageFixture(){
        return new SearchResultPageFixture();

    }

}
