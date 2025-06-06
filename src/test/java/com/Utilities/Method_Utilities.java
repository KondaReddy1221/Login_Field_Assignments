package com.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method_Utilities {

	static WebDriver driver;
	
	public static void wait_Second() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void wait_Element(By locator) {
		driver=Driver_Factory.launch_Browser();
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
		wb.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}