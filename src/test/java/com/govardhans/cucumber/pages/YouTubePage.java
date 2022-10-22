package com.govardhans.cucumber.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class YouTubePage {

    @Autowired
    private WebDriver driver;

    public void launchVideo(String url) {
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
            final WebElement cookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#button[aria-label='Accept the use of cookies and other data for the purposes described']")));
            cookiesButton.click();
        } catch (Exception ex) {
            log.error("Cookies button not appeared");
        }
    }
}
