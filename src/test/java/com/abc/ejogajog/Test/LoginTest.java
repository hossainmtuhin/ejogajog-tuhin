package com.abc.ejogajog.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.abc.ejogajog.Utils.DriverManager;
import com.abc.ejogajog.Utils.URLTextUtils;
import com.abc.ejogajog.Utils.XPathUtils;

public class LoginTest {
	
	private WebDriver driver = null;
	
	@Test(alwaysRun = true, description="Launches the site and check title")
	public void testLoginPageTitleCheck() throws Exception{
		
		driver = DriverManager.driver;
		driver.get(URLTextUtils.LoginPage.BASE_URL);
		assertEquals(driver.getTitle(), URLTextUtils.LoginPage.LOGIN_TEST_TITLE);
		System.out.println("Checked- Login page title verification successful");		
	}
	
	@Test(description="Test Email, Password and Login are present")
	public void testFormText() {
		
		//assertEquals(actual, expected)
		assertEquals(driver.findElement(By.xpath(XPathUtils.Login.USER_NAME_LABEL)).getText(), "Email");
		assertEquals(driver.findElement(By.xpath(XPathUtils.Login.PASSWORD_LABEL)).getText(), "Password");
		
		boolean loginButtonIsPresent = driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).isDisplayed();
	    if(loginButtonIsPresent==true){
	    	System.out.println("Log in button is present");
	    } else {
	    	System.out.println("Log in button isn't present");
	    }
	}
	
	@Test(description="Invalid login credentials and check the error messages")
	public void testInvalidLogin() {
		
		
	}
	
//	@Test
//	public void testValidLogin() {
//		
//	}
	
}
