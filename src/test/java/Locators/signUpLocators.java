package Locators;

import org.openqa.selenium.By;

public class signUpLocators {
	
	public static final By createAccount = By.xpath("//li/a[@href=\"/m/create-account\"]");
	public static final By firstName = By.xpath("//input[@placeholder=\"First name\"]");
	public static final By lastName = By.xpath("//input[@placeholder=\"Last name\"]");
	public static final By emailId = By.xpath("//input[@placeholder=\"Email\"]");
	public static final By phoneNumber = By.xpath("//input[@placeholder=\"Phone (optional)\"]");
	public static final By checkBox = By.xpath("//label/div[@data-ux=\"Element\"]");
	public static final By createAccountButton = By.xpath("//button[text()=\"Create Account\"]");
	public static final By invalidEmail = By.xpath("//p[text()=\"Enter a valid email address.\"]");
	public static final By emptyFirstName = By.xpath("//p[text()=\"Enter your first name.\"]");
	public static final By emptyLastName = By.xpath("//p[text()=\"Enter your last name.\"]");
	public static final By successfulsignUp = By.xpath("//h4[@role='heading']");
}
