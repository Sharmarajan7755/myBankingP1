package com.myBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myBanking.pageObjects.AddCustomerPage;
import com.myBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		logger.info("url is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcuspage = new AddCustomerPage(driver);
		
		logger.info("Customer details providing .. ..");
		addcuspage.clickAddnewCustomer();
		addcuspage.CustomerName("Rajan");
		addcuspage.CustGender("Male");
		addcuspage.cusDob("27", "06", "1996");
		Thread.sleep(3000);
		addcuspage.cusAddress("India");
		addcuspage.cusCity("Kapurthala");
		addcuspage.cusState("Punjab");
		addcuspage.cusPincode("144601");
		addcuspage.cusPhonenum("9928238384");
		
		String email =RandomString()+"@gmail.com";
		addcuspage.cusEmailId(email);	
		addcuspage.cusPassword("adgjhjzdb");
		addcuspage.clickSubmit();
		Thread.sleep(3000);
		logger.info("Customer validating. . . . .");
		boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test passed");
		}
		else {
			logger.info("Test failed");
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
	
	

}
