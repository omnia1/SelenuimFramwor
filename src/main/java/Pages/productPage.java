package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productPage extends PagBase
{
	public productPage(WebDriver driver) {
		super(driver);

	}
	

	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;

	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriend;

	@FindBy(css="span.price-value-4")
	public WebElement result;

	@FindBy(linkText="Add your review")
	WebElement reiewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlist;
	
	@FindBy(linkText="Wishlist")
	WebElement wishlistLink;
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement AddToCompareBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement AddToCartBtn;


	public void SendEmail() 
	{

		ClickButton(emailFriend);
	}
	public void OpenReviewPage()
	{
		ClickButton(reiewLink);
	}
	
	public void AddProductToWishList ()
	{
		ClickButton(addToWishlist);
	}
	
	public void OpenWishList() 
	{
		ClickButton(wishlistLink);
	}
	
	public void addToCompare()
	{
		ClickButton(AddToCompareBtn);
	}
	
	public void addTocart()
	{
		ClickButton(AddToCartBtn);
	}
}