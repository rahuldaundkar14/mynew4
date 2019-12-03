package com.stepdefn;

import com.core.managers.WebDriverManagers;
import com.ui.modules.HomePage;

import cucumber.api.java.en.Given;

public class Steps1 {

	HomePage homePage = WebDriverManagers.pageObjectManager.getHomePage();
	
	@Given("^Click on Gmail button$")
	public void click_on_Gmail_button() throws Throwable {
		System.out.println("Yo Yo hnnyyy1111");
		System.out.println("Home Page object:" + homePage);
		Thread.sleep(5000);
		homePage.clickOnGmailbtn();
		Thread.sleep(5000);
		/*System.setProperty("webdriver.chrome.driver", "D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\chromedriver_77.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.close();*/
	}
	
}
