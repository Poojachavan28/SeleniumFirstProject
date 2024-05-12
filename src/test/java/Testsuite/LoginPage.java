package Testsuite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import Locators.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginPage {
	

	    WebDriver driver;

	    @Test(priority = 2)
	    public void verifyUserProfileIconClickable()  {
	       	System.out.print(driver.findElement(Locators.crossButton).getTagName());
	        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	        driver.findElement(Locators.crossButton).click();
	        Assert.assertTrue(driver.findElement(Locators.userprofile).isEnabled(), "UserProfile is clickable");
	        
	    }

	
	@Test(priority=1)
	public void verifyTitle()  {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://candymapper.com/");
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String title = driver.getTitle();
		String expectedTitle = "CandyMapper.Com";
		Assert.assertEquals(title, expectedTitle);
	   
	}
	
	
	@Test(priority=3)
	public void verifyUserProfileIconRedirection() 
	{
		driver.findElement(Locators.userprofile).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(Locators.signin).isDisplayed(),  "UserProfile icon was redirected to the expected page" );
	}

	@Test(priority=4)
	public void verifySignInPage() 
	{
		driver.findElement(Locators.signin).click();
		String pageTitle = driver.getTitle();
		String expectedpageTitle = "Login";
		Assert.assertEquals(pageTitle, expectedpageTitle);
	}
	
@AfterSuite
	public void tearDown()
	{
	if (driver != null) {
	    driver.quit();
	}
	}
}

	

		



