package com.wallethub.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wallethub.base.TestBase;
import com.wallethub.pages.WalletHubLoginPage;
import com.wallethub.pages.WalletHubReviewPage;

public class TestWalletHubPage extends TestBase {
  
	public WebDriver driver;
	public WalletHubLoginPage walletHubLoginPage;
	public WalletHubReviewPage walletHubReviewPage;
	
	public static String userName = "";
	public static String userPassword = "";
	
	private String reviewText = "A paragraph is a self-contained unit of a discourse "
			+ "in writing dealing with a particular point or idea. A paragraph consists "
			+ "of one or more sentences. Though not required by the syntax of any language, "
			+ "paragraphs are usually an expected part of formal writing, used to organize "
			+ "longer prose.";
	
	  @BeforeClass
	  @Parameters({"browser", "URL"})
	  public void setup(String browser, String URL) {
		  
		  this.driver = launchBrowser(browser, URL);		  
		  
	  }
	
	  @Test
	  public void loginTest() {
		  
		  this.walletHubLoginPage = new WalletHubLoginPage(driver);
		  walletHubLoginPage.walletHubLogin(userName, userPassword);
		
	  }	  
	  
	  @Test(dependsOnMethods = "loginTest")
	  public void postStatusTest() throws InterruptedException {
		  
		  this.walletHubReviewPage = new WalletHubReviewPage(driver);
		  walletHubReviewPage.postNewReview(reviewText);
		  
	  }	  
	  
	  @AfterClass
	  public void teardown() {
		  close();
	  }
	
	
}
