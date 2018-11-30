package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productPage;
import Pages.searchPage;
import Pages.wishListPage;

public class addProductToWishListTest extends TestBase {
	wishListPage WishObject;
	String ProductName="Apple MacBook Pro 13-inch";
	searchPage SearchObject;
	productPage detailsObject;

	@Test(priority=1)
	public void userCanSearchForProdct()
	{
		SearchObject  = new searchPage(driver);
		SearchObject.ProductSearch(ProductName);
		SearchObject.openProductDetailsPage();
		detailsObject =new productPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), ProductName);
	}

	@Test(priority=2)
	public void userCanAddProductToWishList()
	{
		detailsObject =new productPage(driver);
		detailsObject.AddProductToWishList();
		WishObject=new wishListPage(driver);
		detailsObject.OpenWishList();
		Assert.assertTrue(WishObject.WishListHeader.getText().contains("Wishlist"));
		Assert.assertTrue(WishObject.ProductCall.getText().contains(ProductName));
	}

	@Test(priority=3)
	public void userCanRemoveProductFromWishList()
	{
		WishObject=new wishListPage(driver);
		WishObject.RemoveProductFromWishCart();
		Assert.assertTrue(WishObject.emptyCartLabel.getText().contains("The wishlist is empty!"));

	}



}
