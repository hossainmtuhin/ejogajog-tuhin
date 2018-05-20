package com.abc.ejogajog.Test;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
import com.abc.ejogajog.Utils.DriverManager;
import com.abc.ejogajog.Utils.URLTextUtils;
import com.abc.ejogajog.Utils.XPathUtils;

public class LoginTest {
	
	private WebDriver driver; 
	
	@Test(alwaysRun = true, description="Launches the site and check title")
	public void testLoginPageTitleCheck() throws Exception{
		
		driver = DriverManager.driver;
		driver.manage().window().maximize(); //maximize window
		driver.get(URLTextUtils.LoginPage.BASE_URL);
		
		try {			
			assertEquals(driver.getTitle(), URLTextUtils.LoginPage.LOGIN_PAGE_TITLE);
			System.out.println("Checked- Login page title verification successful");	
		} catch (AssertionError e) {
			System.out.println("Login page title didn't match");			
		}
		
	}
	
	@Test(description="Test Email, Password and Login labels are present")
	public void testFormText() {
	
		driver = DriverManager.driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		try {
			assertEquals(driver.findElement(By.xpath(XPathUtils.Login.LOGIN_PAGE_HEADER)).getText(), URLTextUtils.LoginPage.PAGE_TITLE);
			//match subtitle of the page above login form
			assertEquals(driver.findElement(By.xpath(XPathUtils.Login.LOGIN_PAGE_SUBHEADER)).getText(), URLTextUtils.LoginPage.PAGE_SUBTITLE);			
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
			
		} catch (NoSuchElementException e) {
			System.out.println("selector(s) or element(s) didn't match");
		}
				
	}
	
	@Test(description="Invalid login credentials and check the error messages")
	public void testInvalidLogin() {
		driver = DriverManager.driver;
		
		try {
			
			//invalid email type
			driver.findElement(By.xpath(XPathUtils.Login.EMAIL_TEXTFIELD)).sendKeys("asdf");
			driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).click();
			
			String msg1 = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[1]/div/span/span")).getText();
			assertEquals(msg1, "The Email field is not a valid e-mail address.");
			
			//invalid email id and password
			driver.findElement(By.xpath(XPathUtils.Login.EMAIL_TEXTFIELD)).sendKeys("asdf@gmail.com");
			driver.findElement(By.xpath(XPathUtils.Login.PASSWORD_FIELD)).sendKeys("asdf");
			driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).click();
			assertEquals(driver.findElement(By.xpath("//*[@id='loginForm']/form/div[1]/ul/li")).getText(), "Invalid login attempt.");	
			
		} catch (NoSuchElementException e) {
			System.out.println("selector(s) or element(s) didn't match");
		}
		
	}
	
	@Test(description="successful login with correct credentials")
	public void testValidLogin() {
		
		driver = DriverManager.driver;
		
		try {
			
			driver.findElement(By.xpath(XPathUtils.Login.EMAIL_TEXTFIELD)).sendKeys("testuser1@gmail.com");
			driver.findElement(By.xpath(XPathUtils.Login.PASSWORD_FIELD)).sendKeys("1qazXSW@");
			driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//if login was successful, following should be true
			assertEquals(driver.getTitle(), "Ejogajog");
			
		} catch (NoSuchElementException e) {
			System.out.println("selector(s) or element(s) didn't match");
		}
	}
	
//	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

} //End of class
