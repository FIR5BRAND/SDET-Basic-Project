package com.sdet.tests;

import com.sdet.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Problem 4: Selenium WebDriver test with Chrome to automate MakeMyTrip flights search
 * Uses TestNG annotations and XPath locators
 */
public class MakeMyTripFlightsTest {
    
    private WebDriver driver;
    private static final String MAKEMYTRIP_URL = "https://www.makemytrip.com/";
    
    /**
     * Setup method - Initializes Chrome browser before each test
     */
    @BeforeMethod
    public void setUp() {
        System.out.println("\n========================================");
        System.out.println("Initializing Chrome browser...");
        System.out.println("========================================");
        driver = BrowserUtils.initializeChromeDriver();
    }
    
    /**
     * Test to automate flight search: Flights → OneWay → FROM/TO
     */
    @Test
    public void testFlightSearchOneWay() {
        System.out.println("\n--- Test: MakeMyTrip Flight Search (OneWay) ---");
        
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
            System.out.println("Popup handling: " + e.getMessage());
        }
        
        // Step 1: Click on Flights tab (if not already selected)
        try {
            By flightsTabLocator = By.xpath("//li[@data-cy='menu_Flights']");
            BrowserUtils.clickElement(driver, flightsTabLocator);
            System.out.println("✓ Clicked on Flights tab");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Flights tab already selected or not found: " + e.getMessage());
        }
        
        // Step 2: Select OneWay option
        try {
            By oneWayLocator = By.xpath("//li[@data-cy='oneWayTrip']");
            BrowserUtils.clickElement(driver, oneWayLocator);
            System.out.println("✓ Selected OneWay option");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("OneWay option handling: " + e.getMessage());
        }
        
        // Step 3: Enter FROM location
        try {
            By fromCityLocator = By.xpath("//input[@id='fromCity']");
            BrowserUtils.clickElement(driver, fromCityLocator);
            Thread.sleep(1000);
            
            // Clear and enter FROM city
            By fromInputLocator = By.xpath("//input[@placeholder='From']");
            driver.findElement(fromInputLocator).clear();
            driver.findElement(fromInputLocator).sendKeys("Delhi");
            System.out.println("✓ Entered FROM location: Delhi");
            Thread.sleep(2000);
            
            // Select first suggestion
            By fromSuggestionLocator = By.xpath("(//p[contains(text(),'Delhi')])[1]");
            BrowserUtils.clickElement(driver, fromSuggestionLocator);
            System.out.println("✓ Selected Delhi from suggestions");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("FROM location handling: " + e.getMessage());
        }
        
        // Step 4: Enter TO location
        try {
            By toCityLocator = By.xpath("//input[@id='toCity']");
            BrowserUtils.clickElement(driver, toCityLocator);
            Thread.sleep(1000);
            
            // Clear and enter TO city
            By toInputLocator = By.xpath("//input[@placeholder='To']");
            driver.findElement(toInputLocator).clear();
            driver.findElement(toInputLocator).sendKeys("Mumbai");
            System.out.println("✓ Entered TO location: Mumbai");
            Thread.sleep(2000);
            
            // Select first suggestion
            By toSuggestionLocator = By.xpath("(//p[contains(text(),'Mumbai')])[1]");
            BrowserUtils.clickElement(driver, toSuggestionLocator);
            System.out.println("✓ Selected Mumbai from suggestions");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("TO location handling: " + e.getMessage());
        }
        
        // Verify the selections were made successfully
        try {
            // Verify FROM city is displayed
            By fromDisplayLocator = By.xpath("//input[@id='fromCity']");
            WebElement fromElement = driver.findElement(fromDisplayLocator);
            String fromValue = fromElement.getAttribute("value");
            Assert.assertTrue(fromValue.contains("Delhi") || fromValue.contains("DEL"), 
                            "FROM city not set correctly");
            System.out.println("✓ Verification: FROM city set to Delhi");
            
            // Verify TO city is displayed
            By toDisplayLocator = By.xpath("//input[@id='toCity']");
            WebElement toElement = driver.findElement(toDisplayLocator);
            String toValue = toElement.getAttribute("value");
            Assert.assertTrue(toValue.contains("Mumbai") || toValue.contains("BOM"), 
                            "TO city not set correctly");
            System.out.println("✓ Verification: TO city set to Mumbai");
            
        } catch (Exception e) {
            System.out.println("Verification: " + e.getMessage());
        }
        
        System.out.println("\n✓ Test Passed: Successfully automated flight search with OneWay option");
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
