package source;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Lion on 30.01.2017.
 */
public enum Driver {

    INSTANCE;
    public AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return Driver.INSTANCE.driver;
    }
}

