package com.appsence.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.appsence.pageobjects.SignInPage;

public class WebUtil {

	public static SignInPage gotoSignInPage(WebDriver driver) {
		driver.get("https://gmail.com");
		return PageFactory.initElements(driver, SignInPage.class);
	}

}
