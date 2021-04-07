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

class CheckBoxTest {

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
	@DisplayName("Test : To  verify checkbox exist.")
	void testToVerifyCheckBoxExist() {

		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());

		// default selected checkbox
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		assertEquals(true, checkBox2.isSelected());

		WebElement checkBox3 = driver.findElement(By.id("vehicle3"));
		assertEquals(true, checkBox3.isDisplayed());
		assertEquals(true, checkBox3.isEnabled());
		assertEquals(false, checkBox3.isSelected());

	}
	
	@Test
	@DisplayName("Test : To  verify checkbox clicked.")
	void testToVerifyCheckBoxSelect() throws InterruptedException {

		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		
		// select check box
		checkBox1.click();
		Thread.sleep(2000);
		assertEquals(true, checkBox1.isSelected());

	}
	
	@Test
	@DisplayName("Test : To  verify checkbox clicked for deselect.")
	void testToVerifyCheckBoxDeSelect() throws InterruptedException {

		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		
		// deselect check box
		checkBox2.click();
		Thread.sleep(2000);
		assertEquals(false, checkBox2.isSelected());

	}

}
