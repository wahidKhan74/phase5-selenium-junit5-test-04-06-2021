package com.ecom.webapp.test.extenalwebelements;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BrowserWindowPopup {

	final String siteURL = "https://www.amazon.in/";
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
	@DisplayName("Amazon Test :: Amazon Location Popup Window")
	void testToVerifyLocationBrowserWindowPopup() throws InterruptedException {
		
		Thread.sleep(3000);
		// open window popup
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		
		// switch main window to popup
		Thread.sleep(3000);
		// 1. find main window
		String mainWindow = driver.getWindowHandle();
		
		// 2. get sub windows list then switch to new window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String chidWindow = itr.next();
			// switch to child window
			driver.switchTo().window(chidWindow);
			
			// find popup element
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);
	}

}
