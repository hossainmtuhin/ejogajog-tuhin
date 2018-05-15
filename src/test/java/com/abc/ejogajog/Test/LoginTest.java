package com.abc.ejogajog.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.abc.ejogajog.Utils.DriverManager;

public class LoginTest {
	
	private WebDriver driver = null;
	
	@Test
	public void testLoginPageTitleCheck() {
		
		driver = DriverManager.driver;
	}
	
	@Test
	public void testInvalidLogin() {
		
	}
	
	@Test
	public void testValidLogin() {
		
	}
	
}
