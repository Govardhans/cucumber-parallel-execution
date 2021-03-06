package com.govardhans.cucumber;

import com.govardhans.cucumber.utils.TestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions {
	Logger logger = LoggerFactory.getLogger(StepDefinitions.class);
	Scenario scenario;

	@Autowired
	TestConfig testConfig;
	
	@Before
	public void testSetup(Scenario scenario) {
		this.scenario = scenario;
		logger.info("Before {}", scenario.getName());
		logger.info("Test Config {} ",testConfig.toString());
	}
	
	@After
	public void tearDown() {
		logger.info("After {}", scenario.getName());
	}
	
	@BeforeStep("~@ui")
	public void beforeEachStep() {
		logger.info("before step # {}", scenario.getLine());
	}
	
	@AfterStep("~@ui")
	public void afterEachStep() {
		logger.info("after step # {}", scenario.getLine());
	}
	
	@Given("Step from {string} in {string} feature file")
	public void step(String scenario, String file) {
	
		logger.info("----");		
		logger.info("{} in file {} is running ", scenario, file);
		
		this.scenario.log("Step executed !!");
	}	
	
}
