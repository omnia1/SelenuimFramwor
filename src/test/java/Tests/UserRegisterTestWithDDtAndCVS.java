package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterTestWithDDtAndCVS extends TestBase

{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority=1 ,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration("omnia", "yehia", "noura5@gmail.com", "cit", "123456");
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));
		

	}
	@Test(dependsOnMethods= {"UserCanRegisterSuccessfully"})
	public void RegisterUserCanLogout()
	{
		registerObject.UserLogout();
	}
	@Test(dependsOnMethods= {"RegisterUserCanLogout"})
	public void RegisterCanLoIn()
	{
		homeRegister.OpenLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.LoginSuccessfully("noura5@gmail.com", "123456");
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
		
	}

}
