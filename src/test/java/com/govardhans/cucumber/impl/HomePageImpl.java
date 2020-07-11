package com.govardhans.cucumber.impl;

import com.govardhans.cucumber.config.WebDriverFactory;
import com.govardhans.cucumber.model.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageImpl implements HomePage {

    private String homePageUrl=System.getProperty("env.url", "https://www.google.com/");

    private WebDriver driver;

    public HomePageImpl(WebDriverFactory driverFactory) {
        this.driver = driverFactory.getWebDriver();
    }

    @Override
    public void load() {
        driver.get(homePageUrl);
    }

    @Override
    public void searchFor(String str) {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(str);
        driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
        //
    }
}
