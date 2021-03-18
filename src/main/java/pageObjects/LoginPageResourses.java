package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageResourses {
	
	private WebDriver driver;

	public LoginPageResourses(WebDriver driver) {
		this.driver = driver;
	}
	By emailAddress = By.id("user_email");
	By password = By.cssSelector("input[id='user_password']");
	By submitButton = By.xpath("//input[@type='submit']");
	By forgotPassword = By.cssSelector(".link-below-button");
	
	public WebElement emailPrompt() {
		return driver.findElement(emailAddress);
	}
	public WebElement passwordPrompt() {
		return driver.findElement(password);
	}
	public WebElement submitButton() {
		return driver.findElement(submitButton);
	}
	public ResetPasswordPage forgotButtonPush() {
		driver.findElement(forgotPassword).click();
		return new ResetPasswordPage(driver);	 
	}
}
