/**
 * 
 */
package com.crm.autodesk.producttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.objectrrepositorylib.CreateNewProduct;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Product;
import com.crm.autodesk.objectrrepositorylib.ProductInfo;

/**
 * @author Vishwajeet
 *
 */
public class CreateProduct4 extends BaseClass {

	@Test(groups={"regressionTest"})
	public void seach_Product_By_CommissionRate() throws Throwable {
		String prodName = eLib.getExcelData("Product", 1, 2);
		String prodDrpdwn = eLib.getExcelData("Product", 1, 3);
		String commissionQty = eLib.getExcelData("Product", 1, 4);

		/* step 2 : Navigate to Product Page */
		Home hp = new Home(driver);
		hp.getProductlnk().click();

		/* Navigate to Create New Product Page */
		Product prod = new Product(driver);
		prod.getProdLookUp().click();

		/* Create New Product with Commission Ratw */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.getProdNameTxtBx().sendKeys(prodName);

		cnp.getCommissionRateEle().sendKeys(commissionQty);
		cnp.getProdSbmtBtn().click();

		/* verify */
		ProductInfo pi = new ProductInfo(driver);
		String successMsg = pi.getProdsuccessFullMsg().getText();
		System.out.println(successMsg);
		Assert.assertTrue(successMsg.contains(prodName));

		/* Navigate to Product Page */
		hp.getProductlnk().click();
		/* Verify the product by entering the commission rate */
		prod.getProdDrpdwn().sendKeys(prodDrpdwn);
		prod.getProdSearchTxtBx().sendKeys(commissionQty);
		prod.getProdSbmtBtn();

	}

	@Test
	public void seach_Product_By_QtyInStock() throws Throwable {

		String prodName = eLib.getExcelData("Product", 4, 2);
		String prodDrpdwn = eLib.getExcelData("Product", 4, 3);
		String qtyInStk = eLib.getExcelData("Product", 4, 4);

		/* step 2 : Navigate to Product Page */
		Home hp = new Home(driver);
		hp.getProductlnk().click();

		/* Navigate to Create New Product Page */
		Product prod = new Product(driver);
		prod.getProdLookUp().click();

		/* Create New Product with Commission Ratw */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.getProdNameTxtBx().sendKeys(prodName);
		cnp.getQtyInStockEle().sendKeys(qtyInStk);

		// cnp.getCommissionRateEle().sendKeys(commissionQty);
		cnp.getProdSbmtBtn().click();

		/* verify */
		ProductInfo pi = new ProductInfo(driver);
		String successMsg = pi.getProdsuccessFullMsg().getText();
		System.out.println(successMsg);
		Assert.assertTrue(successMsg.contains(prodName));

		/* Navigate to Product Page */
		hp.getProductlnk().click();
		/* Verify the product by entering the commission rate */
		prod.getProdDrpdwn().sendKeys(prodDrpdwn);
		prod.getProdSearchTxtBx().sendKeys(qtyInStk);
		prod.getProdSbmtBtn();
	}

	@Test(groups={"regressionTest"})
	public void seach_Product_By_ProductName() throws Throwable {

		/* test Data */
		String prodName = eLib.getExcelData("Contact", "tc_04", "productName");
		String prodDropdwn = eLib.getExcelData("Contact", "tc_04", "productDropdown");

		/* step 2 : Navigate to Product Page */
		Home hp = new Home(driver);
		hp.getProductlnk().click();

		/* Navigate to Create New Product Page */
		Product prod = new Product(driver);
		prod.getProdLookUp().click();

		/* Create New Product with ProductName */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.getProdNameTxtBx().sendKeys(prodName);
		cnp.getProdSbmtBtn().click();

		/* verify */
		ProductInfo pi = new ProductInfo(driver);
		String successMsg = pi.getProdsuccessFullMsg().getText();
		System.out.println(successMsg);
		String[] msg = successMsg.split(" ");
		String prodNo = msg[1];
		System.out.println(prodNo);
		Assert.assertTrue(successMsg.contains(prodName));

		/* Navigate to Product Page */
		hp.getProductlnk().click();

		/* Enter prodNo & prodDrpdwn in */
		prod.getProdSearchTxtBx().sendKeys(prodName);
		prod.selectDropdown(prod.getProdDrpdwn(), prodDropdwn);
		prod.getProdSbmtBtn().click();

	}

	@Test
	public void seach_Product_By_ProductNo() throws Throwable {
		/* test Data */
		String prodName = eLib.getExcelData("Contact", "tc_05", "productName");
		String prodDrpdwn = eLib.getExcelData("Contact", "tc_05", "productNum");
		String partName = eLib.getExcelData("Contact", "tc_05", "PartNum");

		/* step 2 : Navigate to Product Page */
		Home hp = new Home(driver);
		hp.getProductlnk().click();

		/* Navigate to Create New Product Page */
		Product prod = new Product(driver);
		prod.getProdLookUp().click();

		/* Create New Product with ProductName */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.getProdNameTxtBx().sendKeys(prodName);

		cnp.getProdSbmtBtn().click();

		/* verify */
		ProductInfo pi = new ProductInfo(driver);
		String successMsg = pi.getProdsuccessFullMsg().getText();
		System.out.println(successMsg);
		String[] msg = successMsg.split(" ");
		String prodNo = msg[1];
		System.out.println(prodNo);
		Assert.assertTrue(successMsg.contains(prodName));

		/* Navigate to Product Page */
		hp.getProductlnk().click();

		/* Verifying the Product Num */
		prod.getProdSearchTxtBx().sendKeys(prodNo);
		prod.getProdSbmtBtn().click();

	}

	@Test
	public void seach_Product_By_PartNumber() throws Throwable {
		/* test Data */
		String prodName = eLib.getExcelData("Contact", "tc_06", "productName");
		String prodDrpdwn = eLib.getExcelData("Contact", "tc_06", "Dropdown");
		String partName = eLib.getExcelData("Contact", "tc_06", "PartNum");

		/* step 2 : Navigate to Product Page */
		Home hp = new Home(driver);
		hp.getProductlnk().click();

		/* Navigate to Create New Product Page */
		Product prod = new Product(driver);
		prod.getProdLookUp().click();

		/* Create New Product with ProductName */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.getProdNameTxtBx().sendKeys(prodName);
		cnp.getPartNumEle().sendKeys(partName);
		cnp.getProdSbmtBtn().click();

		/* verify */
		ProductInfo pi = new ProductInfo(driver);
		String successMsg = pi.getProdsuccessFullMsg().getText();
		Assert.assertTrue(successMsg.contains(prodName));

		/* Navigate to Product Page */
		hp.getProductlnk().click();

		prod.selectDropdown(prod.getProdDrpdwn(), prodDrpdwn);
		prod.getProdSearchTxtBx().sendKeys(partName);
		prod.getProdSbmtBtn();

	}

}
