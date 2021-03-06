package com.govardhans.cucumber.def;

import com.govardhans.cucumber.pages.HomePage;
import com.govardhans.cucumber.pages.SearchResultPage;
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
    private HomePage homePage;

    @Autowired
    private SearchResultPage searchResultPage;

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
