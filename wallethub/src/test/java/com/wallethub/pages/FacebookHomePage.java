package com.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.wallethub.base.TestBase;

public class FacebookHomePage extends TestBase {
 
    /*
     	All WebElements are identified using WebElement @FindWebElement annotation
    */
	
    @FindBy(xpath = "//textarea[contains(@title,'Write something here...')]")
    private WebElement statusInput;

    @FindBy(xpath = "//button[@data-testid='react-composer-post-button']")
    private WebElement postStatusBtn;
    
    public FacebookHomePage(WebDriver driver) {
    	
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);		// This initElements method will create all WebElements
    	
    }

    public void postNewStatus(String statusMessage) {
        waitForElementToBeVisible(statusInput);
        statusInput.sendKeys(statusMessage);
        waitForElementToBeVisible(postStatusBtn);
        postStatusBtn.click();
        waitForElementToBeVisible(getDriver().findElement(By.xpath("//div/p[contains(text(),'" + statusMessage + "')]")));
    }
}
