package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	//Opencart
	@Test(groups= {"Regression","Master"})
	public void Verify_Account_Registration() 
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		//For accessing HomePage Methods we need to creat object for that class
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
			
		//Accessing AccountRegistrationpage class methods
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver) ;
		
		logger.info("Providing customer details...");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.clickPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating expected message..");
		
		//verifying confirm message
		String confmsg = regPage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
		
		logger.info("Test passed");
		//If any element or message not display it will throw exception to handle this we use try catch
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
		
	}

}
