package org.geekyants;

import org.geekyants.TestUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AndroidAssesment extends AndroidBaseTest{
	
	
	
	@Test
	public void Login() throws InterruptedException
	{
		ad.findElement(By.xpath("//android.widget.TextView[@text='Sign Up']")).click(); //SignUp
		
		ad.findElement(By.xpath("(//android.widget.EditText[@text='Enter'])[1]")).sendKeys("Amlan Kumar"); //Name
		ad.findElement(By.xpath("//android.widget.EditText[@index=4]")).sendKeys("amlank@geekyants.com"); //Email
		
		ad.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")).click();
		ad.findElement(By.xpath("(//android.widget.TextView[@text=\"Sign Up\"])[2]")).click(); //SignUp
		Thread.sleep(500);
		
	}
	
	

}
