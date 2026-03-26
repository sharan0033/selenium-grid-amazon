package com.automation;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTest {

    @Parameters("browser")
    @Test
    public void testAmazon(String browser) throws Exception {
        WebDriver driver = null;
        URL gridURL = new URL("http://localhost:4444/wd/hub");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new RemoteWebDriver(gridURL, new ChromeOptions());
                break;
            case "firefox":
                driver = new RemoteWebDriver(gridURL, new FirefoxOptions());
                break;
            case "edge":
                driver = new RemoteWebDriver(gridURL, new EdgeOptions());
                break;
            default:
                throw new Exception("Browser not supported: " + browser);
        }

        try {
            driver.get("https://www.amazon.in/");
            System.out.println(browser + " Title: " + driver.getTitle());
        } finally {
            if (driver != null) driver.quit();
        }
    }
}