package com.myBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myBanking.pageObjects.LoginPage;
import com.myBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user, String pwd) {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()== true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/myBanking/testData/excel_data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
