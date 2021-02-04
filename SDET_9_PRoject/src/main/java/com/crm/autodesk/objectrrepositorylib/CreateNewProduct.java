/**
 * 
 */
package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author vishwajeet
 *
 */
public class CreateNewProduct {
	
	
	public WebElement getProdNameTxtBx() {
		return prodNameTxtBx;
	}

	public WebElement getProdSbmtBtn() {
		return prodSbmtBtn;
	}

	@FindBy(name="productname")
	private WebElement prodNameTxtBx;
	
	@FindBy(name="productcode")
	private WebElement partNumEle;
	
	@FindBy(id="commissionrate")
	private WebElement commissionRateEle;

	@FindBy(id="qtyinstock")
	private WebElement qtyInStockEle;

	
	public WebElement getQtyInStockEle() {
		return qtyInStockEle;
	}

	public WebElement getCommissionRateEle() {
		return commissionRateEle;
	}

	public WebElement getPartNumEle() {
		return partNumEle;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement prodSbmtBtn;
	
	public CreateNewProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
