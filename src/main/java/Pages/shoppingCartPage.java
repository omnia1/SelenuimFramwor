package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage extends PagBase{

	public shoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="removefromcart")
	WebElement RemoveFromCartCheckBox;
	
	@FindBy(css="input.qty-input")
	WebElement quantityText;
	
	@FindBy(css="input.button-2.update-cart-button")
	WebElement updateBtn;
	
	@FindBy(css="td.subtotal")
	public WebElement totalLabl;
	
	@FindBy(id="checkout")
	WebElement CheckouBtn;
	
	@FindBy(id="termsofservice")
	WebElement AgreeCheckBox;
	
	
	public void RemoveProductFromCart()
	{
		ClickButton(RemoveFromCartCheckBox);
		ClickButton(updateBtn);
		
	}
	
	public void UpdateProductQtyInCart(String quantity ) 
	{
		clearTxtElement(quantityText);
		SentWebElementText(quantityText, quantity);
		ClickButton(updateBtn);
	}
	
	public void Checkout()
	{
		ClickButton(AgreeCheckBox);
		ClickButton(CheckouBtn);
	}
	

}
