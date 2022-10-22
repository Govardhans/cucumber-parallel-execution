package com.govardhans.cucumber.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class WebDriverFactory {

    private WebDriver driver = null;
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private final static String OS_NAME = System.getProperty("os.name");

    public WebDriver getWebDriver() {
        String webdriver = System.getProperty("browser", "chrome");
        switch(webdriver) {
            case "firefox":
                if(driver == null ) {
                    this.driver =  new FirefoxDriver();
                }
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--headless");
                options.addArguments("-no-sandbox");
                options.addArguments("--disable-gpu");

                this.driver = new ChromeDriver(options);
//                logger.info("Creating chrome Driver instance");
//                String chromeDriverPath = OS_NAME.toLowerCase().contains("mac") ?
//                        "driver/mac/chromedriver" : "driver/chromedriver.exe";
//                if(driver == null ) {
//                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//
//                    this.driver =  new ChromeDriver();
//                }
                break;
            default:
                logger.info("Unsupported webdriver: " + webdriver);
        }
        Dimension dimension = new Dimension(1280 , 720);
        this.driver.manage().window().setSize(dimension);
        return this.driver;
    }
}