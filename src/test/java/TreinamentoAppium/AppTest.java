package TreinamentoAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest 
{
    @Test
    public void conectarAppiumEmulador() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        MobileElement el1 = driver.findElementById("com.android.calculator2:id/digit_2");
        el1.click();
        MobileElement el2 = driver.findElementById("com.android.calculator2:id/digit_5");
        el2.click();
        MobileElement el3 = driver.findElementByAccessibilityId("plus");
        el3.click();
        MobileElement el4 = driver.findElementById("com.android.calculator2:id/digit_3");
        el4.click();
        MobileElement el5 = driver.findElementById("com.android.calculator2:id/digit_9");
        el5.click();
        MobileElement el6 = driver.findElementByAccessibilityId("equals");
        el6.click();

        Assert.assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(), "64");
    }
}
