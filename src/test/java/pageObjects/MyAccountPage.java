package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElements
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	//Action Methods
	/*If My account  msg is displayed it will return true. And if not displayed it will
	  throw exception.Once it throws exception we will catch it and under catch we will return
	  false*/
	public boolean isMyAccountPageExists() {
		try {
			return(msgHeading.isDisplayed());
		} catch(Exception e) {
			return(false);
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}











