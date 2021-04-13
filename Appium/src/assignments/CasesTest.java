package assignments;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.FirstClass;

public class CasesTest extends FirstClass {
	static AndroidDriver<AndroidElement> driver;

	@Test
	public void assignment1() throws IOException {
		driver = androidInitialization();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement agreements=driver.findElement(By.xpath("//android.widget.TextView[@text='I ACCEPT THE TERMS']"));
		wait.until(ExpectedConditions.elementToBeClickable(agreements));
		agreements.click();
		WebElement anonymuslogin=driver.findElement(By.xpath("//android.widget.Button[@text='ANONYMOUS LOGIN']"));
		wait.until(ExpectedConditions.elementToBeClickable(anonymuslogin));
		anonymuslogin.click();
		WebElement dropdownIndia=driver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownIndia));
		dropdownIndia.click();
		WebElement dropdownSelect=driver.findElement(By.xpath("//*[@text='SELECT']"));
		dropdownSelect.click();
		WebElement action=driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		action.click();
		//WebElement hamburgerOption=driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']"));
		//wait.until(ExpectedConditions.elementToBeClickable(hamburgerOption));
		//hamburgerOption.click();
		//driver.switchTo().frame(driver.findElement(By.id("/dataLayout")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@resource-id='com.alifesoftware.stocktrainer:id/dataLayout']")));
		//WebElement emailAc=driver.findElement(By.xpath("//android.widget.TextView[@index='1' and @package='com.alifesoftware.stocktrainer']"));
		//alert.accept();
		//System.out.println("Email Id  "+emailAc.getText());
		//TouchAction touchAction=new TouchAction(driver);
		//touchAction.tap(tapOptions);
		//WebElement MyAccount=driver.findElement(By.xpath("//android.widget.TextView[@text='My Account']"));
		//MyAccount.click();
		TouchAction t = new TouchAction(driver);
		WebElement hamburgerOption=driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']"));
		t.tap(tapOptions().withElement(element(hamburgerOption))).perform();
}
}