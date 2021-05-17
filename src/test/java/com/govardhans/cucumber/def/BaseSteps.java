package com.govardhans.cucumber.def;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.govardhans.cucumber.utils.Helper.getTargetObject;

public class BaseSteps {

    private static Logger logger = LoggerFactory.getLogger(BaseSteps.class);

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
            logger.error("scenario failed!! Please check screenshot");
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
            logger.info("closing driver");
            driver.quit();
        }
    }

    @BeforeStep("@ui")
    public void beforeEachStep() {
        logger.info("before step # {}", scenario.getSourceTagNames());
    }

    @AfterStep("@ui")
    public void afterEachStep() {
        logger.info("after step # {}", scenario.getLine());
    }

    @Given("launch browser")
    public void launch_browser() {
        logger.info("driver object {} ", driver);

    }
}
