package landingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Baseclass {

	protected WebDriver driver;
	
	public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Astrojini Automation Report");
        reporter.config().setDocumentTitle("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA Engineer", "Suyash");
    }
	
	
	
	
	
	@BeforeMethod
	public void setup() throws IOException {
		
	     test = extent.createTest("Login Test");
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Suyash\\eclipse-workspace\\Astrojini\\src\\test\\java\\resourse\\Global.properties");
		prop.load(file);
	    if(prop.getProperty("browser").equals("chrome")) {
	    ChromeOptions options = new ChromeOptions();	
	    options.addArguments("headless");
	    driver = new ChromeDriver(options);
	    driver.manage().window().setSize(new Dimension(1440,900));
	    getLoginPage();
	    }
	    else if(prop.getProperty("browser").equals("edge")) {
	    	System.setProperty("webdriver.edge.driver", "C:\\Users\\Suyash\\eclipse-workspace\\Astrojini\\src\\test\\java\\resourse\\msedgedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	    	getLoginPage();
	    }
	    else if(prop.getProperty("browser").equals("firefox)")){
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Suyash\\eclipse-workspace\\Astrojini\\src\\test\\java\\resourse\\geckodriver.exe");
	    	
	    }
	
}
	public  void getLoginPage() {
		
		driver.get("https://www.astrojini.com/login");
   }
	
	public String getmessage(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		String alerMessage = wait.until(driver -> driver.findElement(locator)).getText();
		return  alerMessage;
	}
	
	public String getScreenshot(String testname) throws IOException {
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Suyash\\eclipse-workspace\\Astrojini\\src\\test\\java\\screenshots\\" + testname + ".png");
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
		
	}
	
	
	
	
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
		
		
		// Capture screenshot if the test fails
    	 if (result.getStatus() == ITestResult.FAILURE) {
    	        String screenshotPath = getScreenshot(result.getName());
    	        test.fail("Test Failed: " + result.getThrowable());
    	        test.addScreenCaptureFromPath(screenshotPath);
    	    }
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
			extent.flush();
		}
    }
	
	
}
