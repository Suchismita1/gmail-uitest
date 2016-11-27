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
		driver.get("https://gmail.com");
		// Find username textbox and enter detail
		WebElement username=driver.findElement(By.id("Email"));
		username.clear();
		username.sendKeys("suchismita.ghadei@gmail.com");
		// Click on next button
		WebElement nextbutton=driver.findElement(By.id("next"));
		nextbutton.click();
		// entering password
		Thread.sleep(1000);
		WebElement password= driver.findElement(By.xpath("//*[@id='Passwd']"));
		password.clear();
		password.sendKeys("mastermind");
		driver.findElement(By.id("PersistentCookie")).click();
		//Clicking on signin button
		WebElement signInbutton=driver.findElement(By.id("signIn"));
		signInbutton.click();
		//verifying successful login by finding inbox link
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		Assert.assertTrue(driver.findElements(By.partialLinkText("Inbox")).size()> 0 , "Successfully logged in");
		
		//Start Composing the mail & send
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":j3")));
		WebElement composebutton=driver.findElement(By.xpath("//*[@id=':j3']/div/div"));
		composebutton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[aria-label='To']")));
		WebElement toTextbar=driver.findElement(By.cssSelector("textarea[aria-label='To']"));
		toTextbar.sendKeys("suchismita.ghadei@gmail.com");
		
		WebElement Subjectbar=driver.findElement(By.cssSelector("input[placeholder='Subject']"));
		String subject="Test Gmail by selenium";
		Subjectbar.sendKeys(subject);
		
		WebElement Subjectbox=driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
		Subjectbox.sendKeys("Hello Testing");
		
		WebElement SendKey=driver.findElement(By.cssSelector("div[role='button'][aria-label='Send ‪(Ctrl-Enter)‬']"));
		SendKey.click();
		
		Thread.sleep(5000);
		
		//Verify the received email
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		driver.findElement(By.partialLinkText("Inbox")).click();
		
		//driver.findElement(By.cssSelector("div[aria-label='Refresh'][role='button']")).click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
		WebElement newEmail=driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
		newEmail.click();
		Thread.sleep(1000);
		/*WebElement backButton=driver.findElement(By.cssSelector("div[role-'button'][aria-label='Back to Inbox']"));
		backButton.click();
		System.out.println(driver.findElement(By.cssSelector("div[class='y6']span[id]")).getText());
		*/
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='hp']")));
		/*WebElement Subjecttext=driver.findElement(By.cssSelector("h2[class='hp']"));
		String Actualsubject=Subjecttext.getText();
		Assert.assertEquals(Actualsubject,subject);*/
		
		//Goto to signout location
				WebElement signoutimage=driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span"));
				signoutimage.click();
				//Clicking on signout button
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
				WebElement signout=driver.findElement(By.linkText("Sign out"));
				signout.click();
				// Verify that signout is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[1]/h2")));
				String actual=driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/h2")).getText();
				String expected="Sign in to continue to Gmail";
				Assert.assertEquals(actual , expected );
		
	}
	@AfterTest
	public void teardown()
	{
		//ChromeDriverManager.getInstance().setup();
		driver.close();
	}
}
