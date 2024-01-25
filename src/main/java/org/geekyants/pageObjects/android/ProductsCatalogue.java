package org.geekyants.pageObjects.android;

import java.util.List;

import org.geekyants.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsCatalogue extends AndroidActions{
	
	AndroidDriver ad;

	public ProductsCatalogue(AndroidDriver ad) {
		super(ad);
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
		// TODO Auto-generated constructor stub
	}
	
	//ad.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> addTocart; // as findElements finds a list of elements
	
	//ad.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;
	
	public void addItemtoCartByIndex(int index)
	{
		addTocart.get(index).click();
	}
	public CartPage goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		return new CartPage(ad); //CartPage object creation handled here.
	}
	
	

}
