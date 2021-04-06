package com.ecom.webapp.test.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonHomePageTest {

	// 1. formulate a test domain url
	final String siteURL = "https://www.amazon.in/";

	// 2. locate web driver
	final String driverPath = "driver/geckodriver";

	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// 3. set selenium properties
		System.setProperty("webdriver.gecko.driver", driverPath);

		// 4. Instantiate selenium web driver
		driver = new FirefoxDriver();

		// 5. launch browser
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		// 7. close browser window
		driver.close();
	}

	@Test
	void testAmazonHomePageTitle() {
		// 6. perform test evaluation
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expectedTitle, driver.getTitle());
	}
	
	@Test
	void testAmazonHomePageSourceURL() {
		// 6. perform test evaluation
		assertEquals(siteURL, driver.getCurrentUrl());
	}

}
