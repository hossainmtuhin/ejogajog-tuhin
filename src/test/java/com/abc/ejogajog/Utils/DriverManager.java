package com.abc.ejogajog.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverManager {
	
	static{
//		System.setProperty("webdriver.gecko.driver","D:/_automation/_software/_tools/geckodriver-v0.20.1-win64/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:/_automation/_software/_tools/chromedriver_win32/chromedriver.exe");
	}
//	public static WebDriver driver = new FirefoxDriver();
	public static WebDriver driver = new ChromeDriver();
	
	@Test
	public void driverexecution()
	{
		System.out.println("Driver Executed!!");
	}
	private DriverManager() {
		
	}
	
}