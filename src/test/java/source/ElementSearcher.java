package source;

import org.openqa.selenium.WebElement;

/**
 * TODO поменять на ConditionWaiter
 */
public class ElementSearcher {

    public static int tryCount = 30;

    public static WebElement findElement(String xpath) {
        int i = 0;
        WebElement webElement = null;
        do {
            try {
                Thread.currentThread().sleep(1000L);
                webElement = Driver.INSTANCE.driver.findElementByXPath(xpath);
            } catch (Exception e) {
                i++;
                if (i > tryCount) throw new RuntimeException("Элемент по пути " + xpath + " не найден");
            }
        } while (webElement==null);
        return webElement;
    }

    public static WebElement findElementByClass(String className) {
        int i = 0;
        WebElement webElement = null;
        do {
            try {
                Thread.currentThread().sleep(1000L);
                webElement = Driver.INSTANCE.driver.findElementByClassName(className);
            } catch (Exception e) {
                i++;
                if (i > tryCount) throw new RuntimeException("Элемент по пути " + className + " не найден");
            }
        } while (webElement==null);
        return webElement;
    }

}
