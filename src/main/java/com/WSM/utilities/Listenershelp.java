package com.WSM.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.WSM.Reports.ExtentReportSetup;
import com.WSM.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Listenershelp extends TestBase implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getMethod().getMethodName() + "Test is passed");
		try {
			test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64()).build());
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	@Override
	public void onTestFailure(ITestResult result) {

		
		test.log(Status.FAIL, result.getMethod().getMethodName() + "Test is Failed");
		try {
			test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64()).build());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName() + "Test is Skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Not required

	}
	@Override
	public void onStart(ITestContext context) {
		reports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +"_Test Report.html");
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("CreatedBy", "Ramesh Rao");
	}
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}
