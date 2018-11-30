package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterTestusingJavaFaker extends TestBase

{
	HomePage homeRegister;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fakeData =new Faker();
	String firstName =fakeData.name().firstName();
	String lastName =fakeData.name().lastName();
	String company=fakeData.name().title();
	String email=fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();



	@Test(priority=1 ,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		homeRegister =new HomePage(driver);
		homeRegister.Registration();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstName, lastName, email, company, password);
		System.out.println("user Data is :" + "  " + firstName + "  " + lastName+ "  " + email + "  "  + company +"  " + password);
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
