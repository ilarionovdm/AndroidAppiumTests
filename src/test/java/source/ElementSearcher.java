package source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementSearcher {

    public static WebElement findElement(String xpath) {
        return new WebDriverWait(Driver.getDriver(), 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement findElementByClass(String className) {
        return new WebDriverWait(Driver.getDriver(), 30).until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }

}
