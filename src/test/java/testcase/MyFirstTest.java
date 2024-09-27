package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTest {

	public static void main(String[] args) {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // properties
		driver.get("https://www.zoho.com/"); //properties
		driver.findElement(By.linkText("Sign In")).click(); // locators --properties
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("godwitusglobal@gmail.com"); // 
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("December25!");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		
	}

}
