package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
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

		clearText("firstname_txtbox");
		clearText("lastname_txtbox");
		clearText("postcode_txtbox");
		
		type("firstname_txtbox", firstname);
		type("lastname_txtbox", lastname);
		type("postcode_txtbox", postCode);
		
		Thread.sleep(2000);
		log.debug("Data Entered");
		click("addcustomer_btn");
		Thread.sleep(2000);
		log.debug("Add customer button clicked");
		Alert alert=driver.switchTo().alert();
		alert.accept();
		log.debug("Accept the alert");
		Reporter.log("Customer successfully added");
		
		
	}
	
	
	}
	



