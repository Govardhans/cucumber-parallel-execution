package com.govardhans.cucumber.fixtures;

import com.govardhans.cucumber.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

public class SearchResultPageFixture {


    @Autowired
    @Lazy
    SearchResultPage searchResultPage;

    public String getFirstResultTitle() {
        List<WebElement> elements = searchResultPage.getSearchHeader();
        return elements.get(0).getText();
    }
}
