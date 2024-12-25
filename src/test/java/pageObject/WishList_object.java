package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList_object extends BasePage{

	public WishList_object(WebDriver driver) {
		super(driver);
		
	}
	
	//locators 
	
	@FindBy(xpath="//span[normalize-space()='Wish List (0)']")
	WebElement lnkwishlist ;
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement lnkaddwishlist;
	
	public void clickwishlist()
	{
		lnkwishlist.click();
	}
	
	public void addtowishlist()
	{
		lnkaddwishlist.click();
		
	}
	

}
