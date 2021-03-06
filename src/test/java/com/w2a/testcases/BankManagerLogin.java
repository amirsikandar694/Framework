package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;
public class BankManagerLogin extends TestBase{

	
@Test
public void loginAsBankManager()
{
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	log.debug("Click on BankManager Button");
	driver.findElement(By.xpath(OR.getProperty("bnk_mng_login"))).click();
	log.debug("Checking add customer button");
	//Assert.assertTrue(isElementPresent(By.xpath(config.getProperty("add_customer_btn"))));
	Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty("add_customer_btn"))).isDisplayed());
	log.debug("Assertion successfull");
	click("add_customer_btn");
	Reporter.log("Login as Bank Manager");	
}

}
