package com.core.managers;

import org.openqa.selenium.WebDriver;


public class DriverManager {

	public static final ThreadLocal<WebDriver> webDriverPool = new ThreadLocal<>();

	public static ThreadLocal<String> deviceNamePool= new ThreadLocal<>();
	public static ThreadLocal<String> platformPool= new ThreadLocal<>();
	public static ThreadLocal<String> platformVersionPool= new ThreadLocal<>();
	public static ThreadLocal<String> udidPool= new ThreadLocal<>();
	public static ThreadLocal<String> automationNamePool= new ThreadLocal<>();
	public static ThreadLocal<String> systemPortPool= new ThreadLocal<>();
	
	/*********************************************************************************
     * Sets the Driver for current session
     * 
     * 
     **********************************************************************************/
    public static synchronized void setWebDriver(WebDriver driver) {
    	webDriverPool.set(driver);
    }
    
    /************************************************************************************
     * Gets the Driver instance for current session
     * 
     * @return driver
     ************************************************************************************/
    public static WebDriver getWebDriver() {
        return webDriverPool.get();
    }
    
    
    public static synchronized void setDeviceName(String device) {
    	deviceNamePool.set(device);
    }
    
    public static String getDeviceName() {
        return deviceNamePool.get();
    }
    
    public static synchronized void setPlatform(String platform) {
    	platformPool.set(platform);
    }
    
    public static String getPlatform() {
        return platformPool.get();
    }
    
    public static synchronized void setPlatformVersion(String platformVer) {
    	platformVersionPool.set(platformVer);
    }
    
    public static String getPlatformVersion() {
        return platformVersionPool.get();
    }
    
    public static synchronized void setUdid(String udid) {
    	udidPool.set(udid);
    }
    
    public static String getUdid() {
        return udidPool.get();
    }
    
    public static synchronized void setAutomationName(String automationName) {
    	automationNamePool.set(automationName);
    }
    
    public static String getAutomationName() {
        return automationNamePool.get();
    }
    
    public static synchronized void setSystemPort(String systemPort) {
    	systemPortPool.set(systemPort);
    }
    
    public static String getSystemPort() {
        return systemPortPool.get();
    }
    
}
