package android;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidEmulator {

	private AppiumDriver<MobileElement> driver;
	@Before
	public void start() {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//		capabilities.setCapability("appPackage", "com.android.chrome");
//		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		
		try {
			URL appiumHost = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<>(appiumHost, capabilities);
			driver.get("http://saucelabs.com/test/guinea-pig");
			logPass("openApp");
		} catch (Exception e) {
			logReject(e.getMessage());
		}
		
	}
	
	@Test
	public void test() {
		// fail("Not yet implemented");
		//logPass("test");
	}

	private void logPass(String action) {
		System.out.println("[PASS] " + action);
	}
	
	private void logReject(String action) {
		System.out.println("[failed] " + action);
	}
}
