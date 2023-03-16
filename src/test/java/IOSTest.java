
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class IOSTest {
    private IOSDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
//Setting Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "iOS");
        capabilities.setCapability("appium:platformVersion", "16.2");
        capabilities.setCapability("appium:deviceName", "iPhone 14");
        capabilities.setCapability("appium:udid", "8128696F-0EA1-41B3-A2BC-3FBB97F2871C");
        capabilities.setCapability("appium:app", "/Users/pooja.manna/Downloads/Other_iOS_apps/HelloWorldiOS.app");
        capabilities.setCapability("appium:automationName", "XCUITest");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        System.out.println("------Driver initialized-------"+driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFindingAnElement() throws InterruptedException {
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Click me!']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"You successfully clicked the button!\"]")).getText(),"You successfully clicked the button!");
    }
}

