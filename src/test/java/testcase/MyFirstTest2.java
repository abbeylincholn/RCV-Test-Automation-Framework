package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadXLSdata;

public class MyFirstTest2 extends BaseTest {
	
	//@Test (dataProvider="testdata")  // this dataprovider was used for the below commented 
	@Test (dataProviderClass=ReadXLSdata.class, dataProvider="bvtdata")  // this is dataprovider to access the data in the excel class
	public static void LoginTest (String username, String password) throws InterruptedException{		
		//waitForElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.linkText(loc.getProperty("signing_link"))).click(); // locators --properties
		Thread.sleep(4000);
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username); // 	
		driver.findElement(By.xpath(loc.getProperty("next_botton"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(4000);		
	}
	
//	@DataProvider(name="testdata")  // we only use to test the hard code for the test. but the best way is external excel data.
//	public Object [][] tData()
//	{
//		return new Object [][] {			
//		{"godwiobal@gmail.com","Decembe25!"},
//		{"godwitulobal@gmail.com","Decer25!"},
//		{"godwitusglal@gmail.com","Dember25!"},
//		{"godwitusglobal@gmail.com","December25!"}
//		};
//	}

}
