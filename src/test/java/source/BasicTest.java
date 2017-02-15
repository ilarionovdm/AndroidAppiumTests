package source;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        return capabilities;
    }

    public static void tapElement(String xpath) {
        Driver.getDriver().tap(1, ElementSearcher.findElement(xpath), 2);
    }

    public static boolean tryTapElement(String xpath) {
        try {
            tapElement(xpath);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setText(String elementXpath, String text) {
        ElementSearcher.findElement(elementXpath).sendKeys(text);
    }

    public static void waitTillAppear(String xpath) {
        new WebDriverWait(Driver.getDriver(), 90).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

}
