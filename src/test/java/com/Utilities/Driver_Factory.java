package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_Factory {

	
	public static WebDriver driver;
	
	public static WebDriver launch_Browser() {
		
		if (Property_Reader.init_Prop().get("browser").equals("chrome")) {
			driver=new ChromeDriver();
			driver.get(Property_Reader.init_Prop().getProperty("url"));
		}
		
		else if (Property_Reader.init_Prop().get("browser").equals("firefox")) {
			driver=new FirefoxDriver();
			driver.get(Property_Reader.init_Prop().getProperty("url"));
		}
		
		else {
			System.out.println("please Enter Browser Name Corrrectly");
		}
		
		return driver;
	}
	
}