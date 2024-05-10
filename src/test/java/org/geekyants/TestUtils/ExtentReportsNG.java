package org.geekyants.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject()
	{
		String path = "/Users/amlankumar/eclipse-workspace/AppiumFrameworkDesign/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Amlan_GeekyAnts");
		return extent;
	}

}
