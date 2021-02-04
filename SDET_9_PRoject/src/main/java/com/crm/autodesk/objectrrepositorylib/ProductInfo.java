/**
 * 
 */
package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vishwajeet
 *
 */
public class ProductInfo {
	
	public WebElement getProdsuccessFullMsg() {
		return prodsuccessFullMsg;
	}

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement prodsuccessFullMsg;
	
	public ProductInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
