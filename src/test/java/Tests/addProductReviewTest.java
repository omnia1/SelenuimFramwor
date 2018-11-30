package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Pages.productPage;
import Pages.productReviewPage;
import Pages.searchPage;

public class addProductReviewTest extends TestBase 
{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String ProductName="Apple MacBook Pro 13-inch";
	searchPage SearchObject;
	productPage detailsObject;
	productReviewPage productReviewOject;
	String reviewtitle="add review";
	String RevieBody =" good produvt for user ";


	@Test(priority=1 )
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration("omnia", "yehia", "noura38@gmail.com", "cit", "123456");
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));
	}

	@Test(priority=2 )
	private void userCanSearchForProdct()
	{
		SearchObject  = new searchPage(driver);
		detailsObject =new productPage(driver);
		SearchObject.ProductSearch(ProductName);
		SearchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), ProductName);

	}

	@Test(priority=3 )
	public void  userCanAddReviewSuccessfully()
	{
		productReviewOject=new productReviewPage(driver);
		detailsObject.OpenReviewPage();
		productReviewOject.userCanAddReviewSuccessfully(reviewtitle, RevieBody);
		Assert.assertTrue(productReviewOject.ReviewResult.getText().contains("Product review is successfully added."));

	}


	@Test(priority=4 )
	public void RegisterUserCanLogout()
	{
		registerObject.UserLogout();
	}





}
