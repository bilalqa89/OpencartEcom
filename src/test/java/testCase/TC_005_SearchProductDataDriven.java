package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObject.SearchProduct;
import testBase.BaseClassReusablemethod;
import utilities.DataProviders;

public class TC_005_SearchProductDataDriven extends BaseClassReusablemethod{
	
	@Test( dataProvider="searchproductdata",dataProviderClass=DataProviders.class,groups={"datadriven","master"})
	
	public void searchprodcutexcel(String sp,String exp)
	{
		logger.info("Tc005 data driven test case ");
		
		SearchProduct spobj = new SearchProduct(driver);
		spobj.searchproduct(sp);
		spobj.btnclick();
		boolean targettext = spobj.findproductexist();
		if(exp.equalsIgnoreCase("pass"))
		{
			if(targettext==true)
			{
				spobj.clickhomebtn();
				Assert.assertTrue(true);
			}
			
		}
		else
		{
			Assert.assertTrue(false);
		}
		if(exp.equalsIgnoreCase("fail"))
		{
			
			
		}
		
		
		
		
	}
	

}
