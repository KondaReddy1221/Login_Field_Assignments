package com.tests;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Login_Page;
import com.Utilities.Driver_Factory;
import com.Utilities.Property_Reader;

public class Employee_Test {

	
	WebDriver driver;
	Login_Page login;
	Logger log;
	Properties pro;
	
	
	@BeforeTest
	public void on_Start() {
		
		driver=Driver_Factory.launch_Browser();
		login=new Login_Page(driver);
		log=LogManager.getLogger(this.getClass());
		pro=Property_Reader.init_Prop();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.debug(".........Before Test Started ........");
	}
	
	@Test(priority = 1)
	public void login_Test() {

		log.info("Login Test Started....");
		
		String Expected_title= login.validate_Title();
		System.out.println(Expected_title);
		
		if(Expected_title.equals(pro.getProperty("title"))) {
			Assert.assertTrue(true);
			log.info("Title Verified.....");
		} else {
			Assert.assertTrue(false);
			log.error("Title Not Matched.....");
		}
	}
	
	@Test(priority = 2)
	public void perform_Login() {
		log.info("Login Action Started.....");
		login.complete_Login(pro.getProperty("un"), pro.getProperty("ps"));
		log.info("Login Action Completed.....");
	}
	
	@AfterTest
	public void tear_Down() {
		driver.quit();
		log.debug("driver close.....");
	}
	
	
}