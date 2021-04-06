package com.ecom.webapp.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitLifeCycleMethods {
	
	@BeforeEach
	void setUp() {
		System.out.println(" --- Before Each Test setup is executed ! --- ");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println(" --- After Each Test clean up is executed ! --- ");
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println(" --- Before class is executed ! --- ");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println(" --- After class is executed ! --- ");
	}
	
	@Test
	void testOne() {
		System.out.println(" --- Test One is executed ! --- ");
	}
	
	@Test
	void testTwo() {
		System.out.println(" --- Test Two is executed ! --- ");
	}
	
	@Test
	void testThree() {
		System.out.println(" --- Test Three is executed ! --- ");
	}
}
