package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageResourses;
import pageObjects.LoginPageResourses;
import resources.Base;

public class ValidateNavigationBar extends Base {
	WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		driver = initializeDriver();
		driver.manage().deleteAllCookies();
		driver.get(getURLType());
	}
	@Test
	public void validateBarNavigation() throws IOException {
		driver.get(getURLType());
		HomePageResourses res = new HomePageResourses(driver);
		boolean cont = res.getNavigationBar().isDisplayed();
		Assert.assertTrue(cont);
		log.info("Navigation Bar is displayed");
	}
	@AfterTest
	public void exitFromBrowser() throws IOException {
		driver.close();
	}
}
