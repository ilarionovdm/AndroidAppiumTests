package source;

import org.junit.After;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BasicTest {

    private DesiredCapabilities capabilities;

    @After
    public void tearDown() throws Exception {
        Driver.getDriver().quit();
    }

    public DesiredCapabilities setCapability(String appPath) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "21");
        capabilities.setCapability(CapabilityType.PLATFORM, "");
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("app-package", "com.example.android.apis");
        capabilities.setCapability("app-activity", ".ApiDemos");
        return capabilities;
    }

    public static void tapElement(String xpath) {
        Driver.getDriver().tap(1, ElementSearcher.findElement(xpath), 1);
    }
}
