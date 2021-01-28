package com.pratice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;

/**
 * 
 * @author Deepak
 *
 */
public class CreateContact_Initial_Class {
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void createContactWitORgTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");

		/* test Data */
		String orgName = eLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgType = eLib.getExcelData("contact", "tc_01", "orgType");
		String orgIndustry = eLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = eLib.getExcelData("contact", "tc_01", "rating");

		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contactName") + randomNum;

		/* step 1 : login to APP */
		WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("firefox")) {
		    driver= new FirefoxDriver();  
		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver = new InternetExplorerDriver();
		 }
		
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/* step 2 : navigate to Organization page */
		driver.findElement(By.linkText("Organizations")).click();

		/* step 3 : navigate ot create Org Page */
		wLib.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//img[@alt='Create Organization...']")));
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		/* step 4 : create new Organization with inductry & type, rating */
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		wLib.select(driver.findElement(By.name("industry")), orgIndustry);
		wLib.select(driver.findElement(By.name("accounttype")), orgType);
		wLib.select(driver.findElement(By.name("rating")), orgRating);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/* step 5 : verify the ORganization name */
		String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean actStatus = actOrgName.contains(orgName);
		// Assert.assertEquals(actStatus, true);
		Assert.assertTrue(actStatus);

		/* step 6 : navigate to Contact page */
		driver.findElement(By.linkText("Contacts")).click();

		/* step 7 : creat new Contact */
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		/* step 7 : create new contact with above Organization */
		driver.findElement(By.name("lastname")).sendKeys(contLastNAme);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
         Set<String> set = driver.getWindowHandles();
         Iterator<String> it = set.iterator();
         String paretntID = it.next();
         String chilID = it.next();
		
         System.out.println(paretntID);
         System.out.println(chilID);
		  /* swicth to child Window */
          wLib.swicthToWindow(driver, "Account&action");
		  
		  wLib.waitforElementToBeClickable(driver,
		  driver.findElement(By.id("search_txt")));
		  driver.findElement(By.id("search_txt")).sendKeys(orgName);
		  driver.findElement(By.name("search")).click();
		  driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		 
		   /* SWicth Back to Parent Window */
		   wLib.swicthToWindow(driver, "Contacts");
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		 /* step 8 : verify */
		   String actConatName =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  boolean status = actConatName.contains(contLastNAme);
		  Assert.assertTrue(actStatus);
		  
		 /* step 9 : logout & close */
		 wLib.moveToExpectedElemnet(driver,
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		  driver.findElement(By.linkText("Sign Out")).click(); driver.close();
		 

	}

}
