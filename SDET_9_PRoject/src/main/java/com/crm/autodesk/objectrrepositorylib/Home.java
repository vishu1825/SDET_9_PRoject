package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.WebDriverUtiles;
/**
 * 
 * @author Deepak , Nithish
 *
 */


public class Home  extends WebDriverUtiles{
	WebDriver driver;
	public Home(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	
	@FindBy(linkText = "Contacts")
    private WebElement contactLnk;
	
	@FindBy(linkText = "Organizations")
    private WebElement orgLnk;
	
	@FindBy(linkText = "Leads")
    private WebElement leadsLnk;
	
	@FindBy(linkText = "Products")
    private WebElement productlnk;
	
	public WebElement getProductlnk() {
		return productlnk;
	}

	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(name="Quotes")
	private WebElement quoteLink;

	public WebElement getQuoteLink() {
		return quoteLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	public void logout() {
		moveToExpectedElemnet(driver, adminstrationImg);
		signOutLnk.click();
	}
	
	
	
	
	}
