package org.geekyants.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.geekyants.pageObjects.ios.HomePage;
import org.geekyants.utils.AppiumUtils;
import org.geekyants.utils.iOSActions;
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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTest extends AppiumUtils{
	
	public IOSDriver ad;
	public AppiumDriverLocalService server;
	public HomePage home;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		AppiumServiceBuilder service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/amlankumar/.nvm/versions/node/v16.13.1/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").withTimeout(Duration.ofSeconds(300)).usingPort(4723);
		server = AppiumDriverLocalService.buildService(service);
		server.start();
				
				//Manual Service Start
				XCUITestOptions options = new XCUITestOptions();
				options.setDeviceName("iPhone 15 Pro");

				options.setApp("//Users//amlankumar//eclipse-workspace//trainingcourse//src//test//java//resources//UIKitCatalog.app");
				//options.setApp("//Users//amlankumar//eclipse-workspace//trainingcourse//src//test//java//resources//TestApp 3.app");
				options.setPlatformVersion("17.2");
				options.setWdaLaunchTimeout(Duration.ofSeconds(20));
				
				ad=new IOSDriver(new URL("http://127.0.0.1:4723"), options);
				ad.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				home = new HomePage(ad);
		        
	}
	
	
	@AfterClass
	public void tearDown()
	{
		ad.quit();
		server.stop();
	}

}
