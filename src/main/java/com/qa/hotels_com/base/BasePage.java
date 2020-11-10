package com.qa.hotels_com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;

	
	
	public WebDriver init_driver(String browserName){
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else{
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
	}
	public Properties init_properties(){
		prop=new Properties();
		String path="./src/main/java/com/qa/hotels_com/config/config.properties";
		
		try {
			FileInputStream ip=new FileInputStream(path);
			prop.load(ip);
			
		} catch (NoSuchFileException e) {
			System.out.println("some problem occured while prop loading. Please check your config");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}

}
