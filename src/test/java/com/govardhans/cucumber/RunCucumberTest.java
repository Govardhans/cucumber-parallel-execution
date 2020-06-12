package com.govardhans.cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:hellocucumber", 
		strict = true, 
		plugin = { "pretty", "html:target/cucumber.html" }
		)
public class RunCucumberTest {
}
