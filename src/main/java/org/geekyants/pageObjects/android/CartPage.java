package org.geekyants.pageObjects.android;

import java.util.List;

import org.geekyants.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	
	AndroidDriver ad;
	
	public CartPage(AndroidDriver ad)
	{
		super(ad);//initializing constructor from AndroidActions class
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
	}
	
	//ad.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	//By.id("com.androidsample.generalstore:id/totalAmountLbl")
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	//By.id("com.androidsample.generalstore:id/termsButton"
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
			
	//By.id("android:id/button1")
	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptbtn;
	
	//AppiumBy.className("android.widget.CheckBox")
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkbox;
	
	//By.id("com.androidsample.generalstore:id/btnProceed")
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceedbtn;
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductSum()
	{
		int count = productList.size();
		double total = 0;		
		for(int i=0;i<count;i++)
		{
		   String amount=productList.get(i).getText();
		   //remove dollar and parse the string into double
		   Double price = Double.parseDouble(amount.substring(1));
		   total=total+price;
		}
		return total;
	}
	
	public Double totalDisplayedSum()
	{
		String total = totalAmount.getText();
		return getFormattedAmount(total);
	}
//	public Double getFormattedAmount(String amount)
//	{
//		Double price = Double.parseDouble(amount.substring(1));
//		return price;
//	} ----- code pushed to AppiumUtils(codes both common for Android/iOS pushed to a parent Util class AppiumUtils)
	
	public void acceptTermsConditions()
	{
		longPressAction(terms);
		acceptbtn.click();
	}
	public void checkTheBox()
	{
		checkbox.click();
	}
	
	public void SubmitOrder() throws InterruptedException
	{
		proceedbtn.click();
		Thread.sleep(3000);
	}
	
	
}
