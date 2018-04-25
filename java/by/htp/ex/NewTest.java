package by.htp.ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {

	private static Logger logger = LogManager.getLogger();

	@Test
	public void f() {
		Assert.assertTrue(true, "its not true");
		logger.info("info message");
		logger.trace("trace message");
		logger.debug("debug message");
		logger.warn("warn message");
		logger.error("error message");
	}
}
