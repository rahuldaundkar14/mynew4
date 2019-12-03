package com.core.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class LoggerService {
	static Logger log = Logger.getLogger(Logger.class.getName());
	
	static {
		DOMConfigurator.configure("log4j.xml");
		info("START LOGGER");
		info("*********************************************************");
		info("##############  StartAutomation suite  #############");
		info("*********************************************************");
	}

	/*******************************************************************************
	 * Log a message to the console, TestNG Report and Extents Report
	 * 
	 * @param message to print
	 * 
	 *******************************************************************************/
	public static void logMessage(String message) {
		info(message);
		System.out.println("Output.......");
	}

	public static void info(String strMessage) {
		log.info(strMessage);
	}

	public static void debug(String strMessage) {
		log.info(strMessage);
	}
	
	public static void warn(String strMessage) {
		log.warn(strMessage);
	}

	public static void error(String message) {
		log.error(message);
	}
}
