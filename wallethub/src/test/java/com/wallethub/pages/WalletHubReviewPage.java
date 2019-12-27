package com.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.wallethub.base.TestBase;
import com.wallethub.tests.TestWalletHubPage;

public class WalletHubReviewPage extends TestBase{
  
	@FindBy(xpath = "//a[contains(@href,'reviews')]//span[2][text()='Reviews']")
	WebElement reviewsTab;
	
	@FindBy(xpath = "(//div[contains(@class,'review-action')]//review-star//div//*[@class='rvs-star-svg'][4]//*)[2]")
	WebElement fourthStar;
	
	@FindBy(xpath = "//div[contains(@class,'review-action')]//review-star//div//*[@class='rvs-star-svg'][4]//*[@stroke='#4ae0e1']")
	WebElement fourthStarLit;
	
	@FindBy(xpath = "//span[@class='dropdown-placeholder' and text()='Select...']")
	WebElement dropdown;
	
	@FindBy(xpath = "//textarea[@placeholder='Write your review...']")
	WebElement reviewInput;
	
	@FindBy(xpath = "//div[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div//h4[text()='Your review has been posted.']")
	WebElement postSuccessMsg;
	
	@FindBy(xpath = "(//span[@class='brgm-list-title'])[5]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "(//a[text()='Test Insurance Company'])[1]")
	WebElement latestReviewLink;
	
	@FindBy(xpath = "(//div[@itemprop='description'])[1]")
	WebElement reviewContent;
	
	String reviewURL = "http://wallethub.com/profile/test_insurance_company/";
	String profileURL = "https://wallethub.com/profile/";
	
	public WalletHubReviewPage(WebDriver driver) {
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);		// This initElements method will create all WebElements
		
	}
	
    public void postNewReview(String reviewText) throws InterruptedException {
    	String user = TestWalletHubPage.userName.substring(0, TestWalletHubPage.userName.indexOf("@"));
    	
    	driver.navigate().to(reviewURL);
        waitForElementToBeVisible(reviewsTab);
        reviewsTab.click();
        
        waitForElementToBeVisible(fourthStar);
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.moveToElement(fourthStar).perform();
        Thread.sleep(3000);
        waitForElementToBeVisible(fourthStarLit);
        fourthStar.click();
        waitForElementToBeVisible(dropdown);
        dropdown.click();
        
        driver.findElement(By.xpath("//div[contains(@class,'dropdown second')]//ul[contains"
        		+ "(@class,'dropdown-list')]//li[text()='Health Insurance']")).click();
        
        waitForElementToBeVisible(reviewInput);
        reviewInput.click();
        reviewInput.sendKeys(reviewText);
        
        waitForElementToBeVisible(submitBtn);
        submitBtn.click();
        waitForElementToBeVisible(postSuccessMsg);
        
        waitForElementToBeVisible(userNameLabel);

        driver.navigate().to(profileURL+user);
        
        waitForElementToBeVisible(latestReviewLink);
        latestReviewLink.click();
        
        waitForElementToBeVisible(driver.findElement(By.xpath("//span[text()='" + user +"']")));
        waitForElementToBeVisible(reviewContent);
        
        Assert.assertEquals(reviewContent.getText(), reviewText);
        
    }
}
