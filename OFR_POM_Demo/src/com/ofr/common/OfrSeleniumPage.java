package com.ofr.common;


import java.util.Random;

import org.openqa.selenium.*;


/**
 * Class for Selenium related functionality
 * @author 
 */
public class OfrSeleniumPage {	
	protected WebDriver driver;	

	public WebDriver getDriver() {		
		return this.driver;
	}

	public void windowMaximize(){
		driver.manage().window().maximize();
		/*try{
			driver.manage().window().maximize();
		}catch(Exception ex){
			//window maximize not supported for driver or browser (e.g. Chrome)
			//so use javascript workaround
			String winMaxScript = "if(window.screen){window.moveTo(0,0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);}";
			executeJavascript(winMaxScript);			
		}*/
	}

	/*public Object executeJavascript(String javascript){
		return ((JavascriptExecutor)driver).executeScript(javascript);
	}*/

	/**
	 * Close the browser (all open windows) and ends current Selenium session.
	 */
	public void close() {
		driver.quit();
	}

	/**
	 * Close currently selected browser window, when multiple windows open.
	 * Otherwise, closes the single main browser window, and ends current Selenium session.
	 */
	public void closeWindow(){
		driver.close();
	}

	public void open(String url){
		driver.get(url);
	}	
	public static String randomNum(int length) {
		Long random = new Random().nextInt(length) + System.currentTimeMillis();
		return random.toString();
	}

}
