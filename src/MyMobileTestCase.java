import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyMobileTestCase {
    DesiredCapabilities cabs = new DesiredCapabilities() ;
    String AppiumUrl = "http://127.0.0.1:4723/wd/hub";
    AndroidDriver driver ; 
    Random rand = new Random ();
	
	@BeforeTest 
	public void MySetup () {
		
		cabs.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cabs.setCapability(MobileCapabilityType.DEVICE_NAME,"bobo");
		File MyApplication = new File("src/MyApps/calculator-8-6-1-625857114.apk");
		cabs.setCapability(MobileCapabilityType.APP, MyApplication.getAbsolutePath());
	}
	
	
	
	
	
	@Test (enabled=false)
	public void AddTwoNumbers() throws MalformedURLException {
		
		
		driver = new AndroidDriver(new URL(AppiumUrl), cabs);
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		String ActualValue = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		String ExpectedValue = "14";
		Assert.assertEquals(ActualValue,ExpectedValue);
		
		}
	@Test (enabled=false)
	public void AddTwoRandomsNumber () throws MalformedURLException {
		driver = new AndroidDriver(new URL(AppiumUrl), cabs);
		List <WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i=0 ; i < AllButtons.size() ; i ++ ) {
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
			AllButtons.get(i).click();
			}
			String ActualResult = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
			String ExpectedResult = "7894561230";
			Assert.assertEquals(ActualResult, ExpectedResult);
		}
	}
	
	@Test (enabled=true)
	public void GetTheEvenNumbers () throws MalformedURLException {
		
		driver = new AndroidDriver (new URL(AppiumUrl),cabs);
		List <WebElement> EvenButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0 ; i <EvenButtons.size() ; i=i+1) {
			if (EvenButtons.get(i).getAttribute("resource-id").contains("2")
					|| EvenButtons.get(i).getAttribute("resource-id").contains("4")
					|| EvenButtons.get(i).getAttribute("resource-id").contains("6") 
					|| EvenButtons.get(i).getAttribute("resource-id").contains("8")
					||EvenButtons.get(i).getAttribute("resource-id").contains("0")) {
				EvenButtons.get(i).click();
			}
		}
		
		
			
		}
	@Test (enabled=false)
	public void GetTheOddNumbers () throws MalformedURLException {
		driver = new AndroidDriver(new URL(AppiumUrl),cabs);
		List <WebElement> OddButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0 ; i < OddButtons.size() ; i=i+1 )
		{
			if (OddButtons.get(i).getAttribute("resource-id").contains("7")
					||OddButtons.get(i).getAttribute("resource-id").contains("5")
					|| OddButtons.get(i).getAttribute("resource-id").contains("3") 
					|| OddButtons.get(i).getAttribute("resource-id").contains("1")); {
						OddButtons.get(i).click();
					}
		}
	}
	
	
	}

	
