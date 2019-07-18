package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExtentManager;

public class TestBase {
	

	    String path=System.getProperty("user.dir");
		public static WebDriver driver;
		public static Properties config= new Properties();
		public static Properties OR= new Properties();
		public static FileInputStream fisco;
		public static FileInputStream fisor;
		public static Logger log=Logger.getLogger("devpinoyLogger");
		public ExtentReports report=ExtentManager.getInstance();
		public static ExtentTest test;
		
		@BeforeSuite
		public void setUp()
		{
			if(driver==null)
			{

			try {
				fisco = new FileInputStream(path+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				log.debug("Config file loaded");
				config.load(fisco);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				fisor=new FileInputStream(path+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				log.debug("OR file loaded");
				OR.load(fisor);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//===============Browser Invoke======================================			
						
			System.setProperty("webdriver.chrome.driver", path+"\\src\\test\\resources\\executable\\chromedriver.exe");
			driver=new ChromeDriver();
			log.debug("URL "+config.getProperty("url")+" Open");
			driver.get(config.getProperty("url"));
			log.debug("Maximize Browser");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("waitTime")), TimeUnit.SECONDS);
			Reporter.log("Browser launch Successfully");

			}
			
		}
		
		public boolean isElementPresent(By by)
		{
		try {
					driver.findElement(by);
					return true;
			}
		
		catch (Exception e)
			{
				return false;
			}	
		}
	

		@AfterSuite
		public void teardown()
		{
			driver.quit();
			log.debug("Close Browser");
		}

}
