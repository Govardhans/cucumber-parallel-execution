package com.govardhans.cucumber.impl;

import com.govardhans.cucumber.config.WebDriverFactory;
import com.govardhans.cucumber.model.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPageImpl implements SearchResultPage {
    private WebDriver driver;

    public SearchResultPageImpl(WebDriverFactory driverFactory) {
        this.driver = driverFactory.getWebDriver();
    }

    @Override
    public String getFirstResultTitle() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='search']//h3"));
        return elements.get(0).getText();
    }
}
