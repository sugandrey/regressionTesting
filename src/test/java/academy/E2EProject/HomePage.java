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
import pageObjects.ResetPasswordPage;
import resources.Base;

public class HomePage extends Base{
	WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException {
		driver = initializeDriver();
		driver.manage().deleteAllCookies();	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String login, String password, String text) throws IOException, InterruptedException {
		driver.get(getURLType());
		HomePageResourses res = new HomePageResourses(driver);
		LoginPageResourses logPage = res.pressLoginButton();
		logPage.emailPrompt().sendKeys(login);//(getLoginType());
		logPage.passwordPrompt().sendKeys(password); //(getPasswordType());
		//System.out.println(text);
		log.info(text);
		logPage.submitButton().click();
		Thread.sleep(3000);
		ResetPasswordPage rpp = logPage.forgotButtonPush();
		rpp.emailClick().sendKeys(getEmail());
		rpp.sibmitButtonClick().click();
	}
	@DataProvider
	public Object[][] getData() {
		// row stands for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nondestricteduser@rw.com";
		data[0][1] = "123456";
		data[0][2] = "Nonrestricted user";
		//1st row
		data[1][0] = "destricteduser@rw.com";
		data[1][1] = "654321";
		data[1][2] = "Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void exitFromBrowser() throws IOException {
		driver.close();
	}

}
