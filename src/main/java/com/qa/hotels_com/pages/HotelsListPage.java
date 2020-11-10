package com.qa.hotels_com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.hotels_com.util.ElementUtil;
import com.qa.hotels_com.util.JavaScriptUtil;

public class HotelsListPage {
	WebDriver driver;
	ElementUtil elementUtil;
	HotelsListPage listPage;

	By select3Star = By.cssSelector("#f-star-rating-3");
	By select4Star = By.cssSelector("#f-star-rating-4");
	By select5Star = By.cssSelector("#f-star-rating-5");
	By sendHotelName = By.cssSelector("#f-name");
	By click = By.id("f-name-cta");
	By listingText = By.className("p-name");
	By landmarks = By.cssSelector("#filter-landmarks");
	By airrport = By.id("f-lid-1664964");
	By mile = By.cssSelector("#f-distance");
	By loadBtn = By.cssSelector(".listings-pagination-cta");

	public HotelsListPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void verifyHilton() {
		elementUtil.doSendKeys(sendHotelName, "Hilton");
		elementUtil.doClick(click);

		elementUtil.doClick(select3Star);

		List<WebElement> list = elementUtil.getElements(listingText);

		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println(text);
			if (text.contains("Hilton")) {
				System.out.println("Hilton is 3 star hotel");
			}
		}

	}

	public void selectHotelsFeature() {
		// elementUtil.doClick(select3Star);
		JavaScriptUtil.specificScrollPageDown(driver);
		elementUtil.doClick(landmarks);
		elementUtil.doClick(airrport);
		elementUtil.doClick(mile);

		elementUtil.handleDropDownMenuByValue(mile, "5.0");

	}

	public List<String> hotels3star() throws InterruptedException {
		elementUtil.doClick(select3Star);
		listPage = new HotelsListPage(driver);
		listPage.selectHotelsFeature();

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		JavaScriptUtil.scrollPageDown(driver);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(loadBtn, "Load more properties"));
		Thread.sleep(3000);
		elementUtil.doClick(loadBtn);
		Thread.sleep(3000);

		List<WebElement> listhotel = elementUtil.getElements(listingText);
		System.out.println(listhotel.size());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listingText));
		ArrayList<String> hotels = new ArrayList<String>();
		for (WebElement elements : listhotel) {
			hotels.add(elements.getText());
		}

		List<String> list = hotels;
		System.out.println(list + "3 star hotels list");
		return list;

	}

	public List<String> getAll4StarHotels() {
		elementUtil.doClick(select4Star);

		listPage = new HotelsListPage(driver);
		listPage.selectHotelsFeature();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> listhotel = elementUtil.getElements(listingText);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listingText));
		ArrayList<String> hotels = new ArrayList<String>();
		for (WebElement elements : listhotel) {
			hotels.add(elements.getText());
		}

		List<String> list = hotels; // just tried to store as a List
		System.out.println(list + "4 star hotels list");
		return list;

	}

	public List<String> select5starHotels() throws InterruptedException {

		if (elementUtil.doIsSelected(select5Star)) {
			elementUtil.doClick(select5Star);
			listPage = new HotelsListPage(driver);
			listPage.selectHotelsFeature();

			Thread.sleep(2000);

			WebDriverWait wait = new WebDriverWait(driver, 20);

			JavaScriptUtil.scrollPageDown(driver);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(loadBtn, "Load more properties"));
			Thread.sleep(3000);
			elementUtil.doClick(loadBtn);
			Thread.sleep(3000);

			List<WebElement> listhotel = elementUtil.getElements(listingText);
			System.out.println(listhotel.size());
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listingText));
			ArrayList<String> hotels = new ArrayList<String>();
			for (WebElement elements : listhotel) {
				hotels.add(elements.getText());
			}

			List<String> list = hotels;
			System.out.println(list + "3 star hotels list");
			return list;

		} else {
			System.out.println("this element is not be selected");
		}
		return null;

	}

}
