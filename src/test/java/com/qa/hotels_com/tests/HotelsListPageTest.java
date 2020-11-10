package com.qa.hotels_com.tests;

import java.util.List;
import java.util.Properties;

import org.jsoup.select.Evaluator.ContainsData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotels_com.base.BasePage;
import com.qa.hotels_com.pages.HomePage;
import com.qa.hotels_com.pages.HotelsListPage;
import com.qa.hotels_com.util.CONSTANTS;


public class HotelsListPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	HotelsListPage listPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	
		listPage = homePage.sendDestination();
		

	}

	@Test(priority = 1, description = "verify Hilton is 3 star", enabled=true)
	public void verifyHiltonIs3Star() {
		listPage.verifyHilton();
	}
	
	@Test(priority = 2, description = "Select hotels feature", enabled=true)
	public void getHotelsFeatureL(){
		listPage.selectHotelsFeature();
}


	@Test(priority = 3, description = "Get 3 star hotels ", enabled=true)
	public void verifyhotels3() throws InterruptedException {
		List<String> hotelLinksList = listPage.hotels3star();
		String hotelLinks = hotelLinksList.toString();
		Assert.assertTrue(true, hotelLinks);
	

	}
	@Test(priority = 4, description = "Get 4 star hotels ", enabled=true)
	public void get4StarHotels(){
		List<String> list=listPage.getAll4StarHotels();
		String hotelsLink=list.toString();
		Assert.assertTrue(true, hotelsLink);
		
	}
	@Test(priority=5, description="Get 5 star hotels", enabled=true)
	public void get5starHotelsList() throws InterruptedException{
		listPage.select5starHotels();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
