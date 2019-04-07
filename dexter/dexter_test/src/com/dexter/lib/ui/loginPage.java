package com.dexter.lib.ui;


	import java.util.NoSuchElementException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;


	//Step 1
	public class loginPage {
	//Step 2
	WebDriver driver;
	//Step 3
	public loginPage(WebDriver driver)
	{
	//Step 4
		this.driver= driver;
	}
	//Step 5
	public void waitForLoginPageLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("LoginForm"))));
	}
	//Step 6
	public WebElement getUsernameTextbox()
	{
		try
		{
			return driver.findElement(By.name("username"));
		}
		catch (NoSuchElementException e)
		{
			return null;
		}
	}

	public WebElement getPasswordTextbox()
	{
		try
		{
			return driver.findElement(By.name("pwd"));
		}
		catch (NoSuchElementException e)
		{
			return null;
		}
	}

	public WebElement getLoginButton()
	{
		try
		{
			return driver.findElement(By.cssSelector("input[type='submit']"));
		}
		catch (NoSuchElementException e)
		{
			return null;
		}
	}


	public WebElement getLoginEroorMsg()
	{
		try
		{
			return driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again']"));
		}
		catch (NoSuchElementException e)
		{
			return null;
		}
	}

}
