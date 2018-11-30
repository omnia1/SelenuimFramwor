package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.productPage;
import Pages.searchPage;

public class changeCurrencyTest extends TestBase {
	HomePage homeObject;
	productPage detailsObject;
	searchPage SearchObject;
	String ProductName="Apple MacBook Pro 13-inch";



	@Test
	public void userCanChangeCurrency()
	{
		homeObject=new HomePage(driver);
		homeObject.changeCurrency();
		detailsObject =new productPage(driver);


	}
	@Test
	private void userCanSearchForProdct()
	{
		SearchObject  = new searchPage(driver);
		detailsObject =new productPage(driver);
		SearchObject.ProductSearch(ProductName);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(detailsObject.result.getText().contains("Ђ"));

	}

}
