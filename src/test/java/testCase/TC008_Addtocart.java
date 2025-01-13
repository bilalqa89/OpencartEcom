package testCase;

import org.testng.annotations.Test;

import pageObject.AddtocCart;
import testBase.BaseClassReusablemethod;

public class TC008_Addtocart extends BaseClassReusablemethod{
	
	@Test(groups={"Sanity","master"})
	public void testaddtocart()
	{
		logger.info("Add to cart test case ");
		AddtocCart atc = new AddtocCart(driver);
		atc.clickmenu();
		atc.clickaddtocart();
		atc.clickshowcart();
		
		
		
	}

}
