package org.geekyants;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.geekyants.TestUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class eCommerce_tc_2 extends AndroidBaseTest{
	
	
		@BeforeMethod(alwaysRun=true)
	    public void PreSetup() 
	    {
//	    	Activity act = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");//Set to homescreen before every method
//			ad.startActivity(act);
			Activity act = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
			ad.startActivity(act);
		
	    }
	
		@Test(groups={"Smoke"})
		public void fillForm_ErrorValidation() throws InterruptedException
		{
			
			ad.findElement(By.id("android:id/checkbox")).click();
//			//ad.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jane");
//			ad.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
//			ad.findElement(By.id("android:id/text1")).click();
//			ad.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
//			ad.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
//			ad.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//			//toast messages cannot be located by appium, so we use android.widget.Toast 
//			String msg = ad.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//			AssertJUnit.assertEquals(msg, "Please enter your name");
//			
//			Thread.sleep(3000);
		}
		@Test(groups={"Smoke"})
		public void fillForm_HappyFlow() throws InterruptedException
		{
			ad.findElement(By.id("android:id/checkbox")).click();
			ad.findElement(By.id("android:id/checkbox")).click();
			DeviceRotation landscape = new DeviceRotation(0,0,90);
			ad.rotate(landscape);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	        ad.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
			String alertTitle = ad.findElement(By.id("android:id/alertTitle")).getText();
			Assert.assertEquals(alertTitle, "WiFi settings");
			
			//copy to_from clipboard
			ad.setClipboardText("Test Wifi");
	        ad.findElement(By.id("android:id/edit")).sendKeys(ad.getClipboardText());
	        ad.findElement(By.id("android:id/button1")).click();
	        
//	        //androiddevicekeys
//	        ad.pressKey(new KeyEvent(AndroidKey.BACK));
//	        ad.pressKey(new KeyEvent(AndroidKey.HOME));
//	        ad.pressKey(new KeyEvent(AndroidKey.ENTER));
//			ad.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jane");
//			ad.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
//			ad.findElement(By.id("android:id/text1")).click();
//			ad.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
//			ad.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
//			ad.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//			//toast messages cannot be located by appium, so we use android.widget.Toast 
//			AssertJUnit.assertTrue(ad.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1); //asserting as size will be zero if there's no toast msg elements
//			
//			
//			Thread.sleep(3000);
		}
	

}
