package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class wishListPage extends PagBase {

	public wishListPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement ProductCall;

	@FindBy(css="h1")
	public WebElement WishListHeader;

	@FindBy(css="input.button-2.update-wishlist-button")
	WebElement updateWishListBtn;

	@FindBy(name="removefromcart")
	WebElement removeFromCartCheckBox;

	@FindBy(css="div.no-data")
	public WebElement emptyCartLabel;

	public void RemoveProductFromWishCart()
	{
		ClickButton(removeFromCartCheckBox);
		ClickButton(updateWishListBtn);
		

	}

}
