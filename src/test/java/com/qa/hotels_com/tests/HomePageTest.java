package com.qa.hotels_com.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotels_com.base.BasePage;
import com.qa.hotels_com.pages.HomePage;import com.qa.hotels_com.util.CONSTANTS;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver=basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	}

	@Test(priority=1, description="fill out where to go form", enabled=true)
	public void selectWhereToGo() {
		homePage.sendDestination();
	}
	
	@Test(priority=2, description="verify page title", enabled=true)
	public void verifyHomePageTitle(){
		String title = homePage.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, CONSTANTS.HOMEPAGE_TITLE);

		
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
