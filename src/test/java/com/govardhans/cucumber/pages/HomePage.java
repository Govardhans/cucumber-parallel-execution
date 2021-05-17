package com.govardhans.cucumber.pages;

import com.govardhans.cucumber.utils.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    @FindBy(xpath= "(//input[@value='Google Search'])[2]")
    private WebElement button;

    @Autowired
    WebDriver driver;

    @Autowired
    SeleniumUtil seleniumUtil;

    public HomePage() {
        PageFactory.initElements(this.driver, this);
    }

    private void load(){
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getSearchBox() {
        load();
//        seleniumUtil.waitForElementToBeDisplayed(searchBox);
        return searchBox;
    }

    public WebElement getButton() {
//        seleniumUtil.waitForElementToBeDisplayed(button);
        return button;
    }
}
