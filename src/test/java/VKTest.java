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

        //вход в ВК (логин - пароль - Войти)
        VKMacroses.login();

        //проверяем, что загрузилось активити с Новостями
        waitTillAppear(VKElements.ACTIVITY_NEWS.xpath);
        //waitTillAppear("//android.widget.LinearLayout[contains(@resource-id, 'post_profile_btn')]");
        //тап по верхнему левому углу(открытие меню)
        //Driver.getDriver().tap(1,75,75,3); //cheat
        tapElement("//android.widget.ImageButton[ancestor::android.view.View[child::android.widget.Spinner]]");

        //swipeToElementAndTryToTap(VKElements.MENU_AUDIO.xpath);
        waitTillAppear(VKElements.MENU_AUDIO.xpath);
        //переход в аудиозаписи
        tapElement(VKElements.MENU_AUDIO.xpath);

        //проверка, что открыты аудиозаписи
        waitTillAppear(VKElements.ACTIVITY_AUDIO.xpath);

        //клик по фигне справа в верхнем углу (открывает строку поиска)
        tapElement(VKElements.FIGNYA_V_PRAVOM_VERHNEM_UGLU_V_MENU_AUDIO.xpath);

        //запиливаем название песни
        //ElementSearcher.findElement(VKElements.SEARCH.xpath).sendKeys(VKConfig.getInstance().getSongName());
        setText(VKElements.SEARCH.xpath, VKConfig.getInstance().getSongName());

        //скрываем клавиатуру
        Driver.getDriver().hideKeyboard();

        waitTillAppear(VKElements.FIRST_SONG.xpath);

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
