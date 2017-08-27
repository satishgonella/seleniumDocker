package com.javacodegeeks.seleniumexample.SeleniumGridDocker;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;


public class SeleniumGridDocker {
		WebDriver driver;
	
	@BeforeTest
	  public void Driver() throws MalformedURLException {
		 
		String Browser ="Firefox";
		  
			if (Browser.equals("Firefox")){

				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setBrowserName("firefox");
				capabilities.setPlatform(Platform.LINUX);
				driver = new RemoteWebDriver(new URL("http://192.168.99.1:4444/wd/hub"), capabilities);
				driver.get("http://the-internet.herokuapp.com/login");
			}
			else if (Browser.equals("Chrome")){

				DesiredCapabilities dcap = DesiredCapabilities.chrome();
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dcap);
			}	  
	  }
	@Test
	  public void doThese(){
		  driver.get("http://www.google.com");
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	  }
	}

