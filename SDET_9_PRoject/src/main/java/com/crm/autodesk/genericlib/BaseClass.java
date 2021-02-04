/**
 * 
 */
package com.crm.autodesk.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;

/**
 * @author vishwajeet
 *
 */
public class BaseClass {
	
	public FileUtility flib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtiles wLib = new WebDriverUtiles();
	public WebDriver driver=null;
	
	
	
	
	@Parameters("browser")
	//@BeforeTest(groups = {"smokeTest" , "regressionTest"})
	public void configBT(String BROWSER) throws Throwable {
		//used for cross browser exceution
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(flib.getPropertyKeyValue("url"));
	}
	
	@BeforeClass(groups={"regressionTest"})
	public void configBC() throws Throwable{
		   String BROWSER =flib.getPropertyKeyValue("browser");
		  
		 if(BROWSER.equals("chrome")) {
		   driver= new ChromeDriver();
		 } else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
	     }
		 
	}
	
	@BeforeMethod(groups={"regressionTest"})
	public void configBM() throws Throwable {
		/* read data from property File */
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
	
		/*login to app*/
		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);

		/*step 2 : login*/
	     Login lp = new Login(driver);
	     lp.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups={"regressionTest"})
	public void configAm() {
		/*step 1 : logout*/
		Home hp = new Home(driver);
		hp.logout();


	}
	
	@AfterClass(groups={"regressionTest"})
	public void configAC(){
		/*close the browser*/
		driver.close();
	}
	




}
