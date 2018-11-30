package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Pages.emaiPage;
import Pages.productPage;
import Pages.searchPage;

public class emailFriendTest extends TestBase{

	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	searchPage SearchObject;
	productPage detailsObject;
	String ProductName="Apple MacBook Pro 13-inch";
	emaiPage emailObject;

	@Test(priority=1 )
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration("omnia", "yehia", "noura29@gmail.com", "cit", "123456");
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
	public void RegisterUserCanSendEmail() 
	{
		detailsObject.SendEmail();
		emailObject =new emaiPage(driver);
		emailObject.SendEmailToFriend("omnia@test.com", "hi friend");
		Assert.assertTrue(emailObject.result.getText().contains("your message"));

	}
	@Test(priority=4)
	public void RegisterUserCanLogout()
	{

		registerObject.UserLogout();
	}



}
