package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PagBase {
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	//create contructor
	public PagBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
       
	}
	protected static void ClickButton (WebElement button)
	{
		button.click();
	}
	protected static void SentWebElementText(WebElement webElementText , String text)
	{
		webElementText.sendKeys(text);
	}
	
	public void ScrollButtom()
	{
		jse.executeScript("scrollBy(0,2500)");
	}
	
	public void  clearTxtElement(WebElement element)
	{
		element.clear();
	}
	


}
