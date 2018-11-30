package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import Pages.myAccountPage;

public class myAccountTest extends TestBase {

	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	myAccountPage myAccountObject;
	
	String oldPassword="123456";
	String newPAssword="1234567";
	String firstame="omnia";
	String lastName="yehia";
	String email="noura15@gmil.com";
	String companyName="cit";


	@Test(priority=1 )
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstame, lastName, email, companyName, oldPassword);
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));

	}

	@Test(priority=2)
	public void RegisterUserCanChnagePassword() 
	{
		myAccountObject =new myAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.UserChanePasswordCorrectly(oldPassword, newPAssword);
		Assert.assertTrue(myAccountObject.resultCorrect.getText().contains("Password was changed"));
	}

	@Test(priority=3)
	public void RegisterUserCanLogout()
	{
		registerObject.UserLogout();
	}

	@Test(priority=4)
	public void RegisterCanLoIn()
	{
		homeRegister.OpenLoginPage();
		loginObject= new LoginPage(driver);
		
		loginObject.LoginSuccessfully(email, newPAssword);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
	}
	
	@Test(priority=5)
	public void UserLogout() 
	{
		registerObject.UserLogout();
	}



}
