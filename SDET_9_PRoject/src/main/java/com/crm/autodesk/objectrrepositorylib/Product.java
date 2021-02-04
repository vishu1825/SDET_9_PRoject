/**
 * 
 */
package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

/**
 * @author Vishwajeet
 *
 */
public class Product extends WebDriverUtiles {
	
	@FindBy(name="search_text")
	private WebElement prodSearchTxtBx;
	
	public WebElement getProdSearchTxtBx() {
		return prodSearchTxtBx;
	}

	public WebElement getProdDrpdwn() {
		return prodDrpdwn;
	}
	public void selectDropdown(WebElement prodDrpdwn,String visibleText )
	{
		select(prodDrpdwn, visibleText);
	}

	public WebElement getProdSbmtBtn() {
		return prodSbmtBtn;
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement prodLookUp;//productname
	

	public WebElement getProdLookUp() {
		return prodLookUp;
	}
	
	@FindBy(name="search_field")
	private WebElement prodDrpdwn;
	
	@FindBy(name="submit")
	private WebElement prodSbmtBtn;
	
	public Product(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
