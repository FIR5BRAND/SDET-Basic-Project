package com.sdet.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for browser operations and WebDriver management
 * Provides generic functions to interact with the browser
 */
public class BrowserUtils {

    /**
     * Initialize Chrome WebDriver
     */
    public static WebDriver initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    /**
     * Initialize Firefox WebDriver
     */
    public static WebDriver initializeFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    /**
     * Navigate to a URL
     */
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
        System.out.println("Navigated to: " + url);
    }

    /**
     * Wait for element to be visible and return it
     */
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be clickable and return it
     */
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Click on an element
     */
    public static void clickElement(WebDriver driver, By locator) {
        WebElement element = waitForElementClickable(driver, locator, 10);
        element.click();
        System.out.println("Clicked on element: " + locator.toString());
    }

    /**
     * Enter text in an input field
     */
    public static void enterText(WebDriver driver, By locator, String text) {
        WebElement element = waitForElementVisible(driver, locator, 10);
        element.clear();
        element.sendKeys(text);
        System.out.println("Entered text '" + text + "' in element: " + locator.toString());
    }

    /**
     * Check if element is displayed
     */
    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            WebElement element = waitForElementVisible(driver, locator, 10);
            boolean isDisplayed = element.isDisplayed();
            System.out.println("Element " + locator.toString() + " is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Element " + locator.toString() + " is NOT displayed");
            return false;
        }
    }

    /**
     * Get text from an element
     */
    public static String getElementText(WebDriver driver, By locator) {
        WebElement element = waitForElementVisible(driver, locator, 10);
        String text = element.getText();
        System.out.println("Element text: " + text);
        return text;
    }

    /**
     * Close the browser
     */
    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }

    /**
     * Handle popup/modal by clicking on close button
     */
    public static void closePopupIfPresent(WebDriver driver, By closeButtonLocator) {
        try {
            WebElement closeButton = driver.findElement(closeButtonLocator);
            if (closeButton.isDisplayed()) {
                closeButton.click();
                System.out.println("Popup closed");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("No popup found or already closed");
        }
    }
}
