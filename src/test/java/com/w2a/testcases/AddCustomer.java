package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomer extends TestBase{


	
	
	@DataProvider(name="getData")
	public static Object[][] data()
	{	log.debug("Fetch data from data ");
		return new Object[][]  {{"Amir","Sikandar","JSR"},{"Darshan","Bora","JSR"},{"Sanket","Agrawal","JSR"}};
				
	}

	@Test(dataProvider ="getData")
	public void addcustomer(String firstname,String lastname,String postCode) throws InterruptedException
	{
		

		driver.findElement(By.xpath(OR.getProperty("firstname_txtbox"))).sendKeys(firstname);
		driver.findElement(By.xpath(OR.getProperty("lastname_txtbox"))).sendKeys(lastname);
		driver.findElement(By.xpath(OR.getProperty("postcode_txtbox"))).sendKeys(postCode);
		Thread.sleep(2000);
		log.debug("Data Entered");
		driver.findElement(By.xpath(OR.getProperty("addcustomer_btn"))).click();
		Thread.sleep(2000);
		log.debug("Add customer button clicked");
		Alert alert=driver.switchTo().alert();
		alert.accept();
		log.debug("Accept the alert");
		Reporter.log("Customer successfully added");
		
	}
	
	
	}
	



