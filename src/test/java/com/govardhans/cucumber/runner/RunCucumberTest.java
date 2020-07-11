package com.govardhans.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		dryRun = false,
		glue = {"com.govardhans.cucumber"},
		plugin = { "pretty", "html:target/cucumber.html" }

		)
public class RunCucumberTest {
}
