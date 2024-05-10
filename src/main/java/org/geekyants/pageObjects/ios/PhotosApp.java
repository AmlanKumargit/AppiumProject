package org.geekyants.pageObjects.ios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geekyants.utils.iOSActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PhotosApp extends iOSActions{
	IOSDriver ad;
	
	public PhotosApp(IOSDriver ad)
	{
		super(ad);//initializing constructor from iOSActions class
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
	}
	
	//ad.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
	private List<WebElement> pics; 	//total photos stored in a list 
	
	//ad.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[1]")
	private WebElement firstpic;
	
	public void SwipeThroughAllPics()
	{
		System.out.println("LIST SIZE = "+pics.size());
		firstpic.click();
		for(int i=0;i<pics.size();i++)
		{
			SwipePics(pics);
		}
		ad.navigate().back();
	}
	

}
