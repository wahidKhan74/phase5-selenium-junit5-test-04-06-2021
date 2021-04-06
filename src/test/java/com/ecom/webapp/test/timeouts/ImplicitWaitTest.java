package com.ecom.webapp.test.timeouts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class ImplicitWaitTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;
	

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		// implicit wait  : The implicit in selenium is used for tell the web driver to wait for 
		// a certain time before it throw a "No Such element exception" default implicit setting is 0.
		// Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName(" Amazon Test :: Mobile Link Verification")
	void testMobileNavigationLink() {
		// find mobile link
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		
		// test evaluation
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());
		mobileLink.click();
		
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}
	
	@Test
	@DisplayName(" Amazon Test :: Todays deal Link Verification")
	void testTodaysDealNavigationLink() {
		// find todays deal link
		WebElement todayLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		// test evaluation
		assertTrue(todayLink.isDisplayed());
		assertTrue(todayLink.isEnabled());
		todayLink.click();
		String expected = "Amazon.in Today's Deals: Great Savings. Every Day.";
		assertEquals(expected, driver.getTitle());
	}

}
