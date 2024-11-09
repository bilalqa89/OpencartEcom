package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomepageObject;
import pageObject.LoginPageobject;
import pageObject.MyaccountPageobject;
import testBase.BaseClassReusablemethod;

public class TC002_LoginTest extends BaseClassReusablemethod {
	
	@Test(groups={"Sanity","master"})
	public void verify_login()
	{
		logger.info("TC002 TEST CASE LOGIN START");
		try
		{
		//Home page
		HomepageObject hp = new HomepageObject(driver);
		hp.clickOnmyaccount();
		hp.clickloginuser();
		
		//Login Page
		LoginPageobject lp = new LoginPageobject(driver);
		lp.setuseremail(p.getProperty("email")); //getting value from config file by using p we created in baseclass
		lp.setpassword(p.getProperty("password"));
		lp.clickloginbuttion();
		
		//My Account page
		
		MyaccountPageobject myacc = new MyaccountPageobject(driver);
		boolean targetpage = myacc.ismyaccountPageexist();
		//Assert.assertEquals(targetpage, true,"Login Fail");
		
		Assert.assertTrue(targetpage); //both are true then test pass
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("TC002 TEST CASE LOGIN Finish");
		
		
		
	}

}
