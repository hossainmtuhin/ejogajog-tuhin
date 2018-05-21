package com.abc.ejogajog.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.abc.ejogajog.Utils.DriverManager;

public class CheckMap {

	private WebDriver driver;
	
	@Test(description="check the map is showing on the page")
	public void checkMap() throws IOException {
		
		driver = DriverManager.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\_automation\\image\\screenshot_" + System.currentTimeMillis()+ ".jpg"));
				
	}
		
} // End of class
