package source;

import io.appium.java_client.AppiumDriver;


public enum Driver {

    INSTANCE;
    public AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return Driver.INSTANCE.driver;
    }
}

