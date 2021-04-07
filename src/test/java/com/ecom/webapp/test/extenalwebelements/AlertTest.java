package com.ecom.webapp.test.extenalwebelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AlertTest {

	final String siteURL = "file:///home/wahidkhan74gmai/Selenium-Workspace/phase5-selenium-junit5-test-04-06-2021/static/external-web-alert.html";
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
	@DisplayName("Test :: JavaScript Simple Alert window test")
	void testAlertDailogWindow() throws InterruptedException {
		// open alert box
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Test :: JavaScript Confirmation Alert window test with Accept")
	void testConfirmationDailogWindowWithAccpet() throws InterruptedException {
		// open alert box
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to confirm alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Test :: JavaScript Confirmation Alert window test with Cancel")
	void testConfirmationDailogWindowWithDimiss() throws InterruptedException {
		// open alert box
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to confirm alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	@Test
	@DisplayName("Test :: JavaScript Prompt Alert window test with Accept")
	void testPromptDailogWindowWithDimiss() throws InterruptedException {
		// open alert box
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		confirmButton.click();
		
		// switch to confirm alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Test :: JavaScript Prompt Alert window test with input data")
	void testPromptDailogWindowWithInputData() throws InterruptedException {
		// open alert box
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		confirmButton.click();
		
		// switch to confirm alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		alert.sendKeys("Iron Man");
		Thread.sleep(3000);
		alert.accept();
	}

}
