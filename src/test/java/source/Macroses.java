package source;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lion on 30.01.2017.
 */
public class Macroses {

    public static AppiumDriver driver;

    public static void initializeDriver() {
        driver = Driver.INSTANCE.driver;
    }

    public static void login() {
        WebElement loginET = ElementSearcher.findElement(VKElements.AUTH_LOGIN.xpath);
        loginET.sendKeys(VKConfig.getInstance().getLogin());
        WebElement passwordET = ElementSearcher.findElement(VKElements.AUTH_PASS.xpath);
        passwordET.sendKeys(VKConfig.getInstance().getPassword());
        WebElement loginBTN = ElementSearcher.findElement(VKElements.LOGIN_BUTTON.xpath);
        driver.tap(1, loginBTN, 1);
    }

    public static void tapElement(String xpath) {
        driver.tap(1, ElementSearcher.findElement(xpath), 1);
    }
}
