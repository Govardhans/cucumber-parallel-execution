package com.govardhans.cucumber.def;

import com.govardhans.cucumber.fixtures.HomePageFixture;
import com.govardhans.cucumber.fixtures.SearchResultPageFixture;
import com.govardhans.cucumber.pages.HomePage;
import com.govardhans.cucumber.pages.SearchResultPage;
import com.govardhans.cucumber.utils.SeleniumUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchPageSteps {

    private static final Logger logger = LoggerFactory.getLogger(SearchPageSteps.class);

    @Autowired
    private HomePageFixture homePageFixture;

    @Autowired
    private SearchResultPageFixture searchResultPage;

    @Autowired
    private SeleniumUtil seleniumUtil;

    @Given("I am on the Google search engine")
    public void i_am_on_the_bing_search_engine() {
        seleniumUtil.load("https://www.google.com/");
    }


    @When("I enter a search term {string}")
    public void i_enter_a_search_term(String searchText) {
        homePageFixture.searchFor(searchText);
    }

    @Then("relevant results for {string} are displayed")
    public void relevant_results_for_that_search_term_are_displayed(String searchText) {
        String firstResultTitle = searchResultPage.getFirstResultTitle();
        logger.info("First Result title : {} ", firstResultTitle);

        Assert.assertEquals(firstResultTitle, searchText);
    }
}
