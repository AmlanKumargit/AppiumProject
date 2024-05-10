package org.geekyants.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.geekyants.pageObjects.android.FormPage;
import org.geekyants.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{
	
	public AndroidDriver ad;
	public AppiumDriverLocalService server;
	public FormPage form;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws MalformedURLException { 
		
		AppiumServiceBuilder service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/amlankumar/.nvm/versions/node/v16.13.1/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").withTimeout(Duration.ofSeconds(300)).usingPort(4723);
		server = AppiumDriverLocalService.buildService(service);
		server.start();
				
				//Manual Service Start
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Pixel 7 Android 13");
				options.setChromedriverExecutable("//Users//amlankumar//Downloads//chromedriver-mac-arm64//chromedriver");
				options.setApp("//Users//amlankumar//eclipse-workspace//trainingcourse//src//test//java//resources//app-release (12).apk");
				//options.setApp("//Users//amlankumar//eclipse-workspace//trainingcourse//src//test//java//resources//General-Store.apk");
				ad=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		        ad.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        //form = new FormPage(ad);
	}
	

	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		ad.quit();
		server.stop();
	}

}
