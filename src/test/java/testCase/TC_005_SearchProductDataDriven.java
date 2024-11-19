package testCase;

import org.testng.annotations.Test;


import pageObject.SearchProduct;
import testBase.BaseClassReusablemethod;
import utilities.DataProviders;

public class TC_005_SearchProductDataDriven extends BaseClassReusablemethod{
	
	@Test(dataProvider="searchproductdata",dataProviderClass=DataProviders.class,groups="datadriven")
	
	public void searchprodcutexcel(String sp)
	{
		logger.info("Tc005 data driven test case ");
		
		SearchProduct spobj = new SearchProduct(driver);
		spobj.searchproduct(sp);
		spobj.btnclick();
		spobj.clickhomebtn();
		
		
	}
	

}
