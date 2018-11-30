package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Pages.checkoutOutPage;
import Pages.orderDetailPage;
import Pages.productPage;
import Pages.searchPage;
import Pages.shoppingCartPage;

public class registeredUserCheckoutTest extends TestBase{


	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String ProductNameverify="Apple MacBook Pro 13-inch";
	searchPage SearchObject;
	productPage detailsObject;
	shoppingCartPage shoppingObject;
	checkoutOutPage checkOutObject;
	orderDetailPage orderObject;

	@Test(priority=1 )
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration("omnia", "yehia", "noura413@gmail.com", "cit", "123456");
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));

	}
	@Test(priority=2 )
	private void userCanSearchForProdct()
	{
		SearchObject  = new searchPage(driver);
		detailsObject =new productPage(driver);
		SearchObject.ProductSearch(ProductNameverify);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductNameverify));
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), ProductName);

	}	

	@Test(priority=3)
	public void UserCanAddItemToShoppingCart() throws InterruptedException 
	{
		detailsObject=new productPage(driver);
		detailsObject.addTocart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		shoppingObject=new shoppingCartPage(driver);
		//Assert.assertTrue(shoppingObject.totalLabl.getText().contains("	$"));
		

	}

	@Test(priority=4)
	public void userCanCheckProductCard() throws InterruptedException 
	{
		checkOutObject=new checkoutOutPage(driver);
		shoppingObject.Checkout();
		checkOutObject.RegisterUSerCanCheckoutSuccessfully("omnia", "yehia", "oyeee", "Egypt", "6636773", 
				"662782763", "Egypt", ProductNameverify);
		Assert.assertTrue(checkOutObject.ProductName.isDisplayed());
		Assert.assertTrue(checkOutObject.ProductName.getText().contains(ProductNameverify));
		checkOutObject.confirmOrder();
		Assert.assertTrue(checkOutObject.successMSg.isDisplayed());
		//Assert.assertTrue(checkOutObject.successMSg.getText().contains("Your order has been successfully processed!"));
		checkOutObject.printOrder();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject=new orderDetailPage(driver);
		orderObject.cdownloadPDf();
		orderObject.clickPrint();
		
		
				

	}

	@Test(priority=5)
	public void RegisterUserCanLogout()
	{
		registerObject.UserLogout();
	}
}
