package com.govardhans.cucumber.def;

import com.govardhans.cucumber.config.WebDriverFactory;
import com.govardhans.cucumber.impl.HomePageImpl;
import com.govardhans.cucumber.model.HomePage;
import com.govardhans.cucumber.model.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSteps {

    private static final Logger logger = LoggerFactory.getLogger(SearchPageSteps.class);
    @Autowired
    private HomePage homePage;

    @Autowired
    private WebDriver driver;

    @Given("navigate to home page")
    public void navigate_to_home_page() {
        homePage.load();
        logger.info("driver object {} ", driver);
    }

    @Then("verify page title is {string}")
    public void verify_page_title_is(String string) {
        logger.info("driver object {} ", driver);
    }
}
