package by.htp.ex.listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import webDriverInitializator.WebDriverInitializator;

public class ScreenshotOnFailListener implements ITestListener, ISuiteListener,
		IInvokedMethodListener {

	private static Logger logger = LogManager.getLogger();

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		logger.info("beforeInvocation");

	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		logger.info("afterInvocation");

	}

	public void onTestStart(ITestResult result) {
		logger.info("onTestStart");

	}

	public void onTestSuccess(ITestResult result) {
		logger.info("onTestSuccess");

	}

	public void onTestFailure(ITestResult result) {
		logger.info("onTestFailure");
		takeScreenshot();
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("onTestSkipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("onTestFailedButWithinSuccessPercentage");

	}

	public void onStart(ITestContext context) {
		logger.info("onStart");

	}

	public void onFinish(ITestContext context) {
		logger.info("onFinish");

	}

	public void onStart(ISuite suite) {
		logger.info("onStart");
	}

	public void onFinish(ISuite suite) {
		logger.info("onFinish");

	}

	private void takeScreenshot() {
		File screenCapture = ((TakesScreenshot) WebDriverInitializator
				.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File("./screenshots/screenshot.png");
			FileUtils.copyFile(screenCapture, f);
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			Reporter.log("<img src=\"" + f.getAbsolutePath() + "\"/>");
			Reporter.log("<p><img width=\"1024\" src=\"" + f.getAbsoluteFile()
					+ "\" alt=\"screenshot at \"/></p></a><br />");
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: "
					+ e.getLocalizedMessage());
		}

	}
}
