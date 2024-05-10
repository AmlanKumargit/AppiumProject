package org.geekyants.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.ios.IOSDriver;

public class iOSActions {
	IOSDriver ad;
	
	public iOSActions(IOSDriver ad)
	{
		//super(ad);
		this.ad=ad;
	}
	
	public void longPressAction(WebElement e)
	{
		Map<String,Object>params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)e).getId());
		params.put("duration", 5);
		ad.executeScript("mobile:touchAndHold", params);
	}
	
    public void ScrollTillText(WebElement e)
    {
    	Map<String,Object>params = new HashMap<String, Object>();
		params.put("element", ((RemoteWebElement)e).getId());
		params.put("duration", 5);
		params.put("direction","down");
		
		ad.executeScript("mobile:scroll", params);
    }
    
    public void LaunchPhotosApp()
    {
    	Map<String,Object>params = new HashMap<String, Object>();
		params.put("bundleId", "com.apple.mobileslideshow");
		ad.executeScript("mobile:launchApp",params);	
    }
    
   public void SwipePics(List<WebElement> pics)
   {
	    Map<String,Object>params = new HashMap<String, Object>();
		params.put("direction", "left");
	
		ad.executeScript("mobile:swipe",params);
   }

}
