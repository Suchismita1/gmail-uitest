package com.appsence.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appsence.pageobjects.SignInPage;

public class WebUtil {

	public static SignInPage gotoSignInPage(WebDriver driver) {
		driver.get("https://gmail.com");
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public static void click(WebDriver driver, By by) {
		WebElement element=driver.findElement(by);
		element.click();
		
	}

	public static void waitForElementVisible(WebDriver driver, By by) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	public static boolean isElementExist(WebDriver driver, By by) {
		return driver.findElements(by).size() > 0;
	}

	public static void clearAndSendkey(WebDriver driver, By by, String string) {
		WebElement element=driver.findElement(by);
		element.clear();
		element.sendKeys(string);
		
	}

	public static String getElementText(WebDriver driver, By by) {
		return driver.findElement(by).getText();
	}

	
}
