import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import source.*;

import java.io.File;
import java.net.URL;



public class VkTest {

    @Before
    public void setUp() throws Exception {
        File app = new File("src/test/resources/VK_4_5_1.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "21");
        capabilities.setCapability(CapabilityType.PLATFORM, "");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("app-package", "com.example.android.apis");
        capabilities.setCapability("app-activity", ".ApiDemos");
        Driver.INSTANCE.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Macroses.initializeDriver();
    }

    @After
    public void tearDown() throws Exception {
        Driver.getDriver().quit();
    }

    @Test
    public void apiDemo(){
        //вход в ВК (логин - пароль - Войти)
        Macroses.login();

        //проверяем, что загрузилось активити с Новостями
        ElementSearcher.findElement(VKElements.ACTIVITY_NEWS.xpath);

        //тап по верхнему левому углу(открытие меню)
        Driver.getDriver().tap(1,75,75,1); //cheat

        //переход в аудиозаписи
        Macroses.tapElement(VKElements.MENU_AUDIO.xpath);

        //проверка, что открыты аудиозаписи
        ElementSearcher.findElement(VKElements.ACTIVITY_AUDIO.xpath);

        //клик по фигне справа в верхнем углу (открывает строку поиска)
        Macroses.tapElement(VKElements.FIGNYA_V_PRAVOM_VERHNEM_UGLU_V_MENU_AUDIO.xpath);

        //запиливаем название песни
        ElementSearcher.findElement(VKElements.SEARCH.xpath).sendKeys(VKConfig.getInstance().getSongName());

        //скрываем клавиатуру
        Driver.getDriver().hideKeyboard();

        //открываем первую песню
        Macroses.tapElement(VKElements.FIRST_SONG.xpath);

        //открываем меню проигрывателя
        Macroses.tapElement(VKElements.PLAYER_MENU_FROM_AUDIO_ACTIVITY.xpath);

        //кликаем в середину песни
        Driver.getDriver().tap(1, ElementSearcher.findElementByClass("android.widget.SeekBar"), 1);

        //останавливаем воспроизведение
        Macroses.tapElement(VKElements.PLAY_STOP_BUTTON.xpath);
    }
}
