package com.appsence.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailHomePage {

	public SignInPage signout(WebDriver driver) {
		WebElement signoutimage=driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span"));
		signoutimage.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		WebElement signout=driver.findElement(By.linkText("Sign out"));
		signout.click();
		
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public boolean isInboxExist(WebDriver driver) {
		return driver.findElements(By.partialLinkText("Inbox")).size()> 0;
			
	}
}
