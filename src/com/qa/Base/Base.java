package com.qa.Base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	public Base() throws InterruptedException {
	String baseUrl = "https://snapshotlit.com/";

	System.out.println("Launching Google Chrome browser"); 
	System.setProperty("webdriver.chrome.driver", "D:\\Project Detail\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	}
	
	
	

}
