package VKsrc;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import source.Driver;
import source.ElementSearcher;

/**
 * Created by Lion on 30.01.2017.
 */
public class VKMacroses {

    public static AppiumDriver driver = Driver.INSTANCE.driver;

    public static void login() {
        WebElement loginET = ElementSearcher.findElement(VKElements.AUTH_LOGIN.xpath);
        loginET.sendKeys(VKConfig.getInstance().getLogin());
        WebElement passwordET = ElementSearcher.findElement(VKElements.AUTH_PASS.xpath);
        passwordET.sendKeys(VKConfig.getInstance().getPassword());
        WebElement loginBTN = ElementSearcher.findElement(VKElements.LOGIN_BUTTON.xpath);
        driver.tap(1, loginBTN, 1);
    }

}
