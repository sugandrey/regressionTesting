package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	private WebDriver driver;
	private Properties prop = new Properties();

	public WebDriver initializeDriver() throws IOException {

		//FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
	
		//String browserName = System.getProperty("browser");
//		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
			//driver = new ChromeDriver();
			
			
			if(browserName.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
		
				if(browserName.contains("headless")) {
					options.addArguments("headless");
				}
				driver = new ChromeDriver(options);
//			}
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\Downloads\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\Users\\user\\Downloads\\operadriver.exe");
			driver = new OperaDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getURLType() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String urlName = prop.getProperty("url");
		return urlName;

	}

	public String getLoginType() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String login = prop.getProperty("login");
		return login;

	}
	
	public String getPasswordType() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String password = prop.getProperty("password");
		return password;

	}

	public String getExpectedTextOnHomePage() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String expectedText = prop.getProperty("expectedText");
		return expectedText.toUpperCase();
	}
	public String getEmail() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String email = prop.getProperty("email");
		return email.toUpperCase();
	}
	public String getTitleOnHomePage( ) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String title = prop.getProperty("title");
		return title;
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		String destinationFile = "C:\\Users\\user\\eclipse-workspaceNewProjects\\E2EProject\\reports\\"+testCaseName +".png";
		FileUtils.copyFile(source, new File(destinationFile)); 
		return destinationFile;
	}
}
