package com.ecom.webapp.test.webelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class SelectDropDownTest {

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
	@DisplayName("Test : To  verify select dropdown exist.")
	void testToVerifySelectDropDownExist() {
		WebElement select = driver.findElement(By.id("vehicle"));
		assertEquals(true, select.isDisplayed());
		assertEquals(true, select.isEnabled());
	}
	
	@Test
	@DisplayName("Test : To  verify first select option from dropdown.")
	void testToVerifyFirstSelectOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicleSelect = new Select(select);
		
		// select bike as selected option
		vehicleSelect.selectByVisibleText("Bike");
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals(" Bike ", selectedOption.getText());	
		Thread.sleep(2000);
	}
	
	@Test
	@DisplayName("Test : To  verify Train select option from dropdown.")
	void testToVerifyTrainSelectOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicleSelect = new Select(select);
		
		// select bike as selected option
		vehicleSelect.selectByVisibleText("Train");
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals(" Train ", selectedOption.getText());	
		Thread.sleep(2000);
	}
	
	@Test
	@DisplayName("Test : To  verify Index based select option from dropdown.")
	void testToVerifyIndexSelectOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicleSelect = new Select(select);
		
		// select index  as 3 selected option
		vehicleSelect.selectByIndex(3);;
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals(" Airplane ", selectedOption.getText());	
		Thread.sleep(2000);
	}
	
	
	@Test
	@DisplayName("Test : To  verify value based select option from dropdown.")
	void testToVerifyValueSelectOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicleSelect = new Select(select);
		
		// select value attribute selected option
		vehicleSelect.selectByValue("car");
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals(" Car ", selectedOption.getText());	
		Thread.sleep(2000);
	}

}
