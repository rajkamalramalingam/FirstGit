package com.inv.Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LoginTest {
	protected WebDriver driver;
	protected Properties prop = new Properties();
	// private static WebDriver driver;

	@Test(priority = 1)
	public void Loginvalidation() throws IOException {

		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Desktop//chromedriver.exe");
		driver = new ChromeDriver();

		// create a object for a property class
		FileInputStream file = new FileInputStream("D:\\Inv_Login\\src\\main\\java\\com\\inv\\Login\\LoginData");

		// method is pass to property file
		prop.load(file);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id(prop.getProperty("Id_id"))).sendKeys(prop.getProperty("loginid"));
		driver.findElement(By.id(prop.getProperty("Pswd"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("btnSubmit")).click();

	}

}
