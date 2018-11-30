package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPAge;
import Pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage homeObject;
	ContactUsPAge contactusObject;
	String fulName="omnia";
	String email ="omia@gmail.com";
	String enquiry="goodproduct more info";

	@Test
	public void UserCanUseContactUs()
	{
		homeObject=new HomePage(driver);
		homeObject.openContactUs();
		contactusObject =new ContactUsPAge(driver);
		contactusObject.ContactUs(fulName, email, enquiry);
		Assert.assertTrue(contactusObject.result.getText()
				.equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));


	}
}
