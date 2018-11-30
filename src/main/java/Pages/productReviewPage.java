package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productReviewPage extends PagBase {

	public productReviewPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="AddProductReview_Title")
	WebElement ReviewTitletext;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement ReviewTxt;

	@FindBy(id="addproductrating_3")
	WebElement RatingRadioBtn;

	@FindBy(css="input.button-1.write-product-review-button")
	WebElement SubmitBtn;

	@FindBy(css="div.result")
	public WebElement ReviewResult;

	public void userCanAddReviewSuccessfully(String Reviewtitle ,String reviewBody)
	{
		SentWebElementText(ReviewTitletext, Reviewtitle);
		SentWebElementText(ReviewTxt, reviewBody);
		ClickButton(RatingRadioBtn);
		ClickButton(SubmitBtn);

	}

}
