package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPageobject extends BasePage{
	
	public MyaccountPageobject(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement confmsg ;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;  //added for data driven test case
	
	//in below method we are not doing validation we only getting true or false 
	//on the return value that is either trur or false we do our validation in testcsae class 
	public boolean ismyaccountPageexist()
	{
		try
		{
		return (confmsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}

	}
	
	
	public void clicklogout()
	{
		lnklogout.click();
	}

}
