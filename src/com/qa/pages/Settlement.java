package com.qa.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.Base;

public class Settlement extends Base {

	public Settlement() throws InterruptedException {
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
		System.out.println("Login Succesfully");

	}

	@Test(priority = 1)
	public void VerifySearchByDesc() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Settlement')]")).click();
		Thread.sleep(4000);
		WebElement desc = driver.findElement(By.id("txtDescription"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		WebElement clear = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		desc.sendKeys("Test as chetu4");
		search.click();
		String actual = driver.findElement(By.xpath("//a[contains(text(),'Test as chetu4')]")).getText();
		String expected = "Test as chetu4";
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
		clear.click();

	}

	@Test(priority = 2)
	public void verifySettlementTitle() {
		String actual = driver.getTitle();
		String expected = "Snapshot | Settlement";
		Assert.assertEquals(actual, expected);
	}


	@Test(priority = 3)
	public void VerifySearchByGrossSettlement() throws InterruptedException {

		WebElement GrossSettlement = driver.findElement(By.id("txtGrossSettlement"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		WebElement clear = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		GrossSettlement.sendKeys("$ 5000.00");
		search.click();
		String actual = driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).getText();
		String expected = "$ 5000.00";
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}


	@Test(priority = 4)
	public void VerifySearchByHermanLawFee() throws InterruptedException {

		WebElement HermanLawFee = driver.findElement(By.id("txtHermanLawFee"));
		WebElement search = driver.findElement(By.id("btnFilter"));
		WebElement clear = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		HermanLawFee.sendKeys("$ 5000.00");
		search.click();
		String actual = driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).getText();
		String expected = "$ 5000.00";
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Test(priority = 5)
	public void verifyExportAll() throws InterruptedException {
		WebElement ExportAll=driver.findElement(By.xpath("//input[@value='Export All']"));
		WebElement Excel=driver.findElement(By.xpath("//span[contains(text(),'Excel')]"));

		ExportAll.click();
		Thread.sleep(5000);
		Excel.click();
		Thread.sleep(5000);

	}


	@Test(priority = 6) 
	public void verifyPrint() throws InterruptedException {
		WebElement
		print=driver.findElement(By.xpath("//a[contains(text(),'Print')]"));
		WebElement
		SelectCheckBox=driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]"));
		SelectCheckBox.click(); print.click();


		String mainWindowHandle = driver.getWindowHandle(); 
		Set<String> allWindowHandles = driver.getWindowHandles(); 
		Iterator<String> iterator =allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch
		//the heading of the child window 
		while (iterator.hasNext()) { 
			String ChildWindow = iterator.next();
			if(!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow); 
				Thread.sleep(1000);

				driver.close(); 
			} 
		}


	}

	@Test(priority = 7)
	public void verifyShowEntris() throws InterruptedException {
		Select drpDown=new Select(driver.findElement(By.cssSelector("select[name='SettlementListDatatable_length']")));
		drpDown.selectByVisibleText("500");
		Thread.sleep(5000);
		String Text=driver.findElement(By.cssSelector("#SettlementListDatatable_info")).getText();
		String actual=Text.replaceAll(" ", "");
		String Text1 ="Showing 1 to 500 of 4,042 entries (filtered from 500 total entries)";
		String expected=Text1.replaceAll(" ", "");
		System.out.print(actual);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 8)
	public void verifyMatterLink() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement matterLink=driver.findElement(By.xpath("//a[normalize-space()='Test as chetu4']"));
		matterLink.click();
		String actual=driver.findElement(By.xpath("//a[contains(text(),'Test as chetu4')]")).getText();
		String expected="Test as chetu4";
		Assert.assertEquals(actual, expected);
	}

	/*
	 * @Test(priority = 9) public void SaveMatterData() {
	 * 
	 * WebElement GrossAmount=driver.findElement(By.id("GrossAmount")); WebElement
	 * HermanLawFee=driver.findElement(By.id("HermanLawFee")); WebElement
	 * ReferralFee=driver.findElement(By.id("ReferralFee")); WebElement
	 * TotalFee=driver.findElement(By.id("TotalFee")); WebElement
	 * AdditionInformation=driver.findElement(By.id("AdditionInformation"));
	 * WebElement Save=driver.findElement(By.xpath("//input[@value='Save']"));
	 * 
	 * GrossAmount.sendKeys("1101"); HermanLawFee.sendKeys("101");
	 * ReferralFee.sendKeys("11"); TotalFee.sendKeys("1213");
	 * AdditionInformation.sendKeys("Save the Matter Data"); Save.click();
	 * 
	 * 
	 * 
	 * }
	 * 
	 */






	@AfterTest public void tearDown() { driver.close(); }


}
