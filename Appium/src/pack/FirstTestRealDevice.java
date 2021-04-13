package pack;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.FindsByAndroidUIAutomator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstTestRealDevice extends FirstClass {
	static AndroidDriver<AndroidElement> driver;

	@Test
	public void assignment1() throws IOException {
		driver = androidInitialization();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Avijit");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
	}
}
