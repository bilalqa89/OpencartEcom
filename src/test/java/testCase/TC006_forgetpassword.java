package testCase;

import org.testng.annotations.Test;

import pageObject.ForgettpasswordObject;
import pageObject.HomepageObject;
import pageObject.LoginPageobject;
import testBase.BaseClassReusablemethod;

public class TC006_forgetpassword extends BaseClassReusablemethod  {
	@Test(groups={"Sanity","master"})
	
	public void forgetpassword()
	{
		logger.info("Forget password");
		try
		{
			HomepageObject hp = new HomepageObject(driver);
			hp.clickOnmyaccount();
			LoginPageobject lp = new LoginPageobject(driver);
			lp.clickforgetpassword();
			ForgettpasswordObject fp = new ForgettpasswordObject(driver);
			fp.clicklogin();
			
			
			
			
		}
		
		catch(Exception e)
		{
			
		}
	}

}
