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
		//No need to configure system property
		//System.setProperty("webdriver.chrome.drive", "C:\\Suchi_Work\\chromedriver_win32\\chromedriver.exe");
		//ChromeDriverManager.getInstance().setup();
		//WebDriver driver= new ChromeDriver();
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
		//Signout operation
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
		//driver.close();
		
	}
	@AfterTest
	public void teardown()
	{
		//ChromeDriverManager.getInstance().setup();
		driver.close();
	}

}
