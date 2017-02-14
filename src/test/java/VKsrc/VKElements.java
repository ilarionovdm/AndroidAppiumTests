package VKsrc;

/**
 * Created by Lion on 30.01.2017.
 */
public enum VKElements {

    AUTH_LOGIN("//android.widget.EditText[contains(@resource-id, 'auth_login')]"),
    AUTH_PASS("//android.widget.EditText[contains(@resource-id, 'auth_pass')]"),
    LOGIN_BUTTON("//android.widget.Button[contains(@resource-id, 'auth_login_btn')]"),
    ACTIVITY_NEWS("//android.widget.TextView[@text='Новости']"),
    MENU_AUDIO("//android.widget.TextView[@text='Аудиозаписи']"),
    ACTIVITY_AUDIO("//android.widget.TextView[@text='Мои аудиозаписи']"),
    FIGNYA_V_PRAVOM_VERHNEM_UGLU_V_MENU_AUDIO("//android.support.v7.widget.LinearLayoutCompat"),
    SEARCH("//android.widget.EditText[contains(@resource-id, 'search_input')]"),
    FIRST_SONG("//android.support.v7.widget.RecyclerView[contains(@resource-id, 'list')]//android.widget.TextView[contains(@resource-id, 'audio_title')]"),
    PLAYER_MENU_FROM_AUDIO_ACTIVITY("//android.widget.ViewFlipper"),
    PLAY_STOP_BUTTON("//android.widget.ImageView[contains(@resource-id, 'aplayer_play')]");

    public final String xpath;

    VKElements(String xpath) {
        this.xpath = xpath;
    }

}
