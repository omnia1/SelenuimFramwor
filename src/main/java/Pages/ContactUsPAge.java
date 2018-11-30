package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPAge extends PagBase {

	public ContactUsPAge(WebDriver driver) {
		super(driver);

	}

	@FindBy(id= "FullName")
	private WebElement fullName;

	@FindBy(id="Email")
	private WebElement EmailText;

	@FindBy(id="Enquiry")
	private WebElement enquiry;

	@FindBy(css="input.button-1.contact-us-button")
	private WebElement submitBtn;

	@FindBy(css="div.result")
	public WebElement result;

	public void ContactUs(String name ,String Email , String Enquiry)
	{
		SentWebElementText(fullName, name);
		SentWebElementText(EmailText, Email);
		SentWebElementText(enquiry, Enquiry);
		ClickButton(submitBtn);

	}

}
