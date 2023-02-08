package com.myBanking.testCases;

import org.testng.annotations.Test;

import com.myBanking.pageObjects.LoginPage;

import java.io.IOException;

import org.testng.AssertJUnit;

public class TC_Logintest_001 extends BaseClass {

	@Test
	public void Logintest() throws IOException {

		
		logger.info("url is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			AssertJUnit.assertTrue(true);
			logger.info("Login test passed");

		} else {
			
			captureScreenshot(driver,"Logintest");
			AssertJUnit.assertTrue(false);
			logger.info("test failed");
		}

	}

}
