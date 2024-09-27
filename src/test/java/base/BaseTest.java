package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;	
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		if (driver==null) {
			 //System.out.println("The path is: " + System.getProperty("user.dir")); // remove hardcode filepath
			
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			 
			prop.load(fr);
			loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();	// base	
			driver = new ChromeDriver();	// base
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // properties
			driver.get(prop.getProperty("testurl"));
			
		} 
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // properties
			driver.get(prop.getProperty("testurl"));
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // properties
			driver.get(prop.getProperty("testurl"));
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Teardown successful");
		
	}
	
	

//	public static WebElement waitForElement (By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        return element;
//    }
//    
	


}
