package testCase;

import org.testng.annotations.Test;

import pageObject.SearchProduct;
import testBase.BaseClassReusablemethod;

public class TC004_SearchProduct extends BaseClassReusablemethod  {
	
	@Test(groups={"Sanity","master"})
	
	public void searchproduct()
	{
		logger.info("Test case for search product");
		try
		{
			SearchProduct spobj = new SearchProduct(driver);
			spobj.searchproduct(p.getProperty("searchproductname"));
			spobj.btnclick();
			
		}
		
		catch(Exception e)
		{
			
		}
		
		
	}

	
}
