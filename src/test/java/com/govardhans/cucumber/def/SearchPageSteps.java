package com.govardhans.cucumber.def;

import com.govardhans.cucumber.config.WebDriverFactory;
import com.govardhans.cucumber.impl.HomePageImpl;
import com.govardhans.cucumber.impl.SearchResultPageImpl;
import com.govardhans.cucumber.model.HomePage;
import com.govardhans.cucumber.model.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPageSteps {

    private static final Logger logger = LoggerFactory.getLogger(SearchPageSteps.class);
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private final WebDriverFactory webDriverFactory;
    private WebDriver driver;

    public SearchPageSteps(WebDriverFactory webDriverFactory){
        this.webDriverFactory = webDriverFactory;
        driver = this.webDriverFactory.getWebDriver();
        this.homePage = new HomePageImpl(webDriverFactory);
        this.searchResultPage = new SearchResultPageImpl(webDriverFactory);
    }

    @Given("I am on the Google search engine")
    public void i_am_on_the_bing_search_engine() {
        homePage.load();
    }


    @When("I enter a search term {string}")
    public void i_enter_a_search_term(String searchText) {
        homePage.searchFor(searchText);
    }

    @Then("relevant results for {string} are displayed")
    public void relevant_results_for_that_search_term_are_displayed(String searchText) {
        String firstResultTitle = searchResultPage.getFirstResultTitle();
        logger.info("First Result title : {} ", firstResultTitle);

        Assert.assertEquals(firstResultTitle, searchText);
    }
}
