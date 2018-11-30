package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PagBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id="gender-male")
	WebElement genderRadioButton;

	@FindBy(id="FirstName")
	WebElement fnText;

	@FindBy(id= "LastName")
	WebElement lnText;

	@FindBy(name= "DateOfBirthDay")
	WebElement selectDay;

	@FindBy(name= "DateOfBirthMonth")
	WebElement selectMonth;

	@FindBy(name= "DateOfBirthYear")
	WebElement selectYear;

	@FindBy(id= "Email")
	WebElement emaiText;

	@FindBy(id= "Company")
	WebElement companyName;

	@FindBy(id= "Newsletter")
	WebElement newsLetterCheckBox;

	@FindBy(id= "Password")
	WebElement passwordText;

	@FindBy(id= "ConfirmPassword")
	WebElement conPasswordText;

	@FindBy(id= "register-button")
	WebElement registerButton;
	
	@FindBy(css="div.result")
	public WebElement messagesucess;
	
	@FindBy(css="a.ico-logout")
	public WebElement LogoutLink;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink;

	public void UserRegistration(String firstName , String lastName ,String email , String company , String password ) 
	{
		ClickButton(genderRadioButton);
		SentWebElementText(fnText, firstName);
		SentWebElementText(lnText, lastName);
		ClickButton(selectDay);
		ClickButton(selectMonth);
		ClickButton(selectYear);
		SentWebElementText(emaiText, email);
		SentWebElementText(companyName, company);
		ClickButton(newsLetterCheckBox);
		SentWebElementText(passwordText, password);
		SentWebElementText(conPasswordText, password);
		ClickButton(registerButton);
		
	}
	public void UserLogout()
	{
		ClickButton(LogoutLink);
	}
	public void MyAccount() 
	{
	ClickButton(myAccountLink);	
		}
}

