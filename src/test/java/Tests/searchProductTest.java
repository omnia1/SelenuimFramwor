package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productPage;
import Pages.searchPage;


public class searchProductTest extends TestBase 
{
	String ProductName="Apple MacBook Pro 13-inch";
	searchPage SearchObject;
	productPage detailsObject;

	@Test
	private void userCanSearchForProdct()
	{
		SearchObject  = new searchPage(driver);
		detailsObject =new productPage(driver);
		SearchObject.ProductSearch(ProductName);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), ProductName);

	}
}
