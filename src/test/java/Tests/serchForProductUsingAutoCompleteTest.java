package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productPage;
import Pages.searchPage;

public class serchForProductUsingAutoCompleteTest  extends TestBase
{
	searchPage SearchObject;
	productPage detailsObject;
	String ProductName="Apple MacBook Pro 13-inch";

	@Test
	public void userCanSearchWithAutoSuggest() 
	{
		SearchObject=new searchPage(driver);
		SearchObject.productSearhUsingAutoComplete("MacB");
		detailsObject=new productPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));

	}

}
