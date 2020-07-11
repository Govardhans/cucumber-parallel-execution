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

public class HomePageSteps {

    private static final Logger logger = LoggerFactory.getLogger(SearchPageSteps.class);
    private HomePage homePage;
    private final WebDriverFactory webDriverFactory;
    private WebDriver driver;

    public HomePageSteps(WebDriverFactory webDriverFactory, HomePageImpl homePageImpl){
        this.webDriverFactory = webDriverFactory;
        driver = this.webDriverFactory.getWebDriver();
        this.homePage = homePageImpl;

    }

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
