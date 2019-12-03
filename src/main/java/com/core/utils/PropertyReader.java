package com.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	Properties p = new Properties();

	public Properties getObjectRepository() {
		// Read object repository file
		InputStream stream = null;
		try {
			stream = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\src\\test\\resources\\OR.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// load all objects
		try {
			p.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public Properties getProperties(String fileName) {
		
		String file = System.getProperty("user.dir") + "\\src\\test\\resources\\"+fileName+".properties";
		// Read object repository file
		InputStream stream = null;
		try {
			stream = new FileInputStream(
					new File(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// load all objects
		try {
			p.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
