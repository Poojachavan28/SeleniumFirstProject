package Testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import Locators.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInTests {
	
	WebDriver driver;
	
	//Method for all the negative tests
	public void NegativeSignInTests(String Username, String Password)
	{
	
		driver.findElement(Locators.email).sendKeys(Username);
		driver.findElement(Locators.password).sendKeys(Password);	
		driver.findElement(Locators.loginbutton).click();
		
	}
	
	@Test(priority=5)
	//Positive Test Case
	public void verifyUserFound() 
	{
		//to
		//set up the chrome browser
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    //to open the site
	    driver.get("https://candymapper.com/");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    driver.findElement(Locators.crossButton).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(Locators.userprofile).click();
	    driver.findElement(Locators.signin).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //positive test
		driver.findElement(Locators.email).sendKeys("pooja28chavan@gmail.com");
		driver.findElement(Locators.password).sendKeys("Password");	
		driver.findElement(Locators.loginbutton).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//assertion for the positive test 
		String Url = driver.getCurrentUrl();
		Assert.assertEquals(Url, "https://candymapper.com/m/account", "User Login was successful");
		//to sign out
		driver.findElement(Locators.userprofile).click();
		driver.findElement(Locators.SignOut).click();

	}
	@Test(priority=6)
	//Negative Test Case
	public void verifyUserNotFound()
	{
		driver.findElement(Locators.userprofile).click();
	    driver.findElement(Locators.signin).click();
		NegativeSignInTests("poojachavan@gmail.com","paooosfjiohfuehf");
		Assert.assertTrue(driver.findElement(Locators.userNotFound).isDisplayed(), "User does not exist");
		
	}
	
	@Test(priority=7)
	//Negative Test Case
	public void passwordEmpty()
	{
		NegativeSignInTests("poojachavan@gmail.com","");
		Assert.assertTrue(driver.findElement(Locators.userNotFound).isDisplayed(), "Password is required.");
		
	}
	@Test(priority=8)
	//Negative Test Case
	public void usernameEmpty()
	{
		NegativeSignInTests("","password");
		Assert.assertTrue(driver.findElement(Locators.userNotFound).isDisplayed(), "Username is required.");
		
	}
	@Test(priority=9)
	//Negative Test Case
	public void passwordIncorrect()
	{
		NegativeSignInTests("pooja28chavan@gmail.com","123456789");
		Assert.assertTrue(driver.findElement(Locators.userNotFound).isDisplayed(), "Password is incorrect.");
		
	}
	@AfterSuite
	public void tearDown()
	{
	if (driver != null) {
	    driver.quit();
	}
	}

}

