package com.govardhans.cucumber.impl;

import com.govardhans.cucumber.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchResultPageImpl implements SearchResultPage {

    @Autowired
    private WebDriver driver;


    @Override
    public String getFirstResultTitle() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='search']//h3"));
        return elements.get(0).getText();
    }
}
