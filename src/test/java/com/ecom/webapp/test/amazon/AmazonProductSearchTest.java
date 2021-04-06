package com.ecom.webapp.test.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonProductSearchTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
//		driver.close();
	}

	@Test
	@DisplayName("Amazon Product Search Test : search for Iphone 12")
	void testForSearchProductIphone12() {

		// find search box / input
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		assertTrue(searchBox.isDisplayed());

		// enter data into search field
		searchBox.sendKeys("Iphone 12");
		searchBox.submit();

	}

	@Test
	@DisplayName("Amazon Product Search Test : search for Iphone 11")
	void testForSearchProductIphone11() {

		// find search box / input
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		assertTrue(searchBox.isDisplayed());

		// enter data into search field
		searchBox.sendKeys("Iphone 11 pro");
		searchBox.submit();

	}

	@Test
	@DisplayName("Amazon Product Search Test : search for Iphone 12 choose 1st in list")
	void testForSearchProductIphoneChooseFirstProduct() {

		// 1. find search box / input
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		assertTrue(searchBox.isDisplayed());

		// enter data into search field
		searchBox.sendKeys("Iphone 12");
		searchBox.submit();

		
		WebElement firstMobile = driver.findElement(By.cssSelector("div.s-result-item:nth-child(2) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(2) > a:nth-child(1)"));
		assertTrue(firstMobile.isDisplayed());
		firstMobile.click();

	}

}
