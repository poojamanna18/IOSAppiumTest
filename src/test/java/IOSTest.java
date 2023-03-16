
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;



public class IOSTest {
    private IOSDriver driver;
    @BeforeEach
    public void setUp() throws MalformedURLException {
//Setting Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "iOS");
        capabilities.setCapability("appium:platformVersion", "16.2");
        capabilities.setCapability("appium:deviceName", "iPhone 14");
        capabilities.setCapability("appium:udid", "8128696F-0EA1-41B3-A2BC-3FBB97F2871C");
        capabilities.setCapability("appium:app", System.getProperty("user.dir")+ "/src/test/resources/apps/HelloWorldiOS.app");
        capabilities.setCapability("appium:automationName", "XCUITest");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        System.out.println("------Driver initialized-------"+driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFindingAnElement() throws InterruptedException {
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Click me!']")).click();
       Assertions.assertEquals(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"You successfully clicked the button!\"]")).getText(),"You successfully clicked the button!");
    }
}

