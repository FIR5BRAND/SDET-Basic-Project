"""
Problem 9: Selenium WebDriver test with pytest to verify W3Schools logo
Uses pytest fixtures for setup and teardown
"""

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager


@pytest.fixture(scope="function")
def driver():
    """
    Pytest fixture to initialize and teardown Chrome WebDriver
    Runs before and after each test function
    """
    print("\n========================================")
    print("Initializing Chrome browser...")
    print("========================================")
    
    # Initialize Chrome driver using webdriver-manager
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.maximize_window()
    driver.implicitly_wait(10)
    
    yield driver  # This is where the test runs
    
    # Teardown
    print("\n========================================")
    print("Closing browser...")
    print("========================================")
    driver.quit()


def test_w3schools_logo_present(driver):
    """
    Test to verify W3Schools logo is present on the homepage
    
    Args:
        driver: WebDriver fixture
    """
    print("\n--- Test: Verify W3Schools Logo ---")
    
    # Navigate to W3Schools website
    url = "https://www.w3schools.com/"
    driver.get(url)
    print(f"Navigated to: {url}")
    
    # Wait for page to load
    wait = WebDriverWait(driver, 10)
    
    # Multiple possible locators for W3Schools logo
    logo_locators = [
        (By.XPATH, "//a[@class='w3schoolslink' or contains(@class, 'w3-bar-item')]"),
        (By.XPATH, "//img[contains(@alt, 'W3Schools')]"),
        (By.XPATH, "//a[contains(@href, 'w3schools.com')]/img"),
        (By.CSS_SELECTOR, ".w3schoolslink"),
        (By.XPATH, "//*[@id='w3-logo']"),
        (By.XPATH, "//div[contains(@class, 'w3-bar')]//a[contains(text(), 'W3Schools')]")
    ]
    
    logo_found = False
    found_locator = None
    
    # Try each locator until logo is found
    for by, locator in logo_locators:
        try:
            element = wait.until(EC.visibility_of_element_located((by, locator)))
            if element.is_displayed():
                logo_found = True
                found_locator = locator
                print(f"✓ W3Schools logo found using: {by} = '{locator}'")
                break
        except Exception:
            continue
    
    # Assert that logo is present
    assert logo_found, "W3Schools logo is NOT present on the page"
    
    print("\n✓ Test Passed: W3Schools logo is present on the page")


def test_w3schools_page_title(driver):
    """
    Additional test to verify W3Schools page title
    
    Args:
        driver: WebDriver fixture
    """
    print("\n--- Test: Verify W3Schools Page Title ---")
    
    # Navigate to W3Schools website
    url = "https://www.w3schools.com/"
    driver.get(url)
    print(f"Navigated to: {url}")
    
    # Get page title
    page_title = driver.title
    print(f"Page title: {page_title}")
    
    # Verify title contains "W3Schools"
    assert "W3Schools" in page_title, f"Expected 'W3Schools' in title, but got: {page_title}"
    
    print("✓ Test Passed: Page title contains 'W3Schools'")


def test_w3schools_navigation_links(driver):
    """
    Additional test to verify navigation links are present
    
    Args:
        driver: WebDriver fixture
    """
    print("\n--- Test: Verify W3Schools Navigation Links ---")
    
    # Navigate to W3Schools website
    url = "https://www.w3schools.com/"
    driver.get(url)
    print(f"Navigated to: {url}")
    
    wait = WebDriverWait(driver, 10)
    
    # Check for common navigation links
    navigation_links = [
        "Tutorials",
        "Exercises",
        "Services"
    ]
    
    links_found = 0
    for link_text in navigation_links:
        try:
            locator = (By.XPATH, f"//a[contains(text(), '{link_text}')]")
            element = wait.until(EC.presence_of_element_located(locator))
            if element:
                print(f"✓ Navigation link found: {link_text}")
                links_found += 1
        except Exception:
            print(f"✗ Navigation link NOT found: {link_text}")
    
    # Assert that at least some navigation links are present
    assert links_found > 0, "No navigation links found on the page"
    
    print(f"\n✓ Test Passed: Found {links_found} navigation links")


if __name__ == "__main__":
    """Run tests when executed directly"""
    pytest.main([__file__, "-v", "--html=report.html", "--self-contained-html"])
