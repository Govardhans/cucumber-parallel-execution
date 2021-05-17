package com.govardhans.cucumber.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class SeleniumUtil {

    WebDriver driver;
    WebDriverWait wait;

    public SeleniumUtil(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForElementToBeDisplayed(WebElement searchBox) {
        wait.until((a) -> searchBox.isDisplayed());
    }

    public void load(String urlStr) {
        driver.get(urlStr);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
