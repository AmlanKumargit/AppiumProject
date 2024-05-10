package org.geekyants.pageObjects.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews {
IOSDriver ad;
	
	public AlertViews(IOSDriver ad)
	{
		//super(ad);//initializing constructor from iOSActions class
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
	}

	//ad.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[5]")
	private WebElement textentrybtn;
	
	//ad.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[5]")).sendKeys("Testing iOS");
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[5]")
	private WebElement textbox;
	
	//ad.findElement(AppiumBy.accessibilityId("OK")).click();
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement okbtn;
	
	//ad.findElement(By.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\'UIKitCatalog\']")
	private WebElement backbtn;
	
	public void textEntryAction(String text)
	{
		textentrybtn.click();
		textbox.sendKeys(text);
	}
	
	public void Accept()
	{
		okbtn.click();
	}
	public void BacktoHome()
	{
		backbtn.click();
	}
	
}
