package org.geekyants.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Parent class for codes common for both Android and iOS. Both AndroidUtils and iOSUtils extend this class

public class AppiumUtils {
	
//	AppiumDriver ad;
//	
//	public AppiumUtils(AppiumDriver ad) {
//		
//		this.ad=ad;
//		PageFactory.initElements(new AppiumFieldDecorator(ad), this);
//		// TODO Auto-generated constructor stub
//	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	} 
	
	public List<HashMap<String, String>> getjsonData(String jsonFilePath) throws IOException
	{
		
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);// Parse Json file-> Json String (Commons-io)
	    
		ObjectMapper mapper = new ObjectMapper(); // object to map json string to hashmap
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});//read all the json content and convert it into a list of hashmaps.
		return data;
	}
    public void waitForElementtoAppear(WebElement ele, AppiumDriver ad)
    {
    	WebDriverWait wait = new WebDriverWait(ad, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }
    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
    {
    	File source = driver.getScreenshotAs(OutputType.FILE);
    	String destinationFile = "/Users/amlankumar/eclipse-workspace/AppiumFrameworkDesign/screenshot_"+testCaseName+".png";
    	FileUtils.copyFile(source, new File(destinationFile));
    	return destinationFile;
    }

}
