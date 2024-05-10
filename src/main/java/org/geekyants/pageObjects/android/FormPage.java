package org.geekyants.pageObjects.android;

import org.geekyants.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver ad;
	
	public FormPage(AndroidDriver ad)
	{
		super(ad);//initializing constructor from AndroidActions class
		this.ad=ad;
		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
	}
	
	//ad.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jane");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//ad.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	//ad.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	private WebElement dropdown;	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		ad.hideKeyboard();
	}
	
	public void setGenderFemale(String gender)
	{
		
		if(gender.contains("Female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void countrySelect(String country)
	{
		dropdown.click();	
		scrollTillText(country);
		ad.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		
	}
	
	public ProductsCatalogue Submit() // creating an object for next page ProdCatalogue for code optimisation. Saves creation of objects for every page on the main @test
	{
		shopButton.click();
		return new ProductsCatalogue(ad);
	}
	
	public void setActivity()
	{
		Activity act = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");//Set to homescreen before every method
		ad.startActivity(act);
	}
	

}
