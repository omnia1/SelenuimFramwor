package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.excelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterTestWithDDtAndExcel extends TestBase

{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="excelData")
	public Object[][] userRegisterData() throws IOException 
	{
		excelReader readexcel=new excelReader();
		
			return readexcel.getData();
		
	}
	
	@Test(priority=1 ,alwaysRun=true ,dataProvider="excelData")
	public void UserCanRegisterSuccessfully(String firstName ,String astName ,String email ,String company ,String phone)
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstName, astName,email,company, phone);
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));
		registerObject.UserLogout();
		homeRegister.OpenLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.LoginSuccessfully(email, phone);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		registerObject.UserLogout();
	}
	
	

}
