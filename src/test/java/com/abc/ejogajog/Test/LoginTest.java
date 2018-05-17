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
		//check for the login form headers
		assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/div[2]/div/h2")).getText(), "Log in(beta).");
		assertEquals(driver.findElement(By.xpath("//*[@id='loginForm']/form/h4")).getText(), "Use an account to log in.");
		
		//check for field labels
		//assertEquals(actual, expected)
		assertEquals(driver.findElement(By.xpath(XPathUtils.Login.USER_NAME_LABEL)).getText(), "Email");
		assertEquals(driver.findElement(By.xpath(XPathUtils.Login.PASSWORD_LABEL)).getText(), "Password");
		
		//check for login button
		boolean loginButtonIsPresent = driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).isDisplayed();
	    if(loginButtonIsPresent==true){
	    	System.out.println("Log in button is present");
	    } else {
	    	System.out.println("Log in button isn't present");
	    }
	}
	
	@Test(description="Invalid login credentials and check the error messages")
	public void testInvalidLogin() {
		//invalid email type
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("asdf");
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		
		String msg1 = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[1]/div/span/span")).getText();
		assertEquals(msg1, "The Email field is not a valid e-mail address.");
		
		//invalid email id and password
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("asdf@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("asdf");
		
		String msg2 = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[1]/ul/li")).getText();
		assertEquals(msg2, "Invalid login attempt.");	
	}
	
	@Test(description="successful login with correct credentials")
	public void testValidLogin() {
		
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("testuser1@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1qazXSW@");
		
		//if login was successful, following should be true
		assertEquals(driver.getTitle(), "Ejogajog");
	}
	
	@Test(description="check the map is showing on the page")
	public void checkMap() {
		
	}
}
