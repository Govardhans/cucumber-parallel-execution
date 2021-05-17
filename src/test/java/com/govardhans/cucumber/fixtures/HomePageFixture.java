package com.govardhans.cucumber.fixtures;

import com.govardhans.cucumber.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class HomePageFixture {

    @Lazy
    @Autowired
    HomePage homePage;

    public void searchFor(String str) {
        homePage.getSearchBox().sendKeys(str);
        homePage.getButton().click();
    }

}
