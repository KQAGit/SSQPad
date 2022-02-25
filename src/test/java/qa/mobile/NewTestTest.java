
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

public class NewTestTest {

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
	public void Allow() {
		driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

	}

	@Test(priority = 3)
	public void AllowMedia() {
		driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();

	}

	@Test(priority = 4)
	public void Username() throws InterruptedException {

		driver.runAppInBackground(Duration.ofSeconds(2));

		Thread.sleep(3000);
		// driver.findElement(MobileBy.xpath(
		// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")).click();
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"))
				.sendKeys("SGL_PSU208");

	}

	@Test(priority = 5)
	public void Password() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Show password\"]")).click();

	}

	@Test(priority = 7)
	public void SignIn() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"))
				.click();
		Thread.sleep(8000);

	}

	@Test(priority = 8)
	public void Cancle() throws InterruptedException {
		// driver.runAppInBackground(Duration.ofSeconds(4));
		// driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(3000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(5000);

		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"))

				.click();

	}

	@Test(priority = 9)
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

	@Test(priority = 10)
	public void Project() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton"))
				.click();

	}

	@Test(priority = 11)
	public void YesProject() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"))
				.click();

	}

	@Test(priority = 12)
	public void ViSiblitiy() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.ImageButton[1]"))
				.click();

	}

	@Test(priority = 13)
	public void MenuOption() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.ImageButton[2]"))
				.click();

	}

	@Test(priority = 14)
	public void ZoomToExtent() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))
				.click();

	}

	@Test(priority = 15)

	public void ZoomBoundray() throws InterruptedException {

		// Burger Menu
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open layers list\"]")).click();
		// Dot Menu
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.ImageButton[2]"))
				.click();

		// Zoom Boundray
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout"))
				.click();

	}

	@Test(priority = 16)

	public void FeaturesTable() throws InterruptedException {

		// Burger Menu
		Thread.sleep(4000);
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open layers list\"]")).click();

		// Dot Menu
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.ImageButton[2]"))
				.click();
		// Features Table
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))
				.click();
	}

	@Test(priority = 17)
	public void RejectDataOnly() throws InterruptedException {
		// Backfromfeaturetable
		Thread.sleep(8000);

		driver.findElement(MobileBy.xpath(All.BackbtnFeatureTable)).click();

		// cancle pop on homescreen
		Thread.sleep(2000);

		driver.findElement(MobileBy.xpath(All.CanclePopUp))

				.click();

		// BurgerMenu
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

		// Dot Menu
		Thread.sleep(2000);

		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		// rejectcheckbox
		Thread.sleep(2000);

		driver.findElement(MobileBy.xpath(All.RejectDataCheckBox)).click();

	}

	@Test(priority = 18)
	public void QueryBilder() throws InterruptedException {

		// Burger Menu Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();
		// Dot Menu
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.DotMenu)).click();
		// Features Table
		Thread.sleep(3000);
		driver.findElement(By.xpath(All.FeaturTable)).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(All.featureicon)).click();

		// driver.findElement(By.xpath(All.applybtn)).click();

	}

	@Test(priority = 19)

	public void CloseQueryPopup() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.ClosebtnOfQuery)).click();
	}

	@Test(priority = 20)

	public void DeleteFeauterData() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(All.RawSltOfFeatureTabl)).click();

		Thread.sleep(4000);
		driver.findElement(By.id(All.DltBtnOfFeatureTbl)).click();

		Thread.sleep(4000);
		driver.findElement(By.id(All.NoBtnOfPup)).click();

		driver.runAppInBackground(Duration.ofSeconds(2));

		Thread.sleep(5000);
		driver.findElement(By.xpath(All.RawSltOfFeatureTabl)).click();

		Thread.sleep(5000);
		driver.findElement(By.id(All.EditBtnOfFeatureTbl)).click();

		Thread.sleep(4000);
		driver.findElement(By.id(All.AlwOfEdit)).click();

		driver.runAppInBackground(Duration.ofSeconds(2));

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.CanBtnOfEdit)).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath(All.YesBtnOfEditFrm)).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath(All.CrossBtnOfFeatureTbl)).click();

		// Thread.sleep(8000);
		// driver.findElement(By.id(All.SaveBtnOfEditForm)).click();

	}

	@Test(priority = 21)

	public void FieldDropDown() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.featureicon)).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(All.FieldDropDownOfQueryBuilder)).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.CityValueFrmFielddrp)).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.OperationDropDownOfQueryBuilder)).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.EqualsValueFrmOpeationdrp)).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.ValueTextBoxOfBueryBuilder)).sendKeys("KishanQA");

		Thread.sleep(2000);
		driver.hideKeyboard();

		Thread.sleep(4000);
		driver.findElement(By.xpath(All.ApplybtnOfBuilder)).click();

	}

	@Test(priority = 22)

	public void ShareFrmMenu() throws InterruptedException

	{
		
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BackbtnFeatureTable)).click();

		// cancle pop on homescreen
		
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.CanclePopUp)).click();

				

		// BurgerMenu

		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

		// Dot Menu
		Thread.sleep(2000);

		driver.findElement(MobileBy.xpath(All.DotMenu)).click();

		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath(All.ShareBtn)).click();

		driver.runAppInBackground(Duration.ofSeconds(2));

		
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath(All.CanclePopUp)).click();

				

	}
	
	
	@Test(priority = 23)

	public void EditFrmMenu() throws InterruptedException
	{
	Thread.sleep(3000);
	driver.findElement(MobileBy.xpath(All.BurgerMenu)).click();

	// Dot Menu
	Thread.sleep(2000);
	driver.findElement(MobileBy.xpath(All.DotMenu)).click();
	
	Thread.sleep(2000);
	driver.findElement(MobileBy.xpath(All.EditFrmMenu)).click();
	
	
	
	}
	
	
	
}
