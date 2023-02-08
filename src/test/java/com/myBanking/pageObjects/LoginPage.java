package com.myBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//input[@name=\"uid\"]")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath = "//a[@href=\"Logout.php\"]")
	@CacheLookup
	WebElement logOut;

	public void setUserName(String uname) {

		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		txtpassword.sendKeys(pwd);
	}

	public void clickSubmit() {

		btnlogin.click();
	}
	
	public void clickLogOut() {
		logOut.click();
	}

	
}
