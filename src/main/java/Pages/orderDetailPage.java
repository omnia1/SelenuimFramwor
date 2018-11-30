package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderDetailPage extends PagBase{

	public orderDetailPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(linkText="Print")
	WebElement printBtn;
	
	@FindBy(linkText="PDF Invoice")
	WebElement pdfBtn;
	
	public void clickPrint()
	{
		ClickButton(printBtn);
	}
	
	public void cdownloadPDf() throws InterruptedException
	{
		ClickButton(pdfBtn);
	Thread.sleep(1000);
	}

}
