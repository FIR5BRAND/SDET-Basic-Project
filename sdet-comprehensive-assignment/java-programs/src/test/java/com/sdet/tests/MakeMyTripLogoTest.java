package com.sdet.tests;

import com.sdet.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Problem 3: Selenium WebDriver test with Firefox to verify MakeMyTrip logo
 * Uses TestNG annotations for test management
 */
public class MakeMyTripLogoTest {
    
    private WebDriver driver;
    private static final String MAKEMYTRIP_URL = "https://www.makemytrip.com/";
    
    /**
     * Setup method - Initializes Firefox browser before each test
     */
    @BeforeMethod
    public void setUp() {
        System.out.println("\n========================================");
        System.out.println("Initializing Firefox browser...");
        System.out.println("========================================");
        driver = BrowserUtils.initializeFirefoxDriver();
    }
    
    /**
     * Test to verify MakeMyTrip logo is present on the page
     */
    @Test
    public void verifyMakeMyTripLogoIsPresent() {
        System.out.println("\n--- Test: Verify MakeMyTrip Logo ---");
        
        // Navigate to MakeMyTrip website
        BrowserUtils.navigateToUrl(driver, MAKEMYTRIP_URL);
        
        // Wait for page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close any popup if present
        try {
            By closePopupLocator = By.xpath("//span[@class='commonModal__close']");
            BrowserUtils.closePopupIfPresent(driver, closePopupLocator);
        } catch (Exception e) {
            System.out.println("No popup found");
        }
        
        // Multiple possible XPaths for MakeMyTrip logo
        By[] logoLocators = {
            By.xpath("//img[contains(@alt, 'MakeMyTrip')]"),
            By.xpath("//a[contains(@class, 'makemytrip')]"),
            By.xpath("//img[@class='mmtLogo__img']"),
            By.xpath("//a[@class='chNavIcon chNavIcon--mmyt']"),
            By.xpath("//*[contains(@class, 'mmtLogo')]")
        };
        
        boolean logoFound = false;
        String foundLocator = "";
        
        // Try each locator until logo is found
        for (By locator : logoLocators) {
            if (BrowserUtils.isElementDisplayed(driver, locator)) {
                logoFound = true;
                foundLocator = locator.toString();
                System.out.println("✓ MakeMyTrip logo found using: " + foundLocator);
                break;
            }
        }
        
        // Assert that logo is present
        Assert.assertTrue(logoFound, "MakeMyTrip logo is NOT present on the page");
        
        System.out.println("\n✓ Test Passed: MakeMyTrip logo is present on the page");
    }
    
    /**
     * Teardown method - Closes browser after each test
     */
    @AfterMethod
    public void tearDown() {
        System.out.println("\n========================================");
        System.out.println("Closing browser...");
        System.out.println("========================================");
        BrowserUtils.closeBrowser(driver);
    }
}
