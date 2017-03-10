package VKsrc;

import static source.BasicTest.setText;
import static source.BasicTest.tapElement;

public class VKMacroses {

    public static void login() {
        setText(VKElements.AUTH_LOGIN.xpath, VKConfig.getInstance().getLogin());
        setText(VKElements.AUTH_PASS.xpath, VKConfig.getInstance().getPassword());
        tapElement(VKElements.LOGIN_BUTTON.xpath);
}

}
