package com.abc.ejogajog.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverManager {
	
	static{
		System.setProperty("webdriver.gecko.driver","D:/software_/selenium webdriver tools/geckodriver-v0.16.1-win64/geckodriver.exe");
	}
	public static WebDriver driver = new FirefoxDriver();
	
	@Test
	public void driverexecution()
	{
		System.out.println("Driver Executed!!");
	}
	private DriverManager() {
		
	}
	
}