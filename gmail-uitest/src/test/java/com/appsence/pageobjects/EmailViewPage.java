package com.appsence.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailViewPage {

	public String getEmailSubjectText(WebDriver driver) {
		WebElement Subjecttext=driver.findElement(By.cssSelector("h2[class='hp']"));
		return Subjecttext.getText();
	}

}
