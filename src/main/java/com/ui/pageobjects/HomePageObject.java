package com.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='FPdoLc tfB0Bf']//input[@name='btnI']")
	public WebElement butn1;
	
	@FindBy(xpath="//a[contains(text(),'Gmail')]")
	public WebElement butn2;
}
