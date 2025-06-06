package com.Pages;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Utilities.Method_Utilities;
import com.Utilities.Property_Reader;

public class Login_Page {

	WebDriver driver;
	Properties pro;
	Logger log;
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
		pro=Property_Reader.init_Prop();
		log=LogManager.getLogger(this.getClass());
	}
	
	By userName=By.cssSelector("input[name='username']");
	By passWord=By.cssSelector("input[name='password']");
	By login_button=By.cssSelector("button[type='submit']");
	
	public String validate_Title() {
		String exp_Title= driver.getTitle();
		return exp_Title;
	}
	
	@SuppressWarnings("deprecation")
	public void complete_Login(String uname , String pass) {
		
		WebElement un= driver.findElement(userName);
		WebElement ps=driver.findElement(passWord);
		WebElement login=driver.findElement(login_button);
		
		//Method_Utilities.wait_Element(userName);
		un.sendKeys(uname);
		
		Method_Utilities.wait_Second();
		if(un.getAttribute("value").equals(pro.getProperty("un"))) {
			Assert.assertTrue(true);
			log.info("Username Verified.....");
		} else {
			Assert.assertTrue(false);
			log.error("Username Not Matched...");
		}
		
		//Method_Utilities.wait_Element(passWord);
		ps.sendKeys(pass);
		Method_Utilities.wait_Second();
		if(ps.getAttribute("value").equals(pro.getProperty("ps"))) {
			Assert.assertTrue(true);
			log.info("Password Verified.....");
		} else {
			Assert.assertTrue(false);
			log.error("Password Not Matched.....");
		}
		
		login.click();
		
	}
}