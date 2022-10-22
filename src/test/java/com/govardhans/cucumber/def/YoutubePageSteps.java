package com.govardhans.cucumber.def;

import com.govardhans.cucumber.pages.YouTubePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class YoutubePageSteps {

    @Autowired
    YouTubePage youTubePage;

    @When("user open {string}")
    public void user_open(String url) {
        youTubePage.launchVideo(url);
    }

    @And("increase speed to 2X")
    public void increaseSpeed(){

    }

    @Then("wait for {string} mins")
    public void wait_for_mins(String string) {
        try {
            Thread.sleep(420000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
