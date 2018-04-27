package by.htp.ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webDriverInitializator.WebDriverInitializator;

public class NewTest {
	private WebDriver driver;
	private String url = "https://www.onliner.by/";
	private static Logger logger = LogManager.getLogger();
	By btn = By.xpath("");
	WebElement fail;

	@BeforeTest
	public void s() {
		driver = WebDriverInitializator.getDriver();
		driver.get(url);
		logger.info("onliner.by");
	}

	@Test
	public void f() {
		fail = driver.findElement(btn);
		fail.click();
	}
	
	@AfterTest
	public void r(){
		driver.close();
	}

}
