package com.core.managers;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagers {

	private static String path = System.getProperty("user.dir");
	WebDriver driver;
	public static PageObjectManager pageObjectManager;

	/**
	 * Creates driver depends on current device type (Android, iOS)
	 * 
	 * @param groups2
	 *
	 * @param capabilities
	 *            {@link DesiredCapabilities}
	 */
	public void createDriver(String browser, String urls) {
		//browser = "firefox";
		//mvn -DBROWSER=chrome -DBROWSER=firefox test
		//https://stackoverflow.com/questions/17332857/how-to-use-the-mvn-d-to-set-multiple-properties-in-maven-via-command-line
		String url = System.getProperty("url");
		
		System.out.println("URLLLL is:" + url);
		if(url==null) {
			url = urls; 
		}
		if (browser == null) {
			browser = System.getenv("browser");
			if (browser == null) {
				browser = "chrome";
			}
		}
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\chromedriver_77.exe");
			driver = new ChromeDriver();
			/*WebDriverManager.chromedriver().version("78.0.3904.11").setup();
			driver = new ChromeDriver();*/
			System.out.println("You are here1..............");
			driver.get(url);
			System.out.println("Before Setting Driver...");
			DriverManager.setWebDriver(driver);
			pageObjectManager = new PageObjectManager(DriverManager.getWebDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"D:\\workspace\\cucumber_extents_latest\\CucumberParallel\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			System.out.println("Before Setting Driver...");
			DriverManager.setWebDriver(driver);
			break;
		case "ie":
			// driver = new InternetExplorerDriver();
			break;
		case "safari":
			// driver = new SafariDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		System.out.println("Opening Browser...." + browser);
		driver.manage().deleteAllCookies();
		try {

			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Closes driver
	 */
	public static void closeDriver() {
		WebDriver driverInstance = DriverManager.getWebDriver();
		System.out.println("driverInstance...." + driverInstance);
		// put quit() method to try/catch as shitty appium server may crash at
		// any moment
		/*
		 * try { if (Objects.nonNull(driverInstance)) {
		 * DriverManager.webDriverPool.remove(); driverInstance.quit(); } }
		 * catch (WebDriverException e) { //LoggerService.
		 * error("Oops, looks like the driver has quited a bit earlier..."); }
		 */
		driverInstance.close();
	}
}
