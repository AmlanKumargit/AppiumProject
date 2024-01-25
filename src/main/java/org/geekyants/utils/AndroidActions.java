package org.geekyants.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
	AndroidDriver ad;
	
	public AndroidActions(AndroidDriver ad)
	{
		//super(ad);
		this.ad=ad;
	}
	
	
	public void longPressAction(WebElement e)
	{
		((JavascriptExecutor) ad).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) e).getId(), "duration", 2000));
	}
	public void scrollTillText(String text)
	{
		ad.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	public void swipeImages(WebElement e, String dir)
	{
	
		((JavascriptExecutor) ad).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) e).getId(), "duration", 2000,
			    "direction", dir,
			    "percent", 0.75));
	}
	public void dragndrop(WebElement e)
	{
		((JavascriptExecutor) ad).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) e).getId(),
			    "endX", 620,
			    "endY", 555
			));
	}

}
