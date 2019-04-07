package com.dexter.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {
public static WebDriver getDriverInstance()
{
	WebDriver driver=null;
	
String browser = DataHandlers.getDataFromProperties("execution_info", "browser").toLowerCase();
String url = DataHandlers.getDataFromProperties("execution_info", "test_url");
if (browser.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
		driver = new ChromeDriver();
			}
	else if (browser.equals("firefox"))
	{
System.setProperty("webdriver.gecko.driver", "./browser-servers/geckodriver.exe");
driver = new FirefoxDriver();
	}
	if (browser.equals("ie"))
	{
System.setProperty("webdriver.ie.driver", "./browser-servers/iedriver.exe");
driver = new InternetExplorerDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	return driver;
}
}
