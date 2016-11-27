package com.suchi.gmail_uitest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appsence.pageobjects.EmailHomePage;
import com.appsence.pageobjects.EmailViewPage;
import com.appsence.pageobjects.SignInPage;
import com.appsence.util.WebUtil;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class GmailSendRecieveMailTest {
	public WebDriver driver;
	@BeforeClass
	public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }
	@BeforeTest
	 public void setupTest() {
		ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	@Test
	public void gmailsendreceivetest() throws Exception
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
		
		//Start Composing the mail 
		emailHomepage.clickComposeButton(driver);
		
		//Fill the recipient 
		emailHomepage.fillRecipient(driver,"suchismita.ghadei@gmail.com");
		
		//Fill the Subject
		final String subject="Test Gmail by selenium";
		emailHomepage.fillSubject(driver,subject);
		
		//Fill the mailbody
		emailHomepage.fillMailbody(driver,"Hello Testing");
		
		//Click Send button
		emailHomepage.clickSend(driver);
		Thread.sleep(5000);
		
		//Verify the received email
		//Click Inbox button
		emailHomepage.clickInbox(driver);
		//driver.findElement(By.cssSelector("div[aria-label='Refresh'][role='button']")).click();
		//Thread.sleep(3000);
		
		//Click the new mail
		EmailViewPage emailViewPage = emailHomepage.clickMail(driver);
		
		//String actualsubject = emailViewPage.getEmailSubjectText(driver);
		//Assert.assertEquals(subject, actualsubject);
		//Signout operation
		signInPage = emailHomepage.signout(driver);
				
		// Verify that signout is successful
		Assert.assertTrue(signInPage.isHomePage(driver), "Successfully Logged out");
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
