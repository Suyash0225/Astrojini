package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	 public static String getScreenshot(WebDriver driver ,String testName) throws IOException {
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File source = screenshot.getScreenshotAs(OutputType.FILE);
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        String filename = testName + "_" + timestamp + ".png";
	        File destination = new File("C:\\Users\\Suyash\\eclipse-workspace\\Astrojini\\src\\test\\java\\screenshots\\"+ filename);
			FileUtils.copyFile(source, destination);
			return destination.getAbsolutePath();
	    }
}
