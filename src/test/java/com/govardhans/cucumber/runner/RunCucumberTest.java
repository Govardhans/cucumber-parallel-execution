package com.govardhans.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/search",
		dryRun = false,
		stepNotifications = true,
		glue = {"com.govardhans.cucumber"},
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber.html" }

		)
public class RunCucumberTest {
}
