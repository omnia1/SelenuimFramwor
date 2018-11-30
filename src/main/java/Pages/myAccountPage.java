package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends PagBase{

	public myAccountPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(linkText="My account")
	WebElement myAccountLink;

	@FindBy(linkText="Change password")
	WebElement chnagePaswordLink;

	@FindBy(id="OldPassword")
	WebElement oldPassword;

	@FindBy(id="NewPassword")
	WebElement newPassword;

	@FindBy(css="input.button-1.change-password-button")
	WebElement changePasswordBtn;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordBtn;
	
	@FindBy(css="div.result")
	public WebElement resultCorrect;

	public void openChangePasswordPage()
	{
		ClickButton(myAccountLink);
		ClickButton(chnagePaswordLink);
	}

	public void UserChanePasswordCorrectly(String oldPAssword ,String newPasword)
	{
		SentWebElementText(oldPassword, oldPAssword);
		SentWebElementText(newPassword, newPasword);
		SentWebElementText(confirmPasswordBtn, newPasword);
		ClickButton(changePasswordBtn);
	}

}
