package source;

import org.apache.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicTest {

    public static Logger log = Logger.getLogger(BasicTest.class);

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
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        return capabilities;
    }

    public static void tapElement(String xpath) {
        tapElement(xpath, 20);
    }

    public static void tapElement(String xpath, int time) {
        waitTillAppear(xpath);
        log.info("Тап по элементу по пути: " + xpath);
        Driver.getDriver().tap(1, ElementSearcher.findElement(xpath, time), 1);
    }

    public static boolean tryTapElement(String xpath) {
        try {
            tapElement(xpath, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setText(String elementXpath, String text) {
        log.info("Ввод текста '" + text + "' в элемент: " + elementXpath);
        ElementSearcher.findElement(elementXpath).sendKeys(text);
    }

    public static void waitTillAppear(String xpath) {
        log.info("Жду элемент: " + xpath);
        new WebDriverWait(Driver.getDriver(), 90).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static boolean swipeToElementAndTryToTap(String xpath) {
        try {
            for (int i = 0; i < 10; i++) {
                Driver.getDriver().swipe(540, 1700, 540, 900, 3000);
                if (tryTapElement(xpath))
                    return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
}
