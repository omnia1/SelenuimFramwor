package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.comparePage;
import Pages.productPage;
import Pages.searchPage;

public class addToCompareTest extends TestBase {
	
	String firstProductName="Asus N551JK-XO076H Laptop";
	String seconProductName="Apple MacBook Pro 13-inch";
	searchPage SearchObject;
	productPage detailsObject;
	comparePage compareObject;
	
	
	
	@Test(priority=1)
	public void userCanCompareProduct() throws InterruptedException 
	{
		SearchObject  = new searchPage(driver);
		detailsObject =new productPage(driver);
		compareObject =new comparePage(driver);
		SearchObject.ProductSearch(seconProductName);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(seconProductName));
		detailsObject.addToCompare();
		
		SearchObject.ProductSearch(firstProductName);
		SearchObject.openProductDetailsPage2();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(firstProductName));
		detailsObject.addToCompare();
		Thread.sleep(1000);
		
		driver.navigate().to("https://demo.nopcommerce.com/" +"/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.isDisplayed());
		Assert.assertTrue(compareObject.secondProductName.isDisplayed());
		compareObject.compareProduct();
	}
	
	@Test(priority=2)
	public void userCanClearCompareList()
	{
		compareObject.clearCompareList();
	}

}
