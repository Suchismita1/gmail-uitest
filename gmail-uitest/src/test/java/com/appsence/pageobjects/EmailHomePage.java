package com.appsence.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appsence.util.WebUtil;

public class EmailHomePage {

	public SignInPage signout(WebDriver driver) {
		WebUtil.click(driver,By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")); 
		
		WebUtil.waitForElementVisible(driver,By.linkText("Sign out"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));*/
		WebUtil.click(driver, By.linkText("Sign out"));
		/*WebElement signout=driver.findElement(By.linkText("Sign out"));
		signout.click();*/
		
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public boolean isInboxExist(WebDriver driver) {
		return WebUtil.isElementExist(driver,By.partialLinkText("Inbox"));
		//return driver.findElements(By.partialLinkText("Inbox")).size()> 0;
			
	}

	public void clickComposeButton(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, By.id(":j3"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":j3")));*/
		WebUtil.click(driver, By.xpath("//*[@id=':j3']/div/div"));
		/*WebElement composebutton=driver.findElement(By.xpath("//*[@id=':j3']/div/div"));
		composebutton.click();*/
		
	}

	public void fillRecipient(WebDriver driver,String string) {
		WebUtil.waitForElementVisible(driver,By.cssSelector("textarea[aria-label='To']"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[aria-label='To']")));*/
		
		WebUtil.clearAndSendkey(driver,By.cssSelector("textarea[aria-label='To']"),string);
		/*WebElement toTextbar=driver.findElement(By.cssSelector("textarea[aria-label='To']"));
		toTextbar.sendKeys(string);*/
		
	}

	public void fillSubject(WebDriver driver,String string) {
		WebUtil.clearAndSendkey(driver, By.cssSelector("input[placeholder='Subject']"), string);
		/*WebElement Subjectbar=driver.findElement(By.cssSelector("input[placeholder='Subject']"));
		Subjectbar.sendKeys(string);*/
		
	}

	public void fillMailbody(WebDriver driver, String string) {
		WebUtil.clearAndSendkey(driver, By.cssSelector("div[aria-label='Message Body']"), string);
		/*WebElement Subjectbox=driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
		Subjectbox.sendKeys(string);*/
		
	}

	public void clickSend(WebDriver driver) {
		WebUtil.click(driver,By.cssSelector("div[role='button'][aria-label='Send ‪(Ctrl-Enter)‬']"));
		/*WebElement SendKey=driver.findElement(By.cssSelector("div[role='button'][aria-label='Send ‪(Ctrl-Enter)‬']"));
		SendKey.click();*/
	}

	public void clickInbox(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));
		WebUtil.click(driver, By.partialLinkText("Inbox"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		driver.findElement(By.partialLinkText("Inbox")).click();*/
		
	}

	public EmailViewPage clickMail(WebDriver driver) throws Exception {
		WebUtil.waitForElementVisible(driver, By.cssSelector("div[class='y6'] span[id] b"));
		WebUtil.click(driver, By.cssSelector("div[class='y6'] span[id] b"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
		WebElement newEmail=driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
		newEmail.click();*/
		Thread.sleep(1000);
		
		return PageFactory.initElements(driver, EmailViewPage.class);
		
	}
}
