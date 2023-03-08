package demo.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SwipeGesture extends BaseTest {

	@Test
	public void SwipeGestureTest() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//where to scroll is known prior
//		scrollAction();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
		swipeGestureAction(firstImage, "left");
		
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
	}

}
