package org.geekyants.pageObjects.ios;

import org.geekyants.utils.iOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends iOSActions{
	IOSDriver ad;
	
	public HomePage(IOSDriver ad)
	{
		super(ad);//initializing constructor from iOSActions class
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
	}
	
	//ad.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertviewsbtn;
	
	//ad.findElement(AppiumBy.accessibilityId("Steppers")).click();
	@iOSXCUITFindBy(accessibility="Steppers")
	private WebElement steppersbtn;
	
	//ad.findElement(AppiumBy.accessibilityId("Web View"));
	@iOSXCUITFindBy(accessibility="Web View")
	private WebElement webviewbtn;
	
	public AlertViews selectAlertViews()
	{
		alertviewsbtn.click();
		return new AlertViews(ad);
	}
	
	public Steppers selectSteppers()
	{
		steppersbtn.click();
		return new Steppers(ad);
	}
	
	public PhotosApp scrollTillWebViewandClick()
	{
		ScrollTillText(webviewbtn);
		webviewbtn.click();
		return new PhotosApp(ad);
	}
	
	
	

}
