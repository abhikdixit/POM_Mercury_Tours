package com.mercury.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.ofr.common.*;
import com.ofr.home.OfrSignInPage;

public class OfrLoginTest extends OfrTestBaseSetup{
	private WebDriver driver;
	private OfrBasePage basePage;
	private OfrSignInPage signInPage;

	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test
	public void loginTest() throws Exception{	
		basePage = new OfrBasePage(driver);		
		signInPage=basePage.GoToHomePageAndSignIn("testing", "testing");
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		System.out.println("Welcome to  selenium........");
	}
}
