package com.govardhans.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchResultPage {

    @FindBy(xpath = "//*[@id='search']//h3")
    List<WebElement> searchHeader;

    @Autowired
    WebDriver driver;

    public SearchResultPage(){
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSearchHeader() {
        return searchHeader;
    }
}
