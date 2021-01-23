package com.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MakeMyTrip {
	
	@Test
	public void sampleSample() {

		  
		   WebDriver driver = new FirefoxDriver(); 
		   
		    driver.get("https://www.makemytrip.com/");
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   WebDriverWait wait = new WebDriverWait(driver, 20);
	
		   Actions act = new Actions(driver);
		   act.moveByOffset(10, 10).click().perform();
		   
			
			  driver.findElement(By.xpath("//span[text()='From']")).click();
			  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("JFK");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='JFK']")));			
			 driver.findElement(By.xpath("//div[text()='JFK']")).click();
			  
			  driver.findElement(By.xpath("//span[text()='To']")).click();
			  driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MYQ");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='MYQ']")));
			  driver.findElement(By.xpath("//div[text()='MYQ']")).click();
			  
			  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
			  driver.findElement(By.xpath("//div[contains(@aria-label,'Jan 24 2021')]")).click();
			 
		  
	}

}
