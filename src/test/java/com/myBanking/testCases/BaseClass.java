package com.myBanking.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;

import com.myBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	public String url = rc.GetApplicationUrl();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;

	public static Logger logger;


	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromepath());
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", rc.getedgePath());
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
	
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	public String RandomString() {
		String genString = RandomStringUtils.randomAlphabetic(8);
		return(genString);
	}
}
