package pack;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class TapTest extends FirstClass {
	static AndroidDriver<AndroidElement> driver;

	@Test
	public void assignment3() throws IOException {
		driver = androidInitialization();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		TouchAction t = new TouchAction(driver);
		WebElement tapableElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		t.tap(tapOptions().withElement(element(tapableElement))).perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement longpressElement = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		t.longPress(longPressOptions().withElement(element(longpressElement)).withDuration(ofSeconds(2))).release()
				.perform();
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}
}
