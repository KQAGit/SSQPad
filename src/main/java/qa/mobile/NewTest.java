
package qa.mobile;

import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class NewTest {

	AppiumDriver driver;

	@Test(priority = 1)
	public void Click() {
		driver.findElement(MobileBy.id("com.IGiS.QPadSS:id/imageView2")).click();

	}

	@Test(priority = 2)
	public void Allow() {
		driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

	}

	@Test(priority = 3)
	public void AllowMedia() {
		driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

	}

	@Test(priority = 4)
	public void Username() throws InterruptedException {

		driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(5000);
		// driver.findElement(MobileBy.xpath(
		// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")).click();
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("SGL_PSU156");

	}

	@Test(priority = 5)
	public void Password() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(5000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"))
				.click();
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("sgl_igis");

	}

	@Test(priority = 6)
	public void Unhide() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(5000);
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Show password\"]")).click();

	}

	@Test(priority = 7)
	public void SignIn() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(5000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"))
				.click();

	}

	@Test(priority = 8)
	public void Cancle() throws InterruptedException {

	//	Thread.sleep(4000);
		//driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(8000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[3]")).click();
	}
	
	@Test(priority = 9)
	public void Home() throws InterruptedException {
		Thread.sleep(3000);
	driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open layers list\"]")).click();
			
	
	//Open layers list
}

		/*
		 * // 
		 * //driver.runAppInBackground(Duration.ofSeconds(2)); Thread.sleep(7000);
		 * //driver.runAppInBackground(Duration.ofSeconds(2)); // Thread.sleep(3000);
		 * 
		 * driver.findElement(MobileBy.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"
		 * ))
		 * 
		 * .click(); Thread.sleep(2000); driver.findElement(MobileBy.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"
		 * ))
		 * 
		 * .click();
		 */
	

	@BeforeClass
	public void beforeClass() throws MalformedInputException, Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL API 28");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium-uiautomator5-server-v1.18.0.apk");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("newCommandTimeout", 180000);
	//	caps.setCapability("autoGrantPermissions", "true");
		// caps.setCapability("appPackage","com.swaglabsmobileapp");
		// caps.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
		caps.setCapability("app",
				"C:\\Users\\kishan.j\\eclipse-workspace\\AppiumFramwork\\src\\main\\resources\\SSQPad_18102021_v1.0_rev1.3_QA.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver(url, caps);

	}

	@AfterClass
	public void afterClass() {
	}

}
