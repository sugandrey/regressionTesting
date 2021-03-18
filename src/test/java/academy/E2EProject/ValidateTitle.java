package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageResourses;
import resources.Base;

public class ValidateTitle extends Base {
	        WebDriver driver;
	        HomePageResourses hpr;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void initilize() throws IOException {
		driver = initializeDriver();
		driver.manage().deleteAllCookies();
		driver.get(getURLType());
		hpr = new HomePageResourses(driver);
		log.info("Driver is initiliazed");
		
		
	}
	@Test
	public void validateTitleOnHomePage() throws IOException {
		log.info("Navigated to home page");
		String actualText = hpr.getHomeText().getText();
		Assert.assertEquals(actualText, getExpectedTextOnHomePage());
		log.info("Successfully validated");
	}
	
	@Test
	public void validateHeader() throws IOException {
		log.info("Navigated to home page");
		String text = hpr.getTitleText().getText();
		Assert.assertEquals(text, getTitleOnHomePage());
		log.info("The title succesfully validated");
	}
	@AfterTest
	public void exitFromBrowser() throws IOException {
		driver.close();
	}
}
