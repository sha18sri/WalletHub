package com.wallethub.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver = null;
	protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 20;
	protected static final int WAIT_FOR_ELEMENT_INVISIBLE_IN_SECONDS = 5;
	
	//Set the WebDriver instance
	public void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}
 
	//Get the WebDriver instance
    protected WebDriver getDriver() {
        return driver;
    }
    
    //Launch one of many browsers depending on the parameter passed. 
    public static WebDriver launchBrowser(String browser, String URL) {
		
    	if(browser.equalsIgnoreCase("chrome")) {
    		
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--disable-notifications");		//Disable Chrome notifications
    		
    		//Set Chrome driver path
    		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    		TestBase.driver=new ChromeDriver(options);
    		TestBase.driver.get(URL);
    		TestBase.driver.manage().window().maximize();
    		TestBase.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	}
    	//Can add multiple clauses depending upon the browsers to be launched to run tests.
		/*
		 * else if(browser.equalsIgnoreCase("edge")) {
		 * 
		 * EdgeOptions options = new EdgeOptions(); //Set Chrome driver path
		 * System.setProperty("webdriver.edge.driver", "drivers\\edgedriver.exe");
		 * driver=new EdgeDriver(options); driver.get(URL);
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); }
		 */
    	
    	
    	return driver;
    }

    //Wait for element to be visible
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_PAGE_LOAD_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Wait for element to be invisible
    public void waitForElementToBeInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_ELEMENT_INVISIBLE_IN_SECONDS);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {

        }
    }

    //Get the page source content
    public String getPageSource() {
        return getDriver().getPageSource();
    }

	public void close() {

		driver.quit();
		
	}

}
