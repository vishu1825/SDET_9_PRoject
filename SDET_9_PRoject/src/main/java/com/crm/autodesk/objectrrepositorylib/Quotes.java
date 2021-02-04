package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quotes {

	
	@FindBy(name="search_text")
	private WebElement qSearchtXTbx;
	
	@FindBy(name="search_field")
	private WebElement qDrpDwn;
	
	@FindBy(name="submit")
	private WebElement qSearchBtn;
	
	@FindBy(xpath = "//img[@alt='Create Quote...']")
	private WebElement createQuoteImg;

	
	public WebElement getCreateQuoteImg() {
		return createQuoteImg;
	}

	public Quotes(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}

	public WebElement getqSearchtXTbx() {
		return qSearchtXTbx;
	}

	public WebElement getqDrpDwn() {
		return qDrpDwn;
	}

	public WebElement getqSearchBtn() {
		return qSearchBtn;
	}
	
	
	
	
}
