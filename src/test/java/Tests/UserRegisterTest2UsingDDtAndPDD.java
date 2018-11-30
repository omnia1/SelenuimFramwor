package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterTest2UsingDDtAndPDD extends TestBase

{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testData")
	public static  Object [][] userdata()
	{
		return new Object[][] {
			{"moatz","nabil","moatz@tes25532xx.com","heh","12345678"},
			{"nour","ahmed","noura@tes25522bn.com","heh","123456"}
		};

	}
	@Test(priority=1 ,alwaysRun=true ,dataProvider="testData")
	public void UserCanRegisterSuccessfully(String fName,String lName ,String email ,String company,String phone)
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(fName ,lName ,email ,company,phone);
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));
		registerObject.UserLogout();
		homeRegister.OpenLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.LoginSuccessfully(email, email);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		registerObject.UserLogout();
	}
	

}
