package webDriverInitializator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInitializator {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			InitializeWebDriver();
		}
		return driver;
	}

	private static void InitializeWebDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public static void DestructWebDriver() {
		if (driver != null) {
			driver.close();
		}
	}
}
