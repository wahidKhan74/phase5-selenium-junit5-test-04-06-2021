package com.ecom.webapp.test.timeouts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ExplicitWaitTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;
	WebDriverWait wait;
	

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception"
		wait = new WebDriverWait(driver, 20);
		
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName(" Amazon Test :: Mobile Link Verification")
	void testMobileNavigationLink() {
		// Normal way to find web element
		// WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		
		// add explicit condition to find element
		WebElement mobileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(3)")));
		
		// test evaluation
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());
		mobileLink.click();
		
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}

}
