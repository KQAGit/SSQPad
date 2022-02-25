package qa.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import Xpaths.All;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import com.aventstack.extentreports.Status;
import ListenerSetup.ExtentTestManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.security.PublicKey;
import java.time.Duration;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Fields_Page {

	AppiumDriver driver;

	@BeforeClass
	public void beforeClass(ITestContext context) throws MalformedInputException, Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 28");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium-uiautomator5-server-v1.18.0.apk");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("newCommandTimeout", 180000);

		caps.setCapability("app",
				"C:\\Users\\kishan.j\\eclipse-workspace\\AppiumFramwork\\src\\main\\resources\\SSQPad_18102021_v1.0_rev1.3_QA.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver(url, caps);

		context.setAttribute("WebDriver", driver);

	}

	@Test(priority = 1)
	public void Click() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.IGiS.QPadSS:id/imageView2")).click();

	}

	@Test(priority = 2)
	public void Allow() throws InterruptedException {
		driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

	}

	@Test(priority = 3)
	public void Username() throws InterruptedException {

		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(5000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("SGL_PSU178");

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"))
				.click();
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("sgl_igis");

	}

	@Test(priority = 4)
	public void SignIn() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"))
				.click();
		Thread.sleep(3000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"))

				.click();
	}

	@Test(priority = 5)
	public void Home() throws InterruptedException {
		driver.runAppInBackground(Duration.ofSeconds(2));
		// Thread.sleep(3000);
		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"))

				.click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open layers list\"]")).click();

	}

	@Test(priority = 6)
	public void Project() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"))
				.click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"))
				.click();

	}

	@Test(priority = 7)
	public void Visiblitiy1() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.IGiS.QPadSS:id/btShow")).click();

	}

	@Test(priority = 8)
	public void SettingMenu180() throws InterruptedException

	{

		/*
		 * Thread.sleep(2000);
		 * driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();
		 */
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.SettingMenu)).click();

	}

	@Test(priority = 9)
	public void RuleValue() throws InterruptedException

	{
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.RendarDrpOfSetting)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.RuleValue)).click();

	}

	/*
	 * @Test(priority = 10) public void DefaultStyl() throws InterruptedException
	 * 
	 * { Thread.sleep(2000);
	 * driver.findElement(MobileBy.xpath(All.DefaultStyl)).click();
	 * 
	 * }
	 */

	@Test(priority = 11)
	public void IdDrpDwnOfRule() throws InterruptedException

	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.IdDrpDwnOfRule)).click();

	}

	@Test(priority = 12)
	public void FixedIdValue() throws InterruptedException

	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.FixedIdValue)).click();

	}

	@Test(priority = 13)
	public void NewBtnOfRule() throws InterruptedException

	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.NewBtnOfRule)).click();

	}

	@Test(priority = 14)
	public void Value7() throws InterruptedException

	{
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.Value7)).click();

	}

	@Test(priority = 15)
	public void OkBtnOfRule() throws InterruptedException

	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.OkBtnOfRule)).click();

	}

	/*
	 * @Test(priority = 9) public void FieldsMenu() throws InterruptedException {
	 * 
	 * Thread.sleep(4000);
	 * driver.findElement(MobileBy.xpath(All.FieldsPage)).click();
	 * 
	 * 
	 * Thread.sleep(2000); driver.runAppInBackground(Duration.ofSeconds(2));
	 * 
	 * }
	 * 
	 * @Test(priority = 10) public void SelectValue() throws InterruptedException
	 * 
	 * { Thread.sleep(2000);
	 * driver.findElement(MobileBy.xpath(All.OpenAreValure)).click();
	 * 
	 * Thread.sleep(3000);
	 * driver.findElement(MobileBy.xpath(All.CancelBtn)).click(); }
	 * 
	 * @Test(priority = 11) public void General() throws InterruptedException
	 * 
	 * {
	 * 
	 * Thread.sleep(4000);
	 * driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();
	 * 
	 * Thread.sleep(3000); driver.findElement(MobileBy.xpath(All.DotMenu)).click();
	 * 
	 * Thread.sleep(2000);
	 * driver.findElement(MobileBy.xpath(All.SettingMenu)).click();
	 * 
	 * Thread.sleep(2000); driver.findElement(MobileBy.id(All.General)).click(); }
	 * 
	 * @Test(priority = 12) public void LocalPath() throws InterruptedException
	 * 
	 * { Thread.sleep(2000);
	 * driver.findElement(MobileBy.xpath(All.Localpath)).click();
	 * 
	 * }
	 * 
	 * @Test(priority = 13) public void LayerName() throws InterruptedException
	 * 
	 * { Thread.sleep(2000); driver.findElement(MobileBy.id(All.LayrName)).clear();
	 * 
	 * Thread.sleep(2000);
	 * driver.findElement(MobileBy.id(All.LayrName)).sendKeys("New Layer");
	 * 
	 * Thread.sleep(2000); driver.hideKeyboard();
	 * 
	 * }
	 * 
	 * @Test(priority = 14) public void ZoomDrag() throws InterruptedException
	 * 
	 * { Thread.sleep(2000); new TouchAction(driver).tap(PointOption.point(837,
	 * 1307)).release().perform(); }
	 * 
	 * @Test(priority = 15) public void DeleteAllFeature() throws
	 * InterruptedException
	 * 
	 * { Thread.sleep(4000);
	 * driver.findElement(MobileBy.xpath(All.DeleteAllFeature)).click(); }
	 * 
	 * @Test(priority = 16) public void CatchMenu() throws InterruptedException
	 * 
	 * {
	 * 
	 * Thread.sleep(2000);
	 * driver.findElement(MobileBy.xpath(All.CancelOfDelete)).click();
	 * 
	 * Thread.sleep(2000); driver.findElement(MobileBy.xpath(All.CachMenu)).click();
	 * 
	 * }
	 * 
	 * @Test(priority = 17) public void RebildCatch() throws InterruptedException
	 * 
	 * { Thread.sleep(3000);
	 * driver.findElement(MobileBy.id(All.RebildCatch)).click();
	 * 
	 * }
	 */
}