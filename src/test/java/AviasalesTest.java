import AVIAsrc.AVIAElements;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import source.BasicTest;
import source.Driver;

import java.io.File;
import java.net.URL;


public class AviasalesTest extends BasicTest {

    @Before
    public void setUp() throws Exception {
        File app = new File("src/test/resources/Aviasales-v2.0.apk");
        Driver.INSTANCE.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), setCapability(app.getAbsolutePath()));
    }

    @Test
    public void test(){

        tapElement(AVIAElements.CITY_FROM.xpath);

        setText(AVIAElements.CITY_SEARCH.xpath, "МОСКВА");

        tapElement(AVIAElements.FIRST_IN_CITY_SEARCH.xpath);

        tapElement(AVIAElements.CITY_TO.xpath);

        setText(AVIAElements.CITY_SEARCH.xpath, "АДЛЕР");

        tapElement(AVIAElements.FIRST_IN_CITY_SEARCH.xpath);

        tapElement(AVIAElements.BTN_SEARCH.xpath);

        tapElement(AVIAElements.FIRST_IN_TICKET_SEARCH.xpath);

        tapElement(AVIAElements.SPISOK_OPERATOROV.xpath);

        if (!tryTapElement(AVIAElements.OPERATOR_OZON.xpath))
            return;

        tapElement(AVIAElements.CHOISES.xpath);

        waitTillAppear(AVIAElements.FLAG_SUCCESS_LOAD_CHOOSE_PAGE.xpath);

        if (!swipeToElementAndTryToTap(AVIAElements.URAL_LINES_CHOISE.xpath))
            tapElement(AVIAElements.CHOOSE_ANY_CHOISE.xpath);

        tapElement(AVIAElements.BTN_CHOISE.xpath);

        tapElement(AVIAElements.CHECK_BOX_ADD_COMFORT.xpath);
    }
}
