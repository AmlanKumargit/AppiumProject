package org.geekyants.pageObjects.ios;

import org.geekyants.utils.iOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Steppers extends iOSActions{
IOSDriver ad;
	
	public Steppers(IOSDriver ad)
	{
		super(ad);//initializing constructor from iOSActions class
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
	}
	
	//ad.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][3]"));
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == \"Increment\"`][3]")
	private WebElement customplusbtn;
	
	
	public void customlongpress()
	{
		longPressAction(customplusbtn);
	}
	

}
