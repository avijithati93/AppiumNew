package assignments;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import pack.FirstClass;

public class NewTest extends FirstClass {
	static AndroidDriver<AndroidElement> driver;

	@Test
	public void assignment1() throws IOException {
		driver = androidInitialization();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement agreements=driver.findElement(By.xpath("//android.widget.TextView[@text='I ACCEPT THE TERMS']"));
		wait.until(ExpectedConditions.elementToBeClickable(agreements));
		agreements.click();
		WebElement registration=driver.findElement(By.xpath("//android.widget.TextView[@text='New to Stock Trainer? Register Here']"));
		registration.click();
		WebElement password=driver.findElement(By.xpath("//android.widget.EditText[@text='Confirm Password']"));
		password.sendKeys("Test@12345");
		WebElement exchangeCountry=driver.findElement(By.className("android.widget.LinearLayout"));
		wait.until(ExpectedConditions.elementToBeClickable(exchangeCountry));
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(exchangeCountry))).perform();
		//TouchActions t1=new TouchActions(driver);
		
		//WebElement exchangeCountrySelect=driver.findElement(By.xpath("//android.widget.TextView[@text()='Canada']"));
		//driver.findElementByAndroidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(text(\"India\"));");
		//wait.until(ExpectedConditions.elementToBeClickable(exchangeCountrySelect));
		//t.tap(tapOptions().withElement(element(exchangeCountrySelect))).perform();
		//exchangeCountrySelect.click();
		
		driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                        + "India" + "\").instance(0))").click();
	}
}
