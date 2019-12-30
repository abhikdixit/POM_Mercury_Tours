package com.ofr.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class OfrSignInPage {
	private WebDriver driver;
	
	public OfrSignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Find a Flight: Mercury Tours:";
		return getSignInPageTitle().contains(expectedTitle);
	}
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifySignInPageText() {
		WebElement element = driver.findElement(By.xpath(("//a[contains(.,'SIGN-OFF')]")));	
		String pageText = element.getText();
		String expectedPageText = "SIGN-OFF";
		return pageText.contains(expectedPageText);
	}
	
}
