package com.inv.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest {
	protected WebDriver driver;
	protected Properties prop = new Properties();
	// private static WebDriver driver;

	@Test(priority = 1)
	public void Loginvalidation() throws IOException, Exception {

		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Desktop//chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		
		options.addArguments("window-size=1366,768");
		driver = new ChromeDriver(options);
		// create a object for a property class
		FileInputStream file = new FileInputStream("D:\\Inv_Login\\src\\main\\java\\com\\inv\\Login\\LoginData");
		System.out.println("am in maven project");
		// method is pass to property file
		prop.load(file);
		driver.get(prop.getProperty("url"));
		//driver.findElement(By.id(prop.getProperty("Id_id"))).sendKeys(prop.getProperty("loginid"));
		driver.findElement(By.id(prop.getProperty("Pswd"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(1000);
		options.addArguments("screenshot");
		
		File locatefolder = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(locatefolder, new File("C:\\Users\\Admin\\git\\FirstGit\\Inv_Login\\ss\\invlogin.png"));
		System.out.println("captured");
	}

}
