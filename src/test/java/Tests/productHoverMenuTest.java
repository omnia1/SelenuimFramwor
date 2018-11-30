package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class productHoverMenuTest  extends TestBase{
	HomePage homeObject;
	
	@Test
	public void userCanSlectSubCategoryFromManiMenu()
	{
		
		homeObject=new HomePage(driver);
		homeObject.SelectNoteBooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
