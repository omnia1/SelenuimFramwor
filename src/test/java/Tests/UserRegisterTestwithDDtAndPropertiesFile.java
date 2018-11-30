package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.loadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterTestwithDDtAndPropertiesFile extends TestBase

{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String fname=loadProperties.userData.getProperty("firstname");
	String lname=loadProperties.userData.getProperty("lastname");
	String email=loadProperties.userData.getProperty("email");
	String password=loadProperties.userData.getProperty("password");
	String company=loadProperties.userData.getProperty("company");
	
	@Test(priority=1 ,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(fname, lname, email, company, password);
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
		loginObject.LoginSuccessfully(email, password);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
		
	}

}
