package org.geekyants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.geekyants.TestUtils.AndroidBaseTest;
import org.geekyants.pageObjects.android.CartPage;
import org.geekyants.pageObjects.android.FormPage;
import org.geekyants.pageObjects.android.ProductsCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_5 extends AndroidBaseTest{
	
	//Hybrid - Google page -> switch context for driver for browser level in the next tc.
	
		@Test(dataProvider="getData")
		public void e2e(String name,String gender,String country) throws InterruptedException
		//for multiple inputs use HashMap
		//public void e2e(HashMap<String, String> input) 
		{
			//FormPage form = new FormPage(ad);-- Optimized in BaseClass's @beforeclass annotation.
			
			form.setNameField(name); 
			//for HashMap inputs, form.setNameField(input.get("name")); 
			form.setGenderFemale(gender);
			form.countrySelect(country);
			ProductsCatalogue prodcat = form.Submit();
			
			//ProductsCatalogue prodcat = new ProductsCatalogue(ad); -- This one is handled in Forms page's Submit() function
			prodcat.addItemtoCartByIndex(0);
			prodcat.addItemtoCartByIndex(0);
			CartPage cartPage = prodcat.goToCartPage();
			
			
			
			//check until page loads(title of the page turns to cart)
			WebDriverWait wait = new WebDriverWait(ad, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.attributeContains(ad.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
			
			double total = cartPage.getProductSum();
		    double dispsum = cartPage.totalDisplayedSum();
		    AssertJUnit.assertEquals(total, dispsum);
		    
		    cartPage.acceptTermsConditions();
		    cartPage.checkTheBox();
		    cartPage.SubmitOrder();
		    
//		    Set<String> contexts=ad.getContextHandles();//gets current context handles i.e. AndroidView and WebView
//		    for(String contextName:contexts)
//		    {
//		    	System.out.println(contextName);
//		    }
//		    ad.context("WEBVIEW_com.androidsample.generalstore");//change context to WebView retrieved from contextName and provide path for ChromeDriver on BaseTest
//		    ad.findElement(By.name("q")).sendKeys("Jane");
//			ad.findElement(By.name("q")).sendKeys(Keys.ENTER);
//			ad.pressKey(new KeyEvent(AndroidKey.BACK));
//			ad.context("NATIVE_APP");
//			Thread.sleep(2000);
//			
       }
		
		@BeforeMethod
	    public void preSetup() 
	    {
			form.setActivity();
	    }
		@DataProvider
		public Object[][] getData() throws IOException
		{
			List<HashMap<String, String>> data = getjsonData(System.getProperty("user.dir")+"/src/test/java/org/geekyants/testData/eCommerce.json");
			return new Object[][] { {data.get(0)},{data.get(1)}};  
			//Object is superclass and accepts all int, string, double data types
			//For multiple data types we called setActivity() in PreSetUp before every new session
		}

	
	

}
