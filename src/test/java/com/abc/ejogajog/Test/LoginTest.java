package com.abc.ejogajog.Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.abc.ejogajog.Utils.DriverManager;
import com.abc.ejogajog.Utils.URLTextUtils;
import com.abc.ejogajog.Utils.XPathUtils;

public class LoginTest {
	
	public static WebDriver driver; 
	
	@Test(alwaysRun = true, description="Launches the site and check title")
	public void testLoginPageTitleCheck() throws Exception{
			
		driver = DriverManager.driver;
		driver.manage().window().maximize(); //maximize window
		driver.get(URLTextUtils.LoginPage.BASE_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(driver.getTitle(), URLTextUtils.LoginPage.LOGIN_TEST_TITLE);
		System.out.println("Checked- Login page title verification successful");	
		System.out.println("driver: " +driver);
	}
	
//	@Test(description="Test Email, Password and Login are present")
	public void testFormText() {
		//check for the login form headers
		driver = DriverManager.driver;
		String pageTitle = driver.findElement(By.xpath("//div[@class='row vertical-align']//div/h2")).getText();
		System.out.println(pageTitle);
		assertEquals(pageTitle, "Log in(beta).");
		assertEquals(driver.findElement(By.xpath("//*[@id='loginForm']/form/h4")).getText(), "Use an account to log in.");
		
		//check for field labels
		//assertEquals(actual, expected)
		assertEquals(driver.findElement(By.xpath(XPathUtils.Login.USER_NAME_LABEL)).getText(), "Email");
		assertEquals(driver.findElement(By.xpath(XPathUtils.Login.PASSWORD_LABEL)).getText(), "Password");
		
	}
	
//	@Test(description="Invalid login credentials and check the error messages")
	public void testInvalidLogin() {
		driver = DriverManager.driver;
		//invalid email type
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("asdf");
		driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).click();
		
		String msg1 = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[1]/div/span/span")).getText();
		assertEquals(msg1, "The Email field is not a valid e-mail address.");
		
		//invalid email id and password
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("asdf@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("asdf");
		driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).click();
		String msg2 = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[1]/ul/li")).getText();
		assertEquals(msg2, "Invalid login attempt.");	
	}
	
	@Test(description="successful login with correct credentials")
	public void testValidLogin() {
		
		driver = DriverManager.driver;
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("testuser1@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1qazXSW@");
		driver.findElement(By.xpath(XPathUtils.Login.BTN_LOGIN)).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//if login was successful, following should be true
		assertEquals(driver.getTitle(), "Ejogajog");
	}
	
	@Test(description="check the map is showing on the page")
	public void checkMap() throws IOException {
		
		driver = DriverManager.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("F:\\automation_\\_projects\\ejogajog-tuhin\\image\\screenshot_" + System.currentTimeMillis()+ ".png"));
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
