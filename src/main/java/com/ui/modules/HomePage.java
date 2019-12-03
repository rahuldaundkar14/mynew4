package com.ui.modules;

import org.openqa.selenium.WebDriver;

import com.ui.pageobjects.HomePageObject;

public class HomePage {

	WebDriver driver;
	HomePageObject homePageObject;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		homePageObject = new HomePageObject(driver);
	}

	public void clickOnFeelingbtn() {
		homePageObject.butn1.click();
	}
	
	public void clickOnGmailbtn() {
		homePageObject.butn2.click();
	}
}
