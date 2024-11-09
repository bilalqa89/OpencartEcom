package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomepageObject extends BasePage{
	
	public HomepageObject(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath= "//span[normalize-space()='My Account']") 
	WebElement linkmyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkregister ;
	
	@FindBy(xpath="//a[normalize-space()='Login']") 
	WebElement loginmyaccount;
	
	public void clickloginuser()
	{
		loginmyaccount.click();
	}
	
	public void clickOnmyaccount()
	{
		linkmyaccount.click();
	}
	public void clickOnregister()
	{
		linkregister.click();
	}
	

}
