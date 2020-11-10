package com.qa.hotels_com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.hotels_com.util.CONSTANTS;
import com.qa.hotels_com.util.ElementUtil;


public class HomePage {
	WebDriver driver;
	ElementUtil elementUtil;

	
	
	By destination=By.cssSelector("#qf-0q-destination");

	By element=By.id("citysqm-asi0-s0");
	By checkInBtn= By.cssSelector("#widget-query-label-2");
	By checkOutBtn=By.cssSelector("#qf-0q-localised-check-out");
	By checkInDay=By.xpath("//td[@data-date='2020-10-16']");
	By checkOutDay=By.xpath("//td[@data-date='2020-10-30']");		
	
	By selectRoom=By.id("qf-0q-rooms");
	By selectAdult=By.id("qf-0q-room-0-adults");
	By selectChild=By.id("qf-0q-room-0-children");
	By selectChild1Age=By.id("qf-0q-room-0-child-0-age");
	By selectChild2Age=By.id("qf-0q-room-0-child-1-age");
	By searchBtn=By.xpath("//button[@type='submit']");
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public HotelsListPage sendDestination(){
		elementUtil.doSendKeys(destination,CONSTANTS.DESTINATION);
		elementUtil.doClick(destination);
		elementUtil.doClick(element);
		elementUtil.doClick(checkInBtn);
		
		elementUtil.doClick(checkInDay);
		elementUtil.doClick(checkOutBtn);
		elementUtil.doClick(checkOutDay);
		elementUtil.handleDropDownMenuByValue(selectRoom, "1");
		elementUtil.handleDropDownMenuByValue(selectAdult, "2");
		elementUtil.handleDropDownMenuByValue(selectChild, "2");
		elementUtil.handleDropDownMenuByValue(selectChild1Age, "4");
		elementUtil.handleDropDownMenuByValue(selectChild2Age, "9");
		elementUtil.doClick(searchBtn);
		return new HotelsListPage(driver);
	}
	public String verifyTitle(){
		return elementUtil.doGetPageTitle();
	}
	

}
