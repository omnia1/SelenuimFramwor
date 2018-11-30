package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productPage;
import Pages.searchPage;
import Pages.shoppingCartPage;

public class AddProductToShoopingCart extends TestBase {
	
	String ProductName="Apple MacBook Pro 13-inch";
	searchPage SearchObject;
	productPage detailsObject;
	shoppingCartPage shoppingObject;
	
	@Test(priority=1)
	private void userCanSearchForProdct()
	{
		SearchObject  = new searchPage(driver);
		detailsObject =new productPage(driver);
		SearchObject.ProductSearch(ProductName);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
		
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), ProductName);

	}
	
	@Test(priority=2)
	public void UserCanAddItemToShoppingCart() throws InterruptedException 
	{
		detailsObject=new productPage(driver);
		detailsObject.addTocart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		shoppingObject=new shoppingCartPage(driver);
		Assert.assertTrue(shoppingObject.totalLabl.getText().contains("	$3,600.00"));
		
	}
	
	@Test(priority=3)
	public void UserCanRemoveItemFromShoppingCard()
	{
		shoppingObject=new shoppingCartPage(driver);
		shoppingObject.RemoveProductFromCart();
	}
	
	

}
