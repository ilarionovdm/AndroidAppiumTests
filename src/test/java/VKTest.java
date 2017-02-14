import VKsrc.VKConfig;
import VKsrc.VKElements;
import VKsrc.VKMacroses;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import source.BasicTest;
import source.Driver;
import source.ElementSearcher;

import java.io.File;
import java.net.URL;



public class VKTest extends BasicTest {

    @Before
    public void setUp() throws Exception {
        File app = new File("src/test/resources/VK_4_5_1.apk");
        Driver.INSTANCE.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), setCapability(app.getAbsolutePath()));
    }

    @Test
    public void test(){

        VKMacroses.initializeDriver();

        //вход в ВК (логин - пароль - Войти)
        VKMacroses.login();

        //проверяем, что загрузилось активити с Новостями
        ElementSearcher.findElement(VKElements.ACTIVITY_NEWS.xpath);

        //тап по верхнему левому углу(открытие меню)
        Driver.getDriver().tap(1,75,75,1); //cheat

        //переход в аудиозаписи
        tapElement(VKElements.MENU_AUDIO.xpath);

        //проверка, что открыты аудиозаписи
        ElementSearcher.findElement(VKElements.ACTIVITY_AUDIO.xpath);

        //клик по фигне справа в верхнем углу (открывает строку поиска)
        tapElement(VKElements.FIGNYA_V_PRAVOM_VERHNEM_UGLU_V_MENU_AUDIO.xpath);

        //запиливаем название песни
        ElementSearcher.findElement(VKElements.SEARCH.xpath).sendKeys(VKConfig.getInstance().getSongName());

        //скрываем клавиатуру
        Driver.getDriver().hideKeyboard();

        //открываем первую песню
        tapElement(VKElements.FIRST_SONG.xpath);

        //открываем меню проигрывателя
        tapElement(VKElements.PLAYER_MENU_FROM_AUDIO_ACTIVITY.xpath);

        //кликаем в середину песни
        Driver.getDriver().tap(1, ElementSearcher.findElementByClass("android.widget.SeekBar"), 1);

        //останавливаем воспроизведение
        tapElement(VKElements.PLAY_STOP_BUTTON.xpath);
    }
}
