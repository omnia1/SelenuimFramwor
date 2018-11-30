package Pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class comparePage extends PagBase{

	public comparePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css="table.compare-products-table")
	private WebElement compareTable;

	@FindBy(css="a.clear-list")
	private WebElement clearListLink;

	@FindBy(tagName="tr")
	private List<WebElement> allRows;

	@FindBy(tagName="td")
	private List<WebElement> allColumns;
	
	@FindBy(css="div.no-data")
	public WebElement noDataLabel;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement firstProductName;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement secondProductName;
	
	
	public void clearCompareList()
	{
		ClickButton(clearListLink);
	}
	
	public void compareProduct()
	{
		//get all rows
		System.out.println(allRows.size());
		//get data from each row
		for(WebElement row :allRows)
		{
			System.out.println(row.getText() +"\t");
			for(WebElement col :allColumns)
			{
				System.out.println(col.getText() +"\t");
			}
		}
		
	}



}
