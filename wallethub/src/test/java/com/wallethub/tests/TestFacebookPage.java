package com.wallethub.tests;

import org.testng.annotations.Test;

import com.wallethub.base.TestBase;
import com.wallethub.pages.FacebookHomePage;
import com.wallethub.pages.FacebookPage;

import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestFacebookPage extends TestBase {
	
	public WebDriver driver;
	public FacebookPage facebookPage;
	public FacebookHomePage facebookHomePage;
	
	private String userName = "";
	private String userPassword = "";
	
	private String statusMessage = "Hello World";
	
	  @BeforeClass
	  @Parameters({"browser", "URL"})
	  public void setup(String browser, String URL) {
		  
		  this.driver = launchBrowser(browser, URL);		  
		  
	  }
	
	  @Test
	  public void loginTest() {
		  
		  this.facebookPage = new FacebookPage(driver);
		  facebookPage.facebookLogin(userName, userPassword);
		
	  }	  
	  
	  @Test(dependsOnMethods = "loginTest")
	  public void postStatusTest() {
		  
		  this.facebookHomePage = new FacebookHomePage(driver);
		  facebookHomePage.postNewStatus(statusMessage);
		  
	  }	  
	  
	  @AfterClass
	  public void teardown() {
		  close();
	  }

}
