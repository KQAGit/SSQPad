package qa.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import Xpaths.All;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

public class One {

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
	public void Click() {
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
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("SGL_PSU178");

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"))
				.click();
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("sgl_igis");

	}

	@Test(priority = 4)
	public void SignIn() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"))
				.click();
		Thread.sleep(8000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(6000);

		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"))

				.click();
	}

	@Test(priority = 5)
	public void Home() throws InterruptedException {
		driver.runAppInBackground(Duration.ofSeconds(2));
		// Thread.sleep(3000);
		Thread.sleep(4000);

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
	public void EDITMENU() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.EditFrmMenu)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.PlsBtnOfEditMenu)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.MapCenterBtn)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.UserCntrBtn)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.UndoArw)).click();
		
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.RedoArw)).click();

		

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.TopCrsBtnOfEditMenu)).click();
		
		
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.DltBtnOfEditMenu)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.BotmCrsBtnOfEditMenu)).click();

	}

	@Test(priority = 9)
	public void Edit168() throws InterruptedException

	{

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.EditFrmMenu)).click();

	}

	@Test(priority = 10)
	public void SettingMenu175() throws InterruptedException

	{

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.BotmCrsBtnOfEditMenu)).click();

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.SettingMenu)).click();

	}

	@Test(priority = 11)
	public void Report() throws InterruptedException

	{
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.BackBtnOfSettingMenu)).click();

		Thread.sleep(8000);
		driver.findElement(MobileBy.xpath(All.CanclePopUp)).click();

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.ReportMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.ShareBtnOfReport)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.BackFrmReport)).click();

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(All.CanclePopUp)).click();

	}

	@Test(priority = 12)
	public void Help176() throws InterruptedException

	{

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.EditFrmMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.HelpBtn)).click();

	}

}
