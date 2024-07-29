package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//Constructor
	public HomePage (WebDriver driver) {
		super(driver);
		
	}
	
	//WebElements
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")   // Login link added in step5
	WebElement linkLogin;
	
	//Action Methods
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()    // added in step5
	{
		linkLogin.click();
	}
}
