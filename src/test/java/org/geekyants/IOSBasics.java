package org.geekyants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geekyants.TestUtils.iOSBaseTest;
import org.geekyants.pageObjects.ios.AlertViews;
import org.geekyants.pageObjects.ios.PhotosApp;
import org.geekyants.pageObjects.ios.Steppers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends iOSBaseTest{
	
	@Test
	public void IOSBasicsTest()
	{
		AlertViews alertviews = home.selectAlertViews();
		
		alertviews.textEntryAction("Testing iOS");
		alertviews.Accept();
		alertviews.BacktoHome();		
		
		
		Steppers steppers = home.selectSteppers();
		
		//LongPress
		steppers.customlongpress();
		
	
		alertviews.BacktoHome();
		//Scroll
		PhotosApp photos = home.scrollTillWebViewandClick();

		
		
		//open IOS default apps like photos using app's bundle id. Use google to find bundle id of iOS apps.
		photos.LaunchPhotosApp();
		

		//swipe through images
		photos.SwipeThroughAllPics();
		
	}

}
