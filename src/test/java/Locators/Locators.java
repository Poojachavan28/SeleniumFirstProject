package Locators;

import org.openqa.selenium.By;

public class Locators {

		// TODO Auto-generated method stub
		public static final By crossButton = By.id("popup-widget111379-close-icon");
		public static final By userprofile = By.xpath("//a[@id='4']//div[@data-aid='MEMBERSHIP_ICON_DESKTOP_RENDERED']//*[name()='svg']");
		public static final By signin = By.xpath("(//a[text()=\"Sign In\"])[1]"); 	
		public static final By email = By.xpath("//input[@placeholder='Email']");
		public static final By password = By.name("password");
		public static final By loginbutton = By.xpath("//button[text()=\"Sign in\"]");
		public static final By userNotFound =By.xpath("//p[@role=\"alertdialog\"]");
		public static final By userFound =By.xpath("//span[text()=\"Hello pooja\"]");
		public static final By SignOut =By.xpath("//p[@id='n-6045960496-membership-sign-out']");

	}




