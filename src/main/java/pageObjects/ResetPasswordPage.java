package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage {
	
	private WebDriver driver;

	public ResetPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	By email = By.id("user_email");
	By submit = By.cssSelector("input[type='submit']");
	
	public WebElement emailClick() {
		return driver.findElement(email);
	}
public WebElement sibmitButtonClick() {
	return driver.findElement(submit);
}

}

