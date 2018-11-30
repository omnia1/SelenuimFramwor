package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends PagBase {

	public searchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement searchTextBox;

	@FindBy(css="input.button-1.search-box-button")
	WebElement SearchButton;

	@FindBy(id="ui-id-1")
	List<WebElement> produvtList;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	WebElement productTitle2;


	public void ProductSearch(String produtName)
	{
		SentWebElementText(searchTextBox, produtName);
		ClickButton(SearchButton);
	}
	public void openProductDetailsPage() {
		ClickButton(productTitle);
	}
	
	public void openProductDetailsPage2() {
		ClickButton(productTitle2);
	}
	
	public void productSearhUsingAutoComplete(String Searchtext) 
	{
		SentWebElementText(searchTextBox, Searchtext);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		produvtList.get(0).click();
	}


}
