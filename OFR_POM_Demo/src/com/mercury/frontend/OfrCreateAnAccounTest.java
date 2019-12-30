package com.mercury.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ofr.common.OfrTestBaseSetup;
import com.ofr.home.OfrSignUpPage;

/**
 * Class for Account related functionality
 * @author abhi
 */
public class OfrCreateAnAccounTest extends OfrTestBaseSetup{
	private WebDriver driver;
	private OfrSignUpPage createAccntPage;

	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test
	public void verifyCreateAnAccounPage() throws InterruptedException {
		System.out.println("Create An Account page test...");
		createAccntPage = new OfrSignUpPage(driver);
		createAccntPage.clickonRegister();
		Assert.assertTrue(createAccntPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(createAccntPage.verifySignInPageText(), "Page text not matching");
		System.out.println("done.......");
	}
}
