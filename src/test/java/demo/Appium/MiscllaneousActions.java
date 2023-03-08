package demo.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscllaneousActions extends BaseTest {

	@Test
	public void MiscllaneousActionsTest() throws MalformedURLException, InterruptedException {
		
		// adb shell dumpsys window | find "mCurrentFocus" - commands to get app package name and activity name
		//code to directly open the PreferenceDependencies screen without navigation
//		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies}");
//		driver.startActivity(activity);
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.setClipboardText("Abhishek");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
	}

}
