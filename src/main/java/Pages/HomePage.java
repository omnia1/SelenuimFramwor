package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PagBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor)driver;
		action=new Actions(driver);

	}
	@FindBy(linkText ="Register")
	WebElement RegisterLink;

	@FindBy(linkText ="Log in")
	WebElement LoginLink;

	@FindBy(linkText="Contact us")
	WebElement contactUsLink;

	@FindBy(id="customerCurrency")
	WebElement currencyDrobdownList;

	@FindBy(linkText="Computers")
	WebElement computerMenu;

	@FindBy(linkText="Notebooks")
	WebElement noteBooksElement;

	public void Registration() 
	{
		ClickButton(RegisterLink);

	}
	public void OpenLoginPage()
	{
		ClickButton(LoginLink);
	}

	public void openContactUs()
	{
		ScrollButtom();
		ClickButton(contactUsLink);
	}

	public void changeCurrency() 
	{
		select=new Select(currencyDrobdownList);
		select.selectByVisibleText("Euro");
	}

	public void SelectNoteBooksMenu()
	{
		action.moveToElement(computerMenu).
		moveToElement(noteBooksElement).
		click().
		build().
		perform();

	}

}
