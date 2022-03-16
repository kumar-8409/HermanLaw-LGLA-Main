package com.qa.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.Base;

public class Dashboard extends Base {

	public Dashboard() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}







	WebElement Email = driver.findElement(By.id("Email"));
	WebElement Password = driver.findElement(By.id("Password"));
	WebElement Login = driver.findElement(By.xpath("//input[@class='btn btn-lg login-btn']"));


	@BeforeTest
	public void SetUp() {
		System.out.println("Starting Test On Chrome Browser");
	}

	@Test(priority = 1)
	public void VerifyTitle() throws InterruptedException {
		
		Thread.sleep(3000);
		String testTitle = "Snapshot";
		String originalTitle = driver.getTitle();

		System.out.println(originalTitle);
		Assert.assertEquals(originalTitle, testTitle);
	}

	@Test(priority = 2)
	public void VerifyLogin() {

		Email.sendKeys("david01@yopmail.com");
		Password.sendKeys("Test@1234");
		Login.click();
		System.out.println("Login Succesfully");

	}

	@Test(priority = 3)
	public void verifyDashboardTitle() {
		String oringinalTitle = driver.getTitle();
		String ExpectedTitle = "Snapshot | Dashboard";
		assertEquals(oringinalTitle, ExpectedTitle);
		System.out.print(oringinalTitle);
	}


	@Test(priority = 4) 
	public void verifyMenuCollapse() { 
		driver.findElement(By.xpath("//button[@id='menu-toggle-2']//i[@class='fa fa-bars']")).click();
		System.out.print("Collapse");

	}

	@Test(priority = 5) 
	public void verifyMenuExpand() throws InterruptedException { 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='menu-toggle-2']//i[@class='fa fa-bars']")).click();
		System.out.print("Expand");

	}

	@Test(priority = 6)
	public void verifySearchbyClientName() throws InterruptedException {
		WebElement clientName = driver.findElement(By.xpath("//input[@id=\"ClientName\"]"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		clientName.sendKeys("TestChetuRock");
		search.click();
		Thread.sleep(2000);
		String ExpectedText = "TestChetuRocky Wilson";
		String ActualText = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		assertEquals(ExpectedText, ActualText);
		
	}
	
	
	@Test(priority = 7)
	public void verifySearchbyLocation() throws InterruptedException {
		WebElement Location = driver.findElement(By.id("Location"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		Location.sendKeys("California");
		search.click();
		Thread.sleep(2000);
		String Expected = "California";
		String Actual = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
		assertEquals(Expected, Actual);
		driver.navigate().refresh();
	}

	
	
	@Test(priority = 8)
	public void verifySearchbyParallegal() throws InterruptedException {
		WebElement Paralegal = driver.findElement(By.id("Paralegal"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		Paralegal.sendKeys("Rebecca Pontillo");
		search.click();
		Thread.sleep(2000);
		String text = "Rebecca Pontillo";
		String ExpectedText = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText();
		assertEquals(ExpectedText, text);
		driver.navigate().refresh();
	}
	
	

	@Test(priority = 9)
	public void verifySearchbyStatus() throws InterruptedException {
		WebElement Status = driver.findElement(By.id("Status"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		Status.sendKeys("Close");
		search.click();
		Thread.sleep(2000);
		String text = "Closed";
		String ExpectedText = driver.findElement(By.xpath("//tbody/tr[1]/td[12]")).getText();
		assertEquals(ExpectedText, text);
		driver.navigate().refresh();
	}
	
	
	@Test(priority = 10)
	public void DownloadExcelSheet() throws InterruptedException {
		WebElement Excel = driver.findElement(By.xpath("//span[normalize-space()='Excel']"));
		WebElement CSV=driver.findElement(By.xpath("//span[normalize-space()='CSV']"));
		Excel.click();
		Thread.sleep(2000);
		CSV.click();
		Thread.sleep(2000);
	}
	
	
	
	
	

	
	  @AfterTest public void tearDown() { driver.close(); }
	 

}
