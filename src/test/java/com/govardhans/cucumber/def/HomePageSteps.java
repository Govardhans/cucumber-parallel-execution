package com.govardhans.cucumber.def;

import com.govardhans.cucumber.pages.HomePage;
import com.govardhans.cucumber.utils.SeleniumUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSteps {

    private static final Logger logger = LoggerFactory.getLogger(SearchPageSteps.class);

    @Autowired
    SeleniumUtil seleniumUtil;

    @Given("navigate to home page")
    public void navigate_to_home_page() {
        seleniumUtil.load("https://www.google.com/");
    }

    @Then("verify page title is {string}")
    public void verify_page_title_is(String string) {
        Assert.assertEquals(string, seleniumUtil.getTitle());
    }
}
