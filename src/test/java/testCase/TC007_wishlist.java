package testCase;

import org.testng.annotations.Test;

import pageObject.LoginPageobject;
import pageObject.SearchProduct;
import pageObject.WishList_object;
import testBase.BaseClassReusablemethod;

public class TC007_wishlist extends BaseClassReusablemethod  {
	
	
	@Test(groups={"Sanity","master"})
	public void checkwishlist()
	{
		logger.info("TC007 checking wish list working ");
		WishList_object wobj = new WishList_object(driver);
		wobj.clickwishlist();
		LoginPageobject lp = new LoginPageobject(driver);
		lp.setuseremail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickloginbuttion();
		SearchProduct sp = new SearchProduct(driver);
		sp.searchproduct(p.getProperty("searchproductname"));
		sp.btnclick();
		wobj.addtowishlist();
		
		
	}

}
