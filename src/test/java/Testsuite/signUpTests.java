package Testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Locators.Locators;
import Locators.signUpLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class signUpTests {
WebDriver driver;
	
	//Method for all the negative tests
	public void NegativeSignUpTests(String FirstName, String LastName, String Email, String Phone)
	{
		
		driver.findElement(signUpLocators.firstName).sendKeys(FirstName);
		driver.findElement(signUpLocators.lastName).sendKeys(LastName);
		driver.findElement(signUpLocators.emailId).sendKeys(Email);
		driver.findElement(signUpLocators.phoneNumber).sendKeys(Phone);
		
		
		
	}
	
	@BeforeSuite
	//Positive Test Case
	public void SignupInvalidEmail() 
	{
	
		//set up the Chrome browser
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    //to open the site
	    driver.get("https://candymapper.com/");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(Locators.crossButton).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(Locators.userprofile).click();
		driver.findElement(signUpLocators.createAccount).click();
	    NegativeSignUpTests("John", "Marker", "abc", "123456679");
	    driver.findElement(signUpLocators.checkBox).click();
	    driver.findElement(signUpLocators.createAccountButton).click();
	   Assert.assertTrue(driver.findElement(signUpLocators.invalidEmail).isDisplayed(), "Email is invalid");
	   
	}
	@Test(priority=15)
	//Positive Test Case
	public void SignupCheckBox() 
	{
	    NegativeSignUpTests("John", "Marker", "abc@gmail.com", "123456679");
	    driver.findElement(signUpLocators.checkBox).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(signUpLocators.createAccountButton).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Assert.assertTrue(driver.findElement(signUpLocators.successfulsignUp).isDisplayed(), "Works fine even after checkbox is unticked");
	}
	@Test(priority=10)
	public void SignupInvalidEmail1() 
	{
	    NegativeSignUpTests("John", "Marker", "abc@gmail", "123456679");
	    driver.findElement(signUpLocators.createAccountButton).click();
	    Assert.assertTrue(driver.findElement(signUpLocators.invalidEmail).isDisplayed(), "Email is invalid");
	}
	@Test(priority=11)
	public void SignupInvalidEmail2() 
	{
	    NegativeSignUpTests("John", "Marker", "abc@gmail.", "123456679");
	    driver.findElement(signUpLocators.createAccountButton).click();
        Assert.assertTrue(driver.findElement(signUpLocators.invalidEmail).isDisplayed(), "Email is invalid");
	}
	@Test(priority=12)
	public void SignupEmptyFirstName() 
	{
	    NegativeSignUpTests("   ", "Marker", "abc", "123456679");
	    driver.findElement(signUpLocators.createAccountButton).click();
	    Assert.assertTrue(driver.findElement(signUpLocators.emptyFirstName).isDisplayed(), "First Name is empty");
	}
	@Test(priority=13)
	public void SignupEmptyLastName() 
	{
	    NegativeSignUpTests("John", "  ", "abc", "123456679");
	    driver.findElement(signUpLocators.createAccountButton).click();
	    Assert.assertTrue(driver.findElement(signUpLocators.emptyLastName).isDisplayed(), "Last name is empty");
	    
	}
	@Test(priority=14)
	public void SignupEmptyEmail() 
	{
	    NegativeSignUpTests("John", "Marker", "   ", "123456679");
	    driver.findElement(signUpLocators.createAccountButton).click();
	    Assert.assertTrue(driver.findElement(signUpLocators.invalidEmail).isDisplayed(), "Email id is empty");
	    
	}	
	@BeforeMethod
    public void clear() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(signUpLocators.firstName).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(signUpLocators.lastName).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(signUpLocators.emailId).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(signUpLocators.phoneNumber).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }
	
	@AfterSuite
	public void tearDown()
	{
	if (driver != null) {
	    driver.quit();
	}
	}

}
