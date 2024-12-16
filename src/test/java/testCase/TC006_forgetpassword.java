package testCase;

import org.testng.annotations.Test;

import pageObject.ForgettpasswordObject;
import pageObject.LoginPageobject;
import testBase.BaseClassReusablemethod;

public class TC006_forgetpassword extends BaseClassReusablemethod  {
	@Test(groups={"Sanity","master"})
	
	public void forgetpassword()
	{
		logger.info("Forget password");
		try
		{
			ForgettpasswordObject fp = new ForgettpasswordObject(driver);
			fp.clicklogin();
			LoginPageobject lp = new LoginPageobject(driver);
			lp.clickforgetpassword();
			
		}
		
		catch(Exception e)
		{
			
		}
	}

}
