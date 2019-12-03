package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.core.managers.DriverManager;
import com.core.managers.PageObjectManager;
import com.core.managers.WebDriverManagers;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hook {
	WebDriver driver;
	//public static PageObjectManager pageObjectManager;
	WebDriverManagers webDriverManager = new WebDriverManagers();
	@AfterStep
		public void afterStep(Scenario scenario) throws Throwable {
			embedScreenshot(scenario);
		}
		
	@Before
	public void beforeScenario() {
		  String browser = System.getProperty("browser");
		  
		  
		  System.out.println("Browser is......." + browser);
	/*	System.setProperty("webdriver.chrome.driver",
				"D:\\workspace\\cucumber_latest\\CucumberProject\\driver\\chromedriver_77.exe");
		driver = new ChromeDriver();
		System.out.println("You are here1..............");
		driver.get("https://www.amazon.in/");
		DriverManager.setWebDriver(driver);*/
		//webDriverManager.createDriver("chrome", "http://google.com");
		//pageObjectManager = new PageObjectManager(DriverManager.getWebDriver());
	}

	@After
	public void afterScenario() {
		//driver.close();
		//WebDriverManagers.closeDriver();
		WebDriver driverInstance = DriverManager.getWebDriver();
		System.out.println("driverInstance...." + driverInstance);
		DriverManager.getWebDriver().close();
	}

	/**
	 * Captures and embeds screenshot in generated HTML report. Reports can be
	 * found in {@code /target/}.
	 * 
	 * @return byte[ ] - the screenshot in byte array
	 */
	public byte[] embedScreenshot(Scenario scenario) {
		byte[] srcBytes = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(srcBytes, "image/png");
		return srcBytes;
	}
}
