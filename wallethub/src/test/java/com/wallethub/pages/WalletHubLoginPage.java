package com.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.wallethub.base.TestBase;

public class WalletHubLoginPage extends TestBase {
  
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLabel;
	
	@FindBy(name = "em")
	WebElement emailInput;
	
	@FindBy(name = "pw1")
	WebElement passwordInput;
	
	@FindBy(xpath = "//button//span//span[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "(//span[@class='brgm-list-title'])[5]")
	WebElement userNameLabel;
	
	public WalletHubLoginPage(WebDriver driver) {
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);		// This initElements method will create all WebElements
		
	}
	
    public void walletHubLogin(String userName, String userPassword) {
    	loginLabel.click();
    	waitForElementToBeVisible(emailInput);
        emailInput.sendKeys(userName);
        passwordInput.sendKeys(userPassword);
        loginBtn.click();
        waitForElementToBeVisible(userNameLabel);
        
    }
	
}
