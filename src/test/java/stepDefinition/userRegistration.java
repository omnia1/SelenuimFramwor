package stepDefinition;

import org.testng.Assert;

import Pages.HomePage;
import Pages.UserRegistrationPage;
import Tests.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class userRegistration extends TestBase {
	HomePage homeobject;
	UserRegistrationPage RegisterObject;

	@Given("^The User  In Home Page$")
	public void the_User_In_Home_Page() {
		homeobject =new HomePage(driver);
		homeobject.Registration();

	}

	@When("^I click on register link$")
	public void i_click_on_register_link()  {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));

	}

	/*@When("^I entered the user data$")
	public void i_entered_the_user_data()  {
		RegisterObject=new UserRegistrationPage(driver);
		RegisterObject.UserRegistration("salah", "a7md", "sala@test.com", "no", "12345678");

	}
*/
	
	@When("^I entered \"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_entered(String firstNAme, String lastName, String email, String company, String c)  {
		RegisterObject=new UserRegistrationPage(driver);
		RegisterObject.UserRegistration(firstNAme, lastName, email, company, company);

	}
	@Then("^the registration page displayed successfully$")
	public void the_registration_page_displayed_successfully()  {
		RegisterObject.UserLogout();

	}

}
