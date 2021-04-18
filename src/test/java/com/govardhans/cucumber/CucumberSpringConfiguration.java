package com.govardhans.cucumber;

import com.govardhans.cucumber.utils.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfig.class})
public class CucumberSpringConfiguration {

}