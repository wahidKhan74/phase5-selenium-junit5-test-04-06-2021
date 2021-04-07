package com.ecom.webapp.test.webelements;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class RadioButtonsTest {

	final String siteURL = "file:///home/wahidkhan74gmai/Selenium-Workspace/phase5-selenium-junit5-test-04-06-2021/static/web-elements.html";
	final String driverPath = "driver/chromedriver";
	WebDriver driver;
	

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();		
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName("Test : To  verify radio button exist.")
	void testToVerifyRadioExist() {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
		
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio3.isDisplayed());
		assertEquals(true, radio3.isEnabled());
		assertEquals(false, radio3.isSelected());
	}
	
	@Test
	@DisplayName("Test : To  verify radio button clicked.")
	void testToVerifyRadioSelected() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		
		// select radio button option
		radio1.click();	
		Thread.sleep(2000);
		assertEquals(true, radio1.isSelected());
		
	}
	
	@Test
	@DisplayName("Test : To  verify radio button 2 clicked.")
	void testToVerifyRadioNextSelected() throws InterruptedException {
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		
		// select radio button option
		radio2.click();	
		Thread.sleep(2000);
		assertEquals(true, radio2.isSelected());
		
	}

}
