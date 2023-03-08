package demo.Appium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EcommerceApp extends BaseTest {

	@Test
	public void ecommerceTest() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		scrollAction("India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Abhishek");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
//		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		Assert.assertEquals(toastMessage, "Please enter your name");
		scrollAction("Jordan 6 Rings");
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productCount;i++) {
				String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
					driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
				}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//		String cartName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//		Assert.assertEquals(cartName, "Jordan 6 Rings");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		Set<String> contexts = driver.getContextHandles();
		for(String contextName: contexts) {
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Medtronics");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_App");
	}
}
