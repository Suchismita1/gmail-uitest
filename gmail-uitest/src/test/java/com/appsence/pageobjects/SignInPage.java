package com.appsence.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.appsence.util.WebUtil;

public class SignInPage {
 
	public void fillUsername(WebDriver driver, String string) {
		WebUtil.clearAndSendkey(driver, By.id("Email"), string);
		/*WebElement username=driver.findElement(By.id("Email"));
		username.clear();
		username.sendKeys(string);*/
	}

	public void clickNext(WebDriver driver) {
		WebUtil.click(driver, By.id("next"));
		/*WebElement nextbutton=driver.findElement(By.id("next"));
		nextbutton.click();*/
				
	}

	public void fillPassword(WebDriver driver, String string) throws Exception {
		WebUtil.waitForElementVisible(driver, By.xpath("//*[@id='Passwd']"));
		WebUtil.clearAndSendkey(driver, By.xpath("//*[@id='Passwd']"), string);
		
		/*WebElement password= driver.findElement(By.xpath("//*[@id='Passwd']"));
		password.clear();
		password.sendKeys(string);*/
		
		WebUtil.click(driver, By.id("PersistentCookie"));
		//driver.findElement(By.id("PersistentCookie")).click();
		
	}

	public EmailHomePage clickSignin(WebDriver driver) {
		WebUtil.click(driver, By.id("signIn"));
		/*WebElement signInbutton=driver.findElement(By.id("signIn"));
		signInbutton.click();*/
		
		WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		*/
		return PageFactory.initElements(driver, EmailHomePage.class);
		
	}

	public boolean isHomePage(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, By.xpath("/html/body/div/div[2]/div[1]/h2"));
		/*WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[1]/h2")));
		*/
		String actual=WebUtil.getElementText(driver,By.xpath("/html/body/div/div[2]/div[1]/h2"));
		//String actual=driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/h2")).getText();
		String expected="Sign in to continue to Gmail";
		if(actual.equalsIgnoreCase(expected))
			return true;
		else
			return false;
		
	}

}
