package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;
import utils.Screenshot;

public class Baseclass {

    protected WebDriver driver;
    protected static Properties prop;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.setupReport();  
        System.out.println("Extent Report initialized from manager.");

    }

    @BeforeMethod
    public void setup(Method method) throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(Paths.get(System.getProperty("user.dir"),
                "src", "test", "java", "resourse", "Global.properties").toString());
        prop.load(file);
        test = extent.createTest(method.getName());
        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1440, 900));
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }
    }

    public String navigateTo(String key) {
        String url = prop.getProperty(key);
        if (url == null) {
            throw new RuntimeException("Missing key: " + key + " in Global.properties");
        }
        driver.get(url);
        return url;
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE && driver != null && isDriverAlive(driver)) {
                String path = Screenshot.getScreenshot(driver, result.getName());
                System.out.println("📸 Capturing screenshot at: " + path);
                test.fail("Test Failed: " + result.getName())
                    .addScreenCaptureFromPath(path);  // ✅ Add screenshot to report
            }
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }


    public boolean isDriverAlive(WebDriver driver) {
        try {
            return ((RemoteWebDriver) driver).getSessionId() != null;
        } catch (Exception e) {
            return false;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
            System.out.println("Extent report flushed and saved.");
        }
    }
}
