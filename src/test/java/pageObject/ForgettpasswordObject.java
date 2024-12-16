package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgettpasswordObject extends BasePage{

	public ForgettpasswordObject(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	
	@FindBy(xpath="//a[normalize-space()='Login']") 
	WebElement loginmyaccount;
	
	//action 
	
	public void clicklogin()
	{
		loginmyaccount.click();
		
	}

	
}
