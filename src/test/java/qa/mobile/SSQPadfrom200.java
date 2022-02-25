package qa.mobile;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ListenerSetup.ExtentTestManager;
import Xpaths.All;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import okhttp3.internal.http2.Settings;

public class SSQPadfrom200 {
	AppiumDriver driver;

	@BeforeMethod
	public void testSetup(ITestContext context) throws InterruptedException, Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium-uiautomator2-server-v1.18.0.apk");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability("avd", "Emulator4");
		caps.setCapability("avdLaunchTimeout", 180000);
		caps.setCapability(MobileCapabilityType.NO_RESET, "true");
		caps.setCapability(MobileCapabilityType.FULL_RESET, "FALSE");
		// caps.setCapability("autoGrantPermissions", true);
		String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "SSQPad_18102021_v1.0_rev1.3_QA.apk";
		caps.setCapability(MobileCapabilityType.APP, appUrl);
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, caps);
		System.out.println("session id:" + driver.getSessionId());

		context.setAttribute("WebDriver", driver);

	}

	@Test(priority = 1, description = "To verify that user is able to explore \"Floating Action (+) \" button.")
	public void ssqpad203() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Verify 'Identify' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.feditbywalk)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Verify 'Edit By walk' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fedit)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Verify 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.faccuratelocationpoint)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Verify 'Set Attribute' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fmeasure)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Verify 'Measurement' button.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : <br/>User should get following options,<br/> 1. Identify <br/> 2. Edit by walk <br/> 3. Edit <br/> 4. Set attributes <br/> 5. Measurements ");
	}

	@Test(priority = 2, description = "To verify that user is able to collapse \"Floating Action (+) \" button.")
	public void ssqpad204() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Verify 'float' menu is expanded.");

		driver.findElement(By.xpath(All.floatclose)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on 'Collapse float' button.");

		Thread.sleep(1500);

		try {
			driver.findElement(By.xpath(All.fedit)).isDisplayed();
		}

		catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Result</b> : Floating actions icons should get collapsed..");
		}

	}

	@Test(priority = 3, description = "To verify that user is able to perform \"Identify\" functionality.")
	public void ssqpad205() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		// add one survey data
		driver.findElement(By.xpath(All.hamburgermenu)).click();
		Thread.sleep(1500);
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on 'Hamburger menu'.");
		driver.findElement(By.xpath(All.expandproject)).click();
		Thread.sleep(500);
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Start assigned Project.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.startprojectyes)).click();
		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.Layervisibilityicon)).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.layermoreoption)).click();
		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.Layeredit)).click();
		Thread.sleep(1500);
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on \"More option\" -> Edit.");
		driver.runAppInBackground(Duration.ofSeconds(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.addnewgeometrypoint)).click();
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(1500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.camerapermissionallow)).click();
		Thread.sleep(2000);

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.savesurveydata)).click();
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Tap on 'Apply' icon from 'Set attributes' form.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.actionmodeclose)).click();
		Thread.sleep(1000);

		// now identify by coordinates
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fidentify)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Identify' button.");

		Thread.sleep(1000);
		touchAction.tap(new PointOption().withCoordinates(535, 945)).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		Assert.assertEquals(driver.findElement(By.xpath(All.surveydataformtitle)).isDisplayed(), true);
		Thread.sleep(500);
//		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-</b> : Verify Attribute form is opened.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get attribute form open for selected layer.");

	}

	@Test(priority = 4, description = "To verify that user is able to close \"Identify\" functionality.")
	public void ssqpad206() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fidentify)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Identify' button.");

		Thread.sleep(1000);
		touchAction.tap(new PointOption().withCoordinates(535, 945)).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		Assert.assertEquals(driver.findElement(By.xpath(All.surveydataformtitle)).isDisplayed(), true);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Verify Attribute form is opened.");

		driver.findElement(By.xpath(All.surveydataformclosebutton)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on (X) close icon from viewed attribute form.");

		driver.findElement(By.xpath(All.fidentifyclose)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Tap on (X) close icon from \"Tap feature for info\" bottom panel.");
		Thread.sleep(1000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		try {
			driver.findElement(By.xpath(All.identifyactivated)).isDisplayed();
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO, "<b>Result</b> : Identify functionality should get closed.");

		}
	}

	@Test(priority = 5, description = "To verify that user is able to open \"Edit\" mode.")
	public void ssqpad207() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).isDisplayed();
		Thread.sleep(500);
		driver.findElement(By.xpath(All.editmodedeletefeature)).isDisplayed();
		Thread.sleep(500);
		driver.findElement(By.xpath(All.editmodeeditfeature)).isDisplayed();
		Thread.sleep(500);
		driver.findElement(By.xpath(All.editmodeidentifyfeature)).isDisplayed();
		Thread.sleep(500);
		driver.findElement(By.xpath(All.editmodeclosebutton)).isDisplayed();
		Thread.sleep(500);

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get \"Edit\" mode open for selected layer.");
	}

	@Test(priority = 6, description = "To verify that user is able to close \"Edit\" mode.")
	public void ssqpad209() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).isDisplayed();
		Thread.sleep(500);

		driver.findElement(By.xpath(All.editmodeclosebutton)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Cancel\" (X) icon from \"Bottom Panel\".");

		try {
			driver.findElement(By.xpath(All.editmodeclosebutton)).isDisplayed();
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Result</b> : \"Edit\" mode should get closed from map page.");
		}

	}

	@Test(priority = 7, description = "To verify that user is able to perform \"Add new Geometry\"\" functionality.")
	public void ssqpad210() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");

		Assert.assertEquals(driver.findElement(By.xpath(All.saveaddedgeometry)).isDisplayed(), true);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view feature added on map.");
	}

	@Test(priority = 8, description = "To verify that user is able to get point at \"Centre\" of base map.")
	public void ssqpad211() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(250, 1400))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(250, 1450)).release().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.pointtodisplaycentre)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Point to display centre\" icon from \"Action\" mode bottom panel.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : Added feature on map should get located to centre of current view of map.");
	}

	@Test(priority = 9, description = "To verify that user is able to get point at \"Current location\" of surveyor user on base map.")
	public void ssqpad212() throws InterruptedException {

		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(795, 1215))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(795, 1000)).release().perform();
		Thread.sleep(1500);

		driver.findElement(By.xpath(All.pointtocurrentlocation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Point to current location\" icon from \"Action\" mode bottom panel.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : Added feature on map should get located to current location of user.");
	}

	@Test(priority = 10, description = "To verify that user is able to perform \"Undo\" for geometry location on base map.")
	public void ssqpad213() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(535, 945))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(535, 1000)).release().perform();
		Thread.sleep(1500);

		driver.findElement(By.xpath(All.pointundo)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"UNDO\" icon from \"Action\" mode top panel.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : Added feature should get to it's previous location.");

	}

	@Test(priority = 11, description = "To verify that user is able to perform \"Redo\" for geometry location on base map.")
	public void ssqpad214() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(535, 945))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(535, 1000)).release().perform();
		Thread.sleep(1500);

		driver.findElement(By.xpath(All.pointundo)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(All.pointredo)).click();
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"REDO\" icon from \"Action\" mode top panel.");

		ExtentTestManager.getTest().log(Status.INFO, "<b>Result</b> : Added feature should get to it's next location.");

	}

	@Test(priority = 12, description = "To verify that user gets \"Accuracy warning\" dialog open for adding geometry 50 meter far from current location.")
	public void ssqpad215() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(535, 945))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(476, 890)).release().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		Thread.sleep(1500);

		Assert.assertEquals(driver.findElement(By.xpath(All.accuracywarntext1)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(All.accuracywarntext2)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(All.accuracywarncancel)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(All.accuracywarncontinue)).isDisplayed(), true);
		Thread.sleep(1000);

		Assert.assertEquals(driver.findElement(By.xpath(All.accuracywarntext1)).getText(), "Accuracy warning");
		Thread.sleep(500);
		Assert.assertEquals(driver.findElement(By.xpath(All.accuracywarntext2)).getText(),
				"You are more than 50 meter far from your marked pin, Are you sure you want to continue?");
		Thread.sleep(500);

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get \"Accuracy warning\" with 'Cancel' and 'CONTINUE' buttons.");

	}

	@Test(priority = 13, description = "To verify that geometry is not saved by tapping on \"Cancel\" button from \"Accuracy warning\" dialog box.")
	public void ssqpad216() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(535, 945))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(476, 890)).release().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		Thread.sleep(1500);

		driver.findElement(By.xpath(All.accuracywarncancel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on \"Cancel\" option from \"Accuracy warning\" dialog box.");

		driver.findElement(By.xpath(All.pointtocurrentlocation)).isDisplayed();
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO,
				"<bResult</b> : User should get back to \"Action\" mode for added feature.");

	}

	@Test(priority = 14, description = "To verify that geometry saved by tapping on \"Continue\" button from \"Accuracy warning\" dialog box.")
	public void ssqpad217() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		driver.findElement(By.xpath(All.savesurveydata)).isDisplayed();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view \"Set attributes\" form for added feature.");

	}

	@Test(priority = 15, description = "To verify that \"Set attributes\" form opened by tapping on \"Save\" button from \"Edit Geometry\" mode.")
	public void ssqpad218() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		driver.findElement(By.xpath(All.formcolonytextbox)).isDisplayed();
		Thread.sleep(1000);

		driver.findElement(By.xpath(All.savesurveydata)).isDisplayed();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view \"Set attributes\" form for added feature.");
	}

	@Test(priority = 16, description = "To verify that user is able get options by tapping on \"Photo\" symbol from \"Set attributes\" form.")
	public void ssqpad219() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath(All.Fcapturenewvideo)).isDisplayed(), true);
		Thread.sleep(500);
		Assert.assertEquals(driver.findElement(By.xpath(All.Fpickphotofromgallery)).isDisplayed(), true);
		Thread.sleep(500);
		Assert.assertEquals(driver.findElement(By.xpath(All.Ftakenewphoto)).isDisplayed(), true);
		Thread.sleep(500);

		Thread.sleep(1000);

		Assert.assertEquals(driver.findElement(By.xpath(All.Fcapturenewvideo)).getText(), "Capture new Video");
		Thread.sleep(500);
		Assert.assertEquals(driver.findElement(By.xpath(All.Fpickphotofromgallery)).getText(),
				"Pick Photo from Gallery");
		Thread.sleep(500);
		Assert.assertEquals(driver.findElement(By.xpath(All.Ftakenewphoto)).getText(), "Take new photo");
		Thread.sleep(500);

	}

	@Test(priority = 17, description = "To verify that user is able to take new photo for \"Set attributes\" form.")
	public void ssqpad220() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath(All.takephotothumbnail)).isDisplayed(), true);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view captured photo in thumbnail form at \"Photo\" field of \"Set attributes\" form.");

	}

	@Test(priority = 18, description = "To verify that user is able to Capture new video for \"Set attributes\" form.")
	public void ssqpad222() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		try {
			driver.findElement(By.xpath(All.camerapermissionallow)).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Camera permission is given.");
		}

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Fcapturenewvideo)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Capture new video' option.");
//	driver.runAppInBackground(Duration.ofSeconds(2));
//	Thread.sleep(2000);
		driver.findElement(By.xpath(All.capturevideo)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture Video' button.");
		Thread.sleep(25000);
		driver.findElement(By.xpath(All.Donecapturedvideo)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Tap on \"confirm\" symbol from captured video.");

		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath(All.addedvideothumbnail)).isDisplayed(), true);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view captured video in thumbnail form at \"Photo\" field of \"Set attributes\" form.");

	}

	@Test(priority = 19, description = "To verify that user is able to cancel captured video.")
	public void ssqpad223() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		try {
			driver.findElement(By.xpath(All.camerapermissionallow)).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Camera permission is given.");
		}

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Fcapturenewvideo)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Capture new video' option.");
//	driver.runAppInBackground(Duration.ofSeconds(2));
//	Thread.sleep(2000);
		driver.findElement(By.xpath(All.capturevideo)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture Video' button.");
		Thread.sleep(25000);
		driver.findElement(By.xpath(All.Cancelcapturedvideo)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Tap on \"confirm\" symbol from captured video.");

		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath(All.formphoto)).isDisplayed(), true);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result</b> : Survey data form should get open.");

	}

	@Test(priority = 20, description = "To verify that user gets \"20 Seconds\" timer by staring capturing video.")
	public void ssqpad224() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Fcapturenewvideo)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Capture new video' option.");
