package com.govardhans.cucumber.impl;

import com.govardhans.cucumber.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePageImpl implements HomePage {

    private String homePageUrl=System.getProperty("env.url", "https://www.google.com/");

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = HomePage.searchBox)
    WebElement searchBox;

    @FindBy(xpath= HomePage.button)
    WebElement button;

    @Override
    public void load() {
        driver.get(homePageUrl);
        PageFactory.initElements(driver,this);
    }

    @Override
    public void searchFor(String str) {
        searchBox.sendKeys(str);
        button.click();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }
}
