package com.core.managers;

import org.openqa.selenium.WebDriver;

import com.ui.modules.CartPage;
import com.ui.modules.CheckoutPage;
import com.ui.modules.HomePage;

public class PageObjectManager {

	private WebDriver driver;

	private CartPage cartPage;

	private HomePage homePage;

	private CheckoutPage checkoutPage;
	
	private WebDriverManagers webDriverManager;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

	public CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
	}
	
	public WebDriverManagers getWebDriverManager() {
		return (webDriverManager == null) ? webDriverManager = new WebDriverManagers() : webDriverManager;
	}
}
