package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountregistrationObject;
import pageObject.HomepageObject;
import testBase.BaseClassReusablemethod;

public class TC001_AccountRegistration extends BaseClassReusablemethod {
	
	
	
	
	@Test(groups={"Regression","master"})
	public void RegisternewUser()
	{
		logger.info("TC001 Account registration loggin");
		try
		{
			
			
		HomepageObject hp = new HomepageObject(driver);
		
		
		hp.clickOnmyaccount();
		hp.clickOnregister();
		logger.info("Click on Registration");
		AccountregistrationObject regpage = new AccountregistrationObject(driver);
		logger.info("Providing customer detail logs ");
		regpage.setfirstname(randomfirstname());
		regpage.setlastname(randomlastname());
		regpage.setemail(randomemail()+"@yahoo.com");
		regpage.setphoneno(rondomphoneno());
		String password = randompassword();
		regpage.setpassword(password);
		regpage.confirmpassword(password);
		regpage.clickcheckbox();
		regpage.checkpolicy();
		regpage.btnregister();
		logger.info("Validating customer registration");
		String confmsg = regpage.confirmationmsg();
		
		
	//	Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
				Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		
		}
		catch (Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("Finish TC0011 signup with randomly genrate user");
		
		
	}

}
