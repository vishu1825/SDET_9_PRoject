package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

/**
 * 
 * @author Vishwajeet
 *
 */

public class CreateNewQuote extends WebDriverUtiles {
	WebDriver driver;
	@FindBy(name = "subject")
	private WebElement subTxtBx;

	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img")
	private WebElement contactLookUpImage;

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookUpImage;

	public CreateNewQuote(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void createNewQuote(String orgName, String Subject,String productName,String lastName,String billingAddress,
			String shipingAddress,double quantity) {
		subTxtBx.sendKeys(Subject);
		contactLookUpImage.click();
		swicthToWindow(driver,"Contacts&action");
		Contacts cntct = new Contacts(driver);
		cntct.getCntctTextBx().sendKeys(lastName);
		cntct.getCntctSbmtBtn().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+lastName+"')]")).click();
		alertOK(driver);
		swicthToWindow(driver, "Quotes");
		
		orgLookUpImage.click();
		swicthToWindow(driver,"Accounts&action");
		
		Organizations orgPage = new Organizations(driver);
		orgPage.getSearchEdt().sendKeys(orgName);
		orgPage.getSearchNow().click();
		
		
		/*contactLookUpImage.click();
		//switch to Child
		swicthToWindow(driver, "Contacts&action");
		Contacts conPage = new Contacts(driver);
		conPage.getSearchEdt().sendKeys(contactLastName);
		conPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+contactLastName+"')]")).click();

*/		
		
	}

}
