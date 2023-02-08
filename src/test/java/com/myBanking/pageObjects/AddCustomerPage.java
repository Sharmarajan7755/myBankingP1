package com.myBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	@FindBy(xpath="//a[@href=\"addcustomerpage.php\"]")
	@CacheLookup
	WebElement newCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtcustomername;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement radiogender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtcustomeradrss;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtpin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtphonenum;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickAddnewCustomer() {

		newCustomer.click();
	}
	
	public void CustomerName(String cusname) {

		txtcustomername.sendKeys(cusname);
	}
	
	public void CustGender(String cgender) {

		radiogender.click();
	}
	
	public void cusDob(String dd,String mm,String yy) {

		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
		
	}

	public void cusAddress(String address) {

		txtcustomeradrss.sendKeys(address);
	}
	
	public void cusCity(String city) {

		txtcity.sendKeys(city);
	}
	
	public void cusState(String state) {

		txtstate.sendKeys(state);
	}
	
	public void cusPincode(String cpin) {

		txtpin.sendKeys(String.valueOf(cpin));
	}
	
	public void cusPhonenum(String cphonenum) {

		txtphonenum.sendKeys(String.valueOf(cphonenum));
	}
	public void cusEmailId(String cemailid) {

		txtemail.sendKeys(cemailid);
	}
	
	public void cusPassword(String cpwd) {

		txtpassword.sendKeys(cpwd);
	}

	public void clickSubmit() {

		btnsubmit.click();
	}
}
