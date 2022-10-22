package com.govardhans.cucumber.impl;

import com.govardhans.cucumber.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePageImpl implements HomePage {

    private String homePageUrl = System.getProperty("env.url", "https://www.google.com/");

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = HomePage.searchBox)
    WebElement searchBox;

    @FindBy(xpath = HomePage.searchButton)
    WebElement button;

    @FindBy(id = "L2AGLb")
    WebElement acceptAllCookiesButton;

    @Override
    public void load() {
        driver.get(homePageUrl);
        PageFactory.initElements(driver, this);
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

    @Override
    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(acceptAllCookiesButton));
            acceptAllCookiesButton.click();
        } catch (Exception ex) {

        }
    }
}
