package com.myBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configurations/Config.properties");
		try {

			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	
	
	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath=pro.getProperty("chromePath");
		return chromepath;
	}
	
	public String getedgePath() {
		String edgePath=pro.getProperty("edgePath");
		return edgePath;
	}



	public String GetApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}


}
