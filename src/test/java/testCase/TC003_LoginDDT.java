package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomepageObject;
import pageObject.LoginPageobject;
import pageObject.MyaccountPageobject;
import testBase.BaseClassReusablemethod;
import utilities.DataProviders;

/* possibilities of test case 
Data is valid
1.login successfull ....test pass 
2.login unsuccssfull... test fail 
Data is invalid
1.login successfull ... test fail
2.login unsuccessfull... test pass

*/
public class TC003_LoginDDT extends BaseClassReusablemethod {
	
	
	@Test(dataProvider="Logindata",dataProviderClass=DataProviders.class,groups="datadriven")
	
	public void verify_ddtlogin(String email,String pwd,String exp)
	{
		//Home page
		logger.info("Tc003 data driven test case ");
			try 
			{
		
				HomepageObject hp = new HomepageObject(driver);
				hp.clickOnmyaccount();
				hp.clickloginuser();
				
				//Login Page
				LoginPageobject lp = new LoginPageobject(driver);
				lp.setuseremail(email); //getting value from config file by using p we created in baseclass
				lp.setpassword(pwd);
				lp.clickloginbuttion();
				
				//My Account page
				
				MyaccountPageobject myacc = new MyaccountPageobject(driver);
				boolean targetpage = myacc.ismyaccountPageexist();
			
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetpage==true)
					{
						//myacc.clicklogout();
						myacc.clicklogout();
						Assert.assertTrue(true);
						
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				if(exp.equalsIgnoreCase("invalid"))
				{
					if(targetpage==true)
					{
						myacc.clicklogout();
						Assert.assertTrue(false);
					}
					else 
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
				
				//Assert.assertEquals(targetpage, true,"Login Fail");
				
				//Assert.assertTrue(targetpage); 
	}
	

}
