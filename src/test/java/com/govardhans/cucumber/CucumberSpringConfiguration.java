package com.govardhans.cucumber;

import com.govardhans.cucumber.context.ContextConfig;
import com.govardhans.cucumber.fixtures.HomePageFixture;
import com.govardhans.cucumber.fixtures.SearchResultPageFixture;
import com.govardhans.cucumber.pages.HomePage;
import com.govardhans.cucumber.utils.SeleniumUtil;
import com.govardhans.cucumber.utils.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;

@Lazy
@CucumberContextConfiguration
@ContextConfiguration(
        classes = {
                TestConfig.class,
                ContextConfig.class
//                HomePage.class,
//                SeleniumUtil.class,
//                HomePageFixture.class,
//                SearchResultPageFixture.class
        })
public class CucumberSpringConfiguration {

}