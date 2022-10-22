package com.govardhans.cucumber.def;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.govardhans.cucumber.utils.Helper.getTargetObject;


@Slf4j
public class BaseSteps {

    @Autowired
    protected WebDriver driver;
    private Scenario scenario;

    @Before("@ui")
    public void testSetup(Scenario scenario) {
        this.scenario = scenario;
        this.scenario.log("Execution started at :: " + System.currentTimeMillis());
    }


    @After("@ui")
    public void tearDown() throws Exception {
        if (this.scenario.isFailed()) {
            log.error("scenario failed!! Please check screenshot");
            try {
                byte[] screenshot = ((TakesScreenshot) getTargetObject(driver, WebDriver.class)).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot.png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        }
        scenario.log("test case is pass");
        if (driver != null) {
            log.info("closing driver");
            driver.quit();
        }
    }

    @BeforeStep("@ui")
    public void beforeEachStep() {
        log.info("before step # {}", scenario.getSourceTagNames());
    }

    @AfterStep("@ui")
    public void afterEachStep() {
        log.info("after step # {}", scenario.getLine());
    }

    @Given("launch browser")
    public void launch_browser() {
        log.info("driver object {} ", driver);

    }
}
