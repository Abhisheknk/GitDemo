package demo.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
			//code to start server
			service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ka19//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
			service.start();	
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Test");
			options.setChromedriverExecutable("C://Tools//Appium//chromedriver_win32//chromedriver.exe");
//			options.setApp("C://Users//ka19//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
			options.setApp("C://Users//ka19//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement elementValue) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)elementValue).getId(), 
					"duration", 2000));
	}
	
	public void scrollAction(String visibleText) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+visibleText+"\"));"));
		Thread.sleep(2000);
	}
	
	public void scrollToEndAction() {
		//when there is no prior idea 
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
		}while(canScrollMore);
	}
	
	public void swipeGestureAction(WebElement element, String drirection) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
	}
	
	public void DragDropGestureAction(WebElement element, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", 595,
			    "endY", 527
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
		//stop server
		service.stop();
	}
}
