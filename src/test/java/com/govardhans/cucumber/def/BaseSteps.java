package com.govardhans.cucumber.def;

import com.govardhans.cucumber.config.WebDriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseSteps {
    private static Logger logger = LoggerFactory.getLogger(BaseSteps.class);
    protected WebDriver driver;
    private final WebDriverFactory webDriverFactory;
    private Scenario scenario;

    public BaseSteps(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    @Before("@ui")
    public void testSetup(Scenario scenario) {
        this.scenario = scenario;
        this.driver = webDriverFactory.getWebDriver();
        this.scenario.log("Execution started at :: "+System.currentTimeMillis());
    }

    @After("@ui")
    public void tearDown() {
        if (this.scenario.isFailed()) {
            logger.error("scenario failed!! Please check screenshot");
        }

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png", "screenshot.png");

        scenario.log("test case is pass");

        if(driver!=null){
            logger.info("closing driver");
            driver.quit();
        }

    }

    @BeforeStep("@ui")
    public void beforeEachStep() {
        logger.info("before step # {}", scenario.getLine());
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
