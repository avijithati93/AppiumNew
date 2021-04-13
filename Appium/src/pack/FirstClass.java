package pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstClass {
	static AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> androidInitialization() throws IOException
	{
		File appDir = new File("src");
		Properties pr=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\pr.properties");
		pr.load(fis);
	   // File app = new File(appDir, "ApiDemos-debug.apk");
		File app1 = new File(appDir, pr.getProperty("apkFile1"));
		File app = new File(appDir, pr.getProperty("apkFile"));
	    DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "10.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		//cap.setCapability(MobileCapabilityType.UDID, "RZ8N82QP6XM");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("noReset", "false");
		cap.setCapability("autoAcceptAlerts", true);
		//cap.setCapability("fullReset", "true");
		cap.setCapability(MobileCapabilityType.APP, app1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
	
	
}
