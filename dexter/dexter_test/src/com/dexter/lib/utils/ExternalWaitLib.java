package com.dexter.lib.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExternalWaitLib {
	public static void waitForAlertPopup(WebDriver driver)
	
	{
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.alertIsPresent());
	}
public static void waitForTitleContatins(WebDriver driver, String title)
		{
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.titleContains(title));
	}
public static void waitForELEMENT(WebDriver driver, WebElement element)

{
WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOf(element));
}
public static void waitForTitle(WebDriver driver, String title)
{
WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.titleIs(title));
}
}
