package com.appsence.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage {
 
	public void fillUsername(WebDriver driver, String string) {
		WebElement username=driver.findElement(By.id("Email"));
		username.clear();
		username.sendKeys(string);
	}

	public void clickNext(WebDriver driver) {
		WebElement nextbutton=driver.findElement(By.id("next"));
		nextbutton.click();
				
	}

	public void fillPassword(WebDriver driver, String string) throws Exception {
		Thread.sleep(1000);
		WebElement password= driver.findElement(By.xpath("//*[@id='Passwd']"));
		password.clear();
		password.sendKeys(string);
		driver.findElement(By.id("PersistentCookie")).click();
		
	}

	public EmailHomePage clickSignin(WebDriver driver) {
		WebElement signInbutton=driver.findElement(By.id("signIn"));
		signInbutton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		
		return PageFactory.initElements(driver, EmailHomePage.class);
		
	}

	public boolean isHomePage(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[1]/h2")));
		String actual=driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/h2")).getText();
		String expected="Sign in to continue to Gmail";
		if(actual.equalsIgnoreCase(expected))
			return true;
		else
			return false;
		
	}

}