//	driver.runAppInBackground(Duration.ofSeconds(2));
//	Thread.sleep(2000);
		driver.findElement(By.xpath(All.capturevideo)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture Video' button.");
		Thread.sleep(1500);
		Assert.assertEquals(driver.findElement(By.xpath(All.videotimer)).isDisplayed(), true);
		Thread.sleep(1000);

//	Thread.sleep(25000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view \"20 seconds\" timer at top of camera section.");

	}

	@Test(priority = 21, description = "To verify that user is able to detach, selected media file from \"Set attributes\" form.")
	public void ssqpad225() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath(All.takephotothumbnail)).isDisplayed(), true);
		Thread.sleep(500);
		driver.findElement(By.xpath(All.removeattachedvideo)).click();
		Thread.sleep(1000);
		try {
			Assert.assertEquals(driver.findElement(By.xpath(All.takephotothumbnail)).isDisplayed(), true);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Result</b> : Cancelled attachment should get removed from \"Set attributes\" form.");
		}
	}

	@Test(priority = 22, description = "To verify that user gets toast message for \"Maximum attachment\" reached.")
	public void ssqpad226() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		Thread.sleep(300);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		// Add more 4 Attachments
		driver.findElement(By.xpath(All.formphoto)).click();
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		Thread.sleep(300);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.formphoto)).click();
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		Thread.sleep(300);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.formphoto)).click();
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		Thread.sleep(300);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.formphoto)).click();
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		Thread.sleep(1000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		Thread.sleep(300);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Attach more 4 photo at \"Photo\" field.");

		// Now validation message will pop up.
		driver.findElement(By.xpath(All.formphoto)).click();
		Thread.sleep(300);

		try {
			driver.findElement(By.xpath(All.capture)).isDisplayed();
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Result</b> : User should get toast message of \"Maximum attachment is 5\".");
		}

	}

	@Test(priority = 23, description = "To verify that user gets validation message for saving attributes form without media attachments.")
	public void ssqpad227() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.fidentify)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");

		driver.findElement(By.xpath(All.savesurveydata)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on 'Apply' icon from 'Set attributes' form.");

		// Toast message verification remains.
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message of \"Image/ Video Attachment is Mandatory\".");

	}

	@Test(priority = 24, description = "To verify that user gets validation message of \"Data saved and synced successfully.\"")
	public void ssqpad228() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);

		Thread.sleep(1500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");
		Thread.sleep(2000);

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.savesurveydata)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Tap on 'Apply' icon from 'Set attributes' form.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message of \"Data saved & Synced Successfully\".");

	}

	@Test(priority = 25, description = "To verify that user gets warning message for tap on back button from \"Save attributes\" form.")
	public void ssqpad229() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);

		Thread.sleep(1500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.back1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on (<-) \"Back\" icon from \"Set attributes\" form.");

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);

		Assert.assertEquals(driver.findElement(By.xpath(All.savevalidationtext1)).isDisplayed(), true);
		Thread.sleep(300);
		Assert.assertEquals(driver.findElement(By.xpath(All.savevalidationtext2)).isDisplayed(), true);
		Thread.sleep(300);

		Assert.assertEquals(driver.findElement(By.xpath(All.savevalidationtext1)).getText(), "Save");
		Assert.assertEquals(driver.findElement(By.xpath(All.savevalidationtext2)).getText(),
				"There are unsaved edits. Do you want to save them?");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message of \"There are unsaved edits. Do you want to save them?\" with \"Discard\" and \"Save\" options.");

	}

	@Test(priority = 26, description = "To verify that user redirects to \"Edit\" mode for current geometry by tapping on \"Discard\" button from \"Save\" validation message.")
	public void ssqpad230() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);

		Thread.sleep(1500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.back1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on (<-) \"Back\" icon from \"Set attributes\" form.");

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);

		driver.findElement(By.xpath(All.savevalidationdiscard)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Tap on \"Discard\" option from Save validation message.");

		driver.findElement(By.xpath(All.saveaddedgeometry)).isDisplayed();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get back to the \"Action\" mode for current feature.");

	}

	@Test(priority = 27, description = "To verify that feature saved by tapping on \"Save\" button from \"Save\" warning dialog.")
	public void ssqpad231() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		driver.findElement(By.xpath(All.editmodeaddnew)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on \"Add geometry\" (+) icon from bottom panel.");
		Thread.sleep(2000);

		Thread.sleep(1500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.saveaddedgeometry)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-5</b> : Tap on \"Save\" icon from top panel of \"Action\" mode.");
		Thread.sleep(2000);

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.back1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Tap on (<-) \"Back\" icon from \"Set attributes\" form.");

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.savevalidationsave)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Tap on \"Save\" option from Save validation message.");

		Thread.sleep(1000);
		driver.findElement(By.xpath(All.addnewgeometrypoint)).isDisplayed();

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message of \"Data saved & Synced Successfully\".");
	}

	@Test(priority = 28, description = "To verify that user is able to view \"Action\" mode for available feature on map.")
	public void ssqpad232() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).isDisplayed(), true);
		driver.findElement(By.xpath(All.editmodeeditfeature)).click();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Edit\" icon from bottom panel.");
		driver.findElement(By.xpath(All.pointtocurrentlocation)).isDisplayed();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view \"Action\" mode open for selected feature from map.");
	}

	@Test(priority = 29, description = "To verify that user is able to close \"Action\" mode.")
	public void ssqpad233() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).isDisplayed(), true);
		driver.findElement(By.xpath(All.editmodeeditfeature)).click();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Edit\" icon from bottom panel.");

		driver.findElement(By.xpath(All.actionmodecloseX)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on (X) \"Close\" icon from top panel of Action mode.");

		driver.findElement(By.xpath(All.editmodeaddnew)).isDisplayed();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to close \"Action\" mode for selected feature.");

	}

	@Test(priority = 30, description = "To verify that user is able to \"Delete\" selected feature from map by \"Action\" mode.")
	public void ssqpad234() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodedeletefeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Delete\" icon from bottom panel.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get snack bar with \"Item deleted\" message and \"UNDO\" button.");
	}

	@Test(priority = 31, description = "To verify that user is able to view attributes page by \"Attributes\" from Action mode.")
	public void ssqpad235() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodeidentifyfeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Attributes\" icon from bottom panel.");
		Assert.assertEquals(driver.findElement(By.xpath(All.surveydataformtitle)).isDisplayed(), true);
		Thread.sleep(500);

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view attributes data for selected feature.");

	}

	@Test(priority = 32, description = "To verify that user is able to get back to the \"Action\" mode from Attributes page.")
	public void ssqpad236() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodeidentifyfeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Attributes\" icon from bottom panel.");
		Assert.assertEquals(driver.findElement(By.xpath(All.surveydataformtitle)).isDisplayed(), true);
		Thread.sleep(500);
		driver.findElement(By.xpath(All.surveydataformclosebutton)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on (X) close icon from viewed attribute form.");

		driver.findElement(By.xpath(All.editmodeaddnew)).isDisplayed();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result</b> : User should get redirect to \"Edit\" mode.");

	}

	@Test(priority = 33, description = "To verify that user is able to edit \"Attributes form\".")
	public void ssqpad237() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodeidentifyfeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Attributes\" icon from bottom panel.");
		Assert.assertEquals(driver.findElement(By.xpath(All.surveydataformtitle)).isDisplayed(), true);
		driver.findElement(By.xpath(All.surveydataeditattributes)).click();
		Thread.sleep(1000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.formcolonytextbox)).isDisplayed();
		// driver.findElement(By.xpath(survey.formcolonytextbox)).sendKeys("updated");
		// Thread.sleep(1000);
		// driver.findElement(By.xpath(survey.savesurveydata)).click();
		// Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get \"Set attributes\" page open for selected feature.");
	}

	@Test(priority = 34, description = "To verify that user is able to view attributes page for more than one features from common layer.")
	public void ssqpad238() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodeidentifyfeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Attributes\" icon from bottom panel.");

		String s1 = driver.findElement(By.xpath(All.attributepageIDtext)).getText();
		System.out.println(s1);

		Thread.sleep(700);
		driver.findElement(By.xpath(All.surveydatapageprev)).click();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Tap on \"Next\" icon from bottom panel of viewed attribute form.");

		String s2 = driver.findElement(By.xpath(All.attributepageIDtext)).getText();
		System.out.println(s2);

		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view attributes data for next feature from layer.");

	}

	@Test(priority = 35, description = "To verify that user gets \"Setting\" page open from  attributes page.")
	public void ssqpad239() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodeidentifyfeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Attributes\" icon from bottom panel.");

		driver.findElement(By.xpath(All.moreoptionbtn)).click();
		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.attributepageSetting)).click();
		Thread.sleep(500);

		Assert.assertEquals(driver.findElement(By.xpath(All.General)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.General)).getText(), "General");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Verify 'Setting - General' button.");
		Thread.sleep(500);

		Assert.assertEquals(driver.findElement(By.xpath(All.Map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.Map)).getText(), "Map");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Verify 'Setting - Map' button.");
		Thread.sleep(500);

		Assert.assertEquals(driver.findElement(By.xpath(All.Location)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.Location)).getText(), "Location");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Verify 'Setting - Location' button.");
		Thread.sleep(500);

		Assert.assertEquals(driver.findElement(By.xpath(All.Mytracks)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.Mytracks)).getText(), "My tracks");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Verify 'Setting - My tracks' button.");
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : <br/>User should get \"Setting\" section open with following setting options, <br/>1. General Setting, <br/>2. Map Setting, <br/>3. Location Setting, <br/>4. My tracks Setting.");

	}

	@Test(priority = 36, description = "To verify that user gets \"Help\" section open from  attributes page.")
	public void ssqpad240() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.fedit)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on 'Edit' button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.editmodetitlepanelText)).getText(), "Nothing is selected");

		Thread.sleep(500);
		touchAction.tap(new PointOption().withCoordinates(540, 948)).perform();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on available feature on map.");

		driver.findElement(By.xpath(All.editmodeidentifyfeature)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on \"Attributes\" icon from bottom panel.");

		driver.findElement(By.xpath(All.moreoptionbtn)).click();
		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.attributepagehelp)).click();
		Thread.sleep(500);

		Assert.assertEquals(driver.findElement(By.xpath(All.helptitle)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.helptitle)).getText(), "Help");
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Verify Help section title.");

		Assert.assertEquals(driver.findElement(By.xpath(All.helpsupportbutton)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.helpsupportbutton)).getText(), "SUPPORT");
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Verify 'Support' - tap to view sub section button.");

		Assert.assertEquals(driver.findElement(By.xpath(All.helpaboutsectionbutton)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(All.helpaboutsectionbutton)).getText(), "ABOUT");
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Verify 'About' - tap to view sub section button.");

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Verify IGiS Qpad link.");

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : <br/>User should get Help section open with followings, <br/>1. Help section title, <br/>2. Support sub-section, <br/>3. About sub-section, <br/>4. IGiS Qpad link.");

	}

	@Test(priority = 37, description = "To verify that user is able to set attributes for current location.")
	public void ssqpad241() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.faccuratelocationpoint)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on \"Set attributes\" icon.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.savesurveydata)).click();
		Thread.sleep(300);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Tap on \"Apply\" icon from top panel of \"Set attributes\" form.");

		driver.findElement(By.xpath(All.editmodeaddnew)).isDisplayed();
		Thread.sleep(200);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message of \"Data saved & synced successfully.\".");

	}

	@Test(priority = 38, description = "To verify that user is able to set attributes for current location with Accurate location.")
	public void ssqpad242() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Tap on 'float' button.");

		driver.findElement(By.xpath(All.faccuratelocationpoint)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Tap on \"Set attributes\" icon.");

		driver.findElement(By.xpath(All.LAaccuratelocationbutton)).click();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on \"Accuracy location\" checkbox.");

		driver.findElement(By.xpath(All.accuratelocationdialogtext1)).isDisplayed();
		driver.findElement(By.xpath(All.accuratelocationdialogtext2)).isDisplayed();
		Thread.sleep(200);

		Assert.assertEquals(driver.findElement(By.xpath(All.accuratelocationdialogtext1)).getText(),
				"Accurate location");
		Assert.assertEquals(driver.findElement(By.xpath(All.accuratelocationdialogtext2)).getText(),
				"Accumulating and averaging location…");

		driver.findElement(By.xpath(All.accuratelocationdialogprogressbar)).isDisplayed();
		driver.findElement(By.xpath(All.accuratelocationdialogcancel)).isDisplayed();

		Thread.sleep(20000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Verify that \"Accuracy location\" dialog box.");

		TouchAction swipe = new TouchAction(driver).press(PointOption.point(500, 1500))
				// .waitAction(waitOptions(ofMillis(800)))
				.moveTo(PointOption.point(500, 300)).release().perform();

		Thread.sleep(500);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(1500);
		driver.findElement(By.xpath(All.formphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Tap on Camera icon from \"Photo\" field.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.Ftakenewphoto)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Tap on 'Take new photo' option.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.capture)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Tap on 'Capture' button.");
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(All.savesurveydata)).click();
		Thread.sleep(300);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Tap on \"Apply\" icon from top panel of \"Set attributes\" form.");

		driver.findElement(By.xpath(All.editmodeaddnew)).isDisplayed();
		Thread.sleep(200);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message of \"Data saved & synced successfully.\".");
	}

	@Test(priority = 39, description = "To verify that user is able to measure length and area on map.")
	public void ssqpad243() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);

		driver.findElement(By.xpath(All.fmeasure)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Tap on 'Floating Action (+) -> Measure'  button from home page.");
		touchAction.tap(new PointOption().withCoordinates(80, 1400)).perform();
		Thread.sleep(1000);
		touchAction.tap(new PointOption().withCoordinates(80, 500)).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Tap on two location on map screen to get distance between them.");
		// touchAction.tap(new PointOption().withCoordinates(600, 600)).perform();
		Thread.sleep(1000);
		// System.out.println(driver.findElement(By.xpath(qpadrepo.measurementonlylengthtext)).getText());
		Assert.assertEquals(driver.findElement(By.xpath(All.measurementonlylengthtext)).getText(), "984.004 m");
		Thread.sleep(2000);

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result - 1</b> : User should be able to view distance between two points in \"km\" at top panel.");

		touchAction.tap(new PointOption().withCoordinates(600, 600)).perform();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Tap on third location on map screen to get distance between selected polygon area.");
		System.out.println(driver.findElement(By.xpath(All.measurementonlylengthtext)).getText());
		Assert.assertEquals(driver.findElement(By.xpath(All.measurementonlylengthtext)).isDisplayed(), true);

		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result - 2</b> :  User should be able to view area in (m square) unit within drawn polygon at top panel.");

	}

	@Test(priority = 40, description = "To verify that user is able to close measure functionality.")
	public void ssqpad244() throws InterruptedException {
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Start SSQPad application.");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(346, 1080)).perform();
		Thread.sleep(5000);
		driver.runAppInBackground(Duration.ofSeconds(2));
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.floatbtn)).click();
		Thread.sleep(1500);

		driver.findElement(By.xpath(All.fmeasure)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Tap on 'Floating Action (+) -> Measure'  button from home page.");
		touchAction.tap(new PointOption().withCoordinates(80, 1400)).perform();
		Thread.sleep(1000);
		touchAction.tap(new PointOption().withCoordinates(80, 500)).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Tap on two location on map screen to get distance between them.");
		// touchAction.tap(new PointOption().withCoordinates(600, 600)).perform();
		Thread.sleep(1000);
		// System.out.println(driver.findElement(By.xpath(qpadrepo.measurementonlylengthtext)).getText());
		Assert.assertEquals(driver.findElement(By.xpath(All.measurementonlylengthtext)).getText(), "984.004 m");
		Thread.sleep(2000);

		driver.findElement(By.xpath(All.measurementclose)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Tap on \"Done\" floating button.");
		driver.findElement(By.xpath(All.floatclose)).isDisplayed();
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should be able to view that Measure functionality is closed.");

	}

}
