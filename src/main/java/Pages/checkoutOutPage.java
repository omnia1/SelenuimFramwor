package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class checkoutOutPage extends PagBase {

	public checkoutOutPage(WebDriver driver) {
		super(driver);

	}





	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement emailTxt;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(name="BillingNewAddress.City")
	WebElement cityTxt;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxt;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;

	@FindBy(id="shippingoption_0")
	WebElement ShippingMethodCheckRdo;

	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueShippingBtn;

	@FindBy(id="paymentmethod_0")
	WebElement ShippingPayementRdo;

	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuePayementBtn;

	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continueInfoBtn;


	@FindBy(css="a.product-name")
	public WebElement ProductName;

	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(css="h1")
	public WebElement ThankLbl;

	@FindBy(css="div.title")
	public WebElement successMSg;

	@FindBy(linkText="Click here for order details.")
	WebElement moreDetailLink;

	public void RegisterUSerCanCheckoutSuccessfully(String firstName ,String lastName ,String email ,String cityName ,String postCode,
			String Phone ,String countrtName ,String ProductNameverify) throws InterruptedException

	{
		Select select= new Select(countryList);
		select.selectByVisibleText(countrtName);
		SentWebElementText(fnTxt, firstName);
		SentWebElementText(lnTxt, lastName);
		
		SentWebElementText(zipCodeTxt, postCode);
		SentWebElementText(phoneTxt, Phone);
		SentWebElementText(cityTxt, cityName);
		SentWebElementText(emailTxt, email);
		ClickButton(continueBtn);
		ClickButton(ShippingMethodCheckRdo);
		ClickButton( continueShippingBtn);
		Thread.sleep(1000);
		ClickButton(ShippingPayementRdo);
		ClickButton(continuePayementBtn);
		Thread.sleep(1000);
		ClickButton(continueInfoBtn);
	}
	public void confirmOrder() throws InterruptedException
	{
	
		Thread.sleep(1000);
		ClickButton(confirmBtn);
		
	}
	
	public void printOrder()
	{
		ClickButton(moreDetailLink);
	}
}




