package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Data.jsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterWitDDtAndJson extends TestBase

{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority=1 ,alwaysRun=true)
	public void UserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		jsonDataReader jsonReader=new jsonDataReader();
		jsonReader.jsonReader();
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.company, jsonReader.password);
		Assert.assertTrue(registerObject.messagesucess.getText().contains("Your registration completed"));
		registerObject.UserLogout();
		homeRegister.OpenLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.LoginSuccessfully(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		registerObject.UserLogout();
		

	}
	

}
