package com.suchi.gmail_uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appsence.pageobjects.EmailHomePage;
import com.appsence.pageobjects.SignInPage;
import com.appsence.util.WebUtil;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class GmailSigninTest {
	 
	//ChomeDriverManager.getInstance().setup();
	public WebDriver driver;
	@BeforeClass
	public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }
	@BeforeTest
	 public void setupTest() {
		ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
	@Test
	public void gmailloginshouldbesuccessful() throws Exception
	{
		// Goto Gmail item
		SignInPage signInPage= WebUtil.gotoSignInPage(driver);
		
		// Find username textbox and enter detail
		signInPage.fillUsername(driver,"suchismita.ghadei@gmail.com");
		
		// Click on next button
		signInPage.clickNext(driver);
	
		// entering password
		signInPage.fillPassword(driver,"mastermind");
		
		//Clicking on signin button
		EmailHomePage emailHomepage = signInPage.clickSignin(driver);
		
		//verifying successful login by finding inbox link
		Assert.assertTrue(emailHomepage.isInboxExist(driver), "Successfully logged in");
	
		//Signout operation
		signInPage = emailHomepage.signout(driver);
		
		// Verify that signout is successful
		Assert.assertTrue(signInPage.isHomePage(driver), "Successfully Logged out");
		//driver.close();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
