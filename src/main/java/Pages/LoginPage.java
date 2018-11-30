package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PagBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginBttn;

	public void LoginSuccessfully(String email ,String password)
	{
		SentWebElementText(emailTxtBox, email);
		SentWebElementText(passwordTxtBox, password);
		ClickButton(loginBttn);
	}
	
}
