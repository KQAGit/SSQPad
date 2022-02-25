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

public class StylePage {

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
				"C:\\Users\\kishan.j\\eclipse-workspace\\AppiumFramwork\\src\\main\\resources\\QPad_Geocollector_v1.2_12012022.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver(url, caps);

		context.setAttribute("WebDriver", driver);

	}

	@Test(priority = 1)
	public void Click() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.id(All.ClickHome)).cldfick();

	}

	@Test(priority = 2)
	public void Allow() throws InterruptedException {
		driver.findElement(MobileBy.id(All.Alw1)).click();;;
		Thread.sleep(2000);
		driver.findElement(MobileBy.id(All.Alw2)).click();

	}

	@Test(priority = 3)
	public void Username() throws InterruptedException {

		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(5000);
		driver.findElement(MobileBy.xpath(All.UsrName)).sendKeys("SGL_PSU178");

		/*
		 * Thread.sleep(3000); driver.findElement(MobileBy.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"
		 * )) .click();
		 */
		driver.findElement(MobileBy.xpath(All.Paaswrd)).sendKeys("sgl_igis");

	}

	@Test(priority = 4)
	public void SignIn() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.SignInBtn)).click();
		Thread.sleep(3000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath(All.CancelBtn)).click();
	}

	@Test(priority = 5)
	public void Home() throws InterruptedException {
		driver.runAppInBackground(Duration.ofSeconds(2));
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

	@Test(priority = 8, description = "")
	public void SettingMenu180() throws InterruptedException

	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.SettingMenu)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.RendarDrpOfSetting)).click();

		Thread.sleep(4000);

		driver.findElement(MobileBy.xpath(All.SimplValueFrmRendarDrp)).click();

		Thread.sleep(4000);

		driver.findElement(MobileBy.xpath(All.TypDrpDwn)).click();

		Thread.sleep(4000);

		driver.findElement(MobileBy.xpath(All.pointValue)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.FillClr)).click();

	}

	@Test(priority = 9)
	public void tapByCoordinates() throws InterruptedException {
		Thread.sleep(1000);

		new TouchAction(driver).tap(PointOption.point(780, 1064)).release().perform();

		Thread.sleep(1000);

		new TouchAction(driver).tap(PointOption.point(912, 664)).release().perform();

		// new TouchAction(driver).tap(point(780, 064));
	}

	@Test(priority = 10)
	public void OkBtn() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(All.OkBtn)).click();
	}

	@Test(priority = 11)
	public void CnclBtn() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(All.FillClr)).click();

		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(All.CnlBtn)).click();
	}

	@Test(priority = 12)
	public void Stock() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(All.StrockBtn)).click();

		Thread.sleep(1000);
		new TouchAction(driver).tap(PointOption.point(214, 1080)).release().perform();

		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(All.StrkOk)).click();

	}

	@Test(priority = 13)
	public void Widhth() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.Width)).clear();

		Thread.sleep(3000);

		new TouchAction(driver).tap(PointOption.point(403, 1251)).release().perform();

		Thread.sleep(3000);

		new TouchAction(driver).tap(PointOption.point(940, 1682)).release().perform();
	}

	@Test(priority = 14)
	public void TextChkBox() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.TextChkBox)).click();
	}

	@Test(priority = 15)
	public void IdDrpdwn() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.IdDrpdwn)).click();
	}

	@Test(priority = 16)
	public void IDValue() throws InterruptedException

	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.IDValue)).click();
	}

	@Test(priority = 17)

	public void SizeDrpDwn() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.SizeDrpDwn)).click();
	}

	@Test(priority = 18)
	public void SizeValue() throws InterruptedException

	{

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.SizeValue)).click();

	}

	@Test(priority = 19)
	public void AlignmentDrpDqn() throws InterruptedException {

		(new TouchAction(driver)).press(new PointOption().withCoordinates(177, 1377))
				.moveTo(new PointOption().withCoordinates(175, 183)).release().perform();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.AlignmentDrpDqn)).click();

	}

	@Test(priority = 20)
	public void AlignmentValue() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.AlignmentValue)).click();
	}

	@Test(priority = 21)
	public void TextClr() throws InterruptedException

	{
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.TextClr)).click();
	}

	@Test(priority = 22)
	public void Section() throws InterruptedException {

		new TouchAction(driver).tap(PointOption.point(915, 1013)).release().perform();

		Thread.sleep(2000);
		new TouchAction(driver).tap(PointOption.point(775, 486)).release().perform();
	}

	@Test(priority = 23)
	public void OkBtn1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.OkBtn)).click();
	}

}
