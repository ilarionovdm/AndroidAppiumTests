
import VKsrc.VKMacroses;
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

        tapElement("android.widget.TextView[@resource-id, 'tv_city'][0]");

    }
}
