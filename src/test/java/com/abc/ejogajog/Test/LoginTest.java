package com.abc.ejogajog.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.abc.ejogajog.Utils.DriverManager;
import com.abc.ejogajog.Utils.URLTextUtils;

public class LoginTest {
	
	private WebDriver driver = null;
	
	@Test
	public void testLoginPageTitleCheck() {
		
		driver = DriverManager.driver;
		driver.get(URLTextUtils.LoginPage.BASE_URL);
		
	}
	
	@Test
	public void testInvalidLogin() {
		
	}
	
	@Test
	public void testValidLogin() {
		
	}
	
}
