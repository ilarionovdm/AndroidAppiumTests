package VKsrc;

import static source.BasicTest.setText;
import static source.BasicTest.tapElement;

/**
 * Created by Lion on 30.01.2017.
 */
public class VKMacroses {

    public static void login() {
        setText(VKElements.AUTH_LOGIN.xpath, VKConfig.getInstance().getLogin());
        setText(VKElements.AUTH_PASS.xpath, VKConfig.getInstance().getPassword());
        tapElement(VKElements.LOGIN_BUTTON.xpath);
}

}
