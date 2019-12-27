package com.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.wallethub.base.TestBase;

public class FacebookPage extends TestBase {
 
    /*
     	All WebElements are identified using WebElement @FindWebElement annotation
    */
	
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "loginbutton")
    private WebElement loginBtn;
    
    
    public FacebookPage(WebDriver driver) {
    	
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);		// This initElements method will create all WebElements
    	
    }

    public void facebookLogin(String userName, String userPassword) {
        emailInput.sendKeys(userName);
        passwordInput.sendKeys(userPassword);
        loginBtn.click();
    }
    

}
