package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class emaiPage extends PagBase {

	public emaiPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id="FriendEmail")
	private WebElement friendEmailTxt;
	
	@FindBy(id="PersonalMessage")
	private WebElement personalMssTxt;
	
	@FindBy(css="input.button-1.send-email-a-friend-button")
	private WebElement sendEmailtn;
	
	@FindBy(css="div.result")
	public WebElement result;
	
	public void SendEmailToFriend(String email, String personalTxt) 
	{
		SentWebElementText(friendEmailTxt, email);
		SentWebElementText(personalMssTxt, personalTxt);
		ClickButton(sendEmailtn);
		
	}

}
