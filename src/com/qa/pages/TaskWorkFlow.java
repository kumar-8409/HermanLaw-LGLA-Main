package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.Base;

public class TaskWorkFlow extends Base {
	
	public TaskWorkFlow() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}




	WebElement Email = driver.findElement(By.id("Email"));
	WebElement Password = driver.findElement(By.id("Password"));
	WebElement Login = driver.findElement(By.xpath("//input[@class='btn btn-lg login-btn']"));
	

	@BeforeTest()
	public void VerifyLogin() {

		Email.sendKeys("david01@yopmail.com");
		Password.sendKeys("Test@1234");
		Login.click();
		//System.out.println("Login Succesfully");

	}
	
	

	@Test(priority = 1)
	public void VerifyTaskWorkFlowLink() throws InterruptedException {
		
		WebElement TWFL=driver.findElement(By.xpath("//span[contains(text(),'TaskWorkFlow')]"));
		TWFL.click();
		Thread.sleep(2000);
		
	}
	@Test(priority = 2)
	public void verifyLabel() {
		String Actual=driver.findElement(By.xpath("//h5[contains(text(),'Workflow')]")).getText();
		String	Expected="Workflow"; 
		Assert.assertEquals(Actual, Expected);
	}
	
	//test Swati
	@Test(priority = 3)
	public void VerifySearchByDesc() throws InterruptedException {
		WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		
		SearchBox.sendKeys("Hernandez");
		String Actual=driver.findElement(By.xpath("//a[contains(text(),'Hernandez, Angel v. Archdiocese of New York, Chris')]")).getText();
		System.out.println(Actual);
		String Expected="Hernandez, Angel v. Archdiocese of New York, Christ the King Church";
		Assert.assertEquals(Actual, Expected);
		SearchBox.clear();
		//driver.navigate().refresh();
		Thread.sleep(2000);
		
	}
	
	
	  @Test(priority = 4) 
	  public void VerifySearchByClientName() 
	  { 
		  
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("Angel Hernandez"); String
		  Actual=driver.findElement(By.xpath("//td[contains(text(),'Angel Hernandez')]")).getText(); 
		  String Expected="Angel Hernandez"; 
		  Assert.assertEquals(Actual,Expected); 
		  SearchBox.clear();
		  //driver.navigate().refresh();
	  
	  }
	 
	  @Test(priority = 5) 
	  public void VerifySearchByLocation() 
	  { 
		  
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("New York"); 
		  String Actual=driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText(); 
		  String Expected="New York"; 
		  Assert.assertEquals(Actual,Expected); 
		  SearchBox.clear(); 
		  //driver.navigate().refresh();
	  
	  }
	
	  @Test(priority = 6) 
	  public void VerifySearchByResponsibleAttorneyName() 
	  { 
		  
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("Daniel Ellis"); 
		  String Actual=driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText(); 
		  String Expected="Daniel Ellis"; 
		  Assert.assertEquals(Actual,Expected); 
		  SearchBox.clear(); 
		  //driver.navigate().refresh();
	  
	  }
	
	
	  @Test(priority = 7) 
	  public void VerifySearchByOpenDate() 
	  { 
		  
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("2019-10-09"); 
		  String Actual=driver.findElement(By.xpath("//tr[@class='odd']//td[contains(text(),'2019-10-09')]")).getText(); 
		  String Expected="2019-10-09"; 
		  Assert.assertEquals(Actual,Expected); 
		  SearchBox.clear(); 
		  //driver.navigate().refresh();
	  
	  }
	  
	  @Test(priority = 8) 
	  public void VerifySearchByParalegal() 
	  { 
		  
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("Rebecca Pontillo"); 
		  String Actual=driver.findElement(By.xpath("//tbody/tr[6]/td[6]")).getText(); 
		  String Expected="Rebecca Pontillo"; 
		  Assert.assertEquals(Actual,Expected); 
		  SearchBox.clear(); 
		  //driver.navigate().refresh();
	  
	  }
	  
	  @Test(priority = 9) 
	  public void VerifySearchByPracticeArea() 
	  { 
		  
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("Clergy"); 
		  String Actual=driver.findElement(By.xpath("//tbody/tr[7]/td[7]")).getText(); 
		  String Expected="Clergy"; 
		  Assert.assertEquals(Actual,Expected); 
		 
		  SearchBox.clear(); 
		  //driver.navigate().refresh();
		 	  
	  }
	  
	  @Test(priority = 10) 
	  public void VerifySearchByCaseType() 
	  { 
		
		  //driver.navigate().refresh();
		  WebElement SearchBox=driver.findElement(By.xpath("//input[@type='search']"));
		  SearchBox.sendKeys("Litigation"); 
		  String Actual=driver.findElement(By.xpath("//tbody/tr[8]/td[8]")).getText(); 
		  String Expected="Litigation"; 
		  Assert.assertEquals(Actual,Expected); 
		  SearchBox.clear(); 
		  //driver.navigate().refresh();
	  
	  }
		
	  
		
	  
	  @AfterTest public void tearDown() { driver.close(); }
		 
	
	
	

}
