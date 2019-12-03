package com.stepdefn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.logger.LoggerService;
import com.core.managers.DriverManager;
import com.core.managers.WebDriverManagers;
import com.hooks.Hook;
import com.ui.modules.HomePage;

import cucumber.api.java.en.Given;

public class Steps {

	HomePage homePage;
	WebDriverManagers webDriverManager;
	//WebDriver driver;
	
	@Given("^Open the app$")
	public void open_the_app() throws Throwable {
		System.out.println("Yo Yo hnnyyy");
		
		System.out.println("Home Page object:" + homePage);
		homePage.clickOnFeelingbtn();
		Thread.sleep(5000);
		/*System.setProperty("webdriver.chrome.driver", "D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\chromedriver_77.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		Thread.sleep(5000);
		driver.close();*/
	}
	
	@Given("^Open the app1$")
	public void open_the_app1() throws Throwable {
		System.out.println("Yo Yo hnnyyy1111");
		System.out.println("Home Page object:" + homePage);
		homePage.clickOnGmailbtn();
		Thread.sleep(5000);
		/*System.setProperty("webdriver.chrome.driver", "D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\chromedriver_77.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.close();*/
	}
	
	@Given("^Open the app3$")
	public void open_the_app3() throws Throwable {
		System.out.println("Yo Yo hnnyyy1111");
		System.out.println("Home Page object:" + homePage);
		homePage.clickOnGmailbtn();
		Thread.sleep(5000);
		/*System.setProperty("webdriver.chrome.driver", "D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\chromedriver_77.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.close();*/
	}
	
	@Given("^Open the browser \"(.*)\" with url \"(.*)\"$")
	public void open_the_browser(String browser, String url) throws Throwable {
		webDriverManager = new WebDriverManagers();
		LoggerService.info("Open the browser");
		
		//homePage.clickOnGmailbtn();
		Thread.sleep(5000);
		try {
		webDriverManager.createDriver(browser, url);
		} catch(Exception e) {
			System.out.println(e);
		}
		//homePage = WebDriverManagers.pageObjectManager.getHomePage();
		//webDriverManager = WebDriverManagers.pageObjectManager.getWebDriverManager();
		/*System.setProperty("webdriver.chrome.driver", "D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\chromedriver_77.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.close();*/
	}
	
	@Given("^Close the browser$")
	public void close_the_browser() throws Throwable {
		DriverManager.getWebDriver().close();
	}
	
}
