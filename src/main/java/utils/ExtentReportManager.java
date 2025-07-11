package utils;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	@Test
	public static ExtentReports setupReport() {
		String path = System.getProperty("user.dir")+ "/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Astrojini ");
		reporter.config().setDocumentTitle("Test Report");
		ExtentReports extent =  new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Engineer", "Suyash");
		return extent;
	}

}
