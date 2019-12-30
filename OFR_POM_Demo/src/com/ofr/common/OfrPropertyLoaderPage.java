package com.ofr.common;

import java.io.*;
import java.util.*;

/**
 * This class to load properties
 * Default properties are in src/test/resources/defaultTest.properties
 * @author Abhi
 *
 */
public class OfrPropertyLoaderPage {
	protected static String UserBROWSER;
	private String username;
	private String password;
	private String URL;
	
	public static Properties loadDefaultPropsFile() throws IOException {
		String propsPath = "com/ofr/resources/defaultTest.properties";
		File propsFile = new File(propsPath);
		if (!propsFile.canRead()) System.out.println("Could not load properties file " + propsFile);
		Properties testProps = new Properties();
		InputStream inputStream = new FileInputStream(propsFile);
		testProps.load(inputStream);
		testProps.putAll(System.getProperties());
		inputStream.close();
		return testProps;
	}
	private void applyProps(Properties testProps) throws IOException {
		// Test environment
		username = testProps.getProperty("username");
		password = testProps.getProperty("password");
		URL = testProps.getProperty("OfrUrl");
		UserBROWSER = testProps.getProperty("BROWSER");
	}
}


