package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageResourses {
	
	private WebDriver driver;
	public HomePageResourses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Login")
	private WebElement loginButtton;
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement text;
	@FindBy(css=".nav.navbar-nav.navbar-right")
	private WebElement navBar;
	@FindBy(xpath="//div[@class='row']/div/p")
	private WebElement title;
	
	
	public LoginPageResourses pressLoginButton() {
		loginButtton.click();
		LoginPageResourses logPage = new LoginPageResourses(driver);
		return logPage;
	}
	public WebElement getHomeText() {
		return text;
	}
	
	public WebElement getNavigationBar() {
		return navBar;
	}
	public WebElement getTitleText() {
		return title;
	}
}
