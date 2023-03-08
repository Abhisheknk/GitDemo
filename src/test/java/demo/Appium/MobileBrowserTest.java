package demo.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

	@Test
	public void bowserTest() {
//		driver.get("http://google.com");
//		driver.findElement(By.name("q")).sendKeys("Medtronic");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)", "");
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "Devops");
	}
}
