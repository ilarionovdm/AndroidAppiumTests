package AVIAsrc;


public enum AVIAElements {

    CITY_FROM("//android.widget.RelativeLayout[contains(@resource-id, 'btn_origin')]//android.widget.TextView[contains(@resource-id, 'tv_city')]"),
    CITY_SEARCH("//android.widget.EditText[contains(@resource-id, 'etv_select_airport_fragment')]"),
    FIRST_IN_CITY_SEARCH("//android.support.v7.widget.RecyclerView[contains(@resource-id, 'rv_select_airport_fragment')]//android.widget.RelativeLayout"),
    CITY_TO("//android.widget.RelativeLayout[contains(@resource-id, 'btn_destination')]//android.widget.TextView[contains(@resource-id, 'tv_city')]"),
    BTN_SEARCH("//android.widget.FrameLayout[contains(@resource-id, 'btn_search')]"),
    FIRST_IN_TICKET_SEARCH("//android.widget.FrameLayout[contains(@resource-id, 'cv_results_item')]"),
    SPISOK_OPERATOROV("//android.widget.Spinner[contains(@resource-id, 'spinner')]"),
    OPERATOR_OZON("//android.widget.TextView[contains(@text, 'OZON')]"),
    CHOISES("//android.view.View[contains(@content-desc, 'Варианты')]"),
    FLAG_SUCCESS_LOAD_CHOOSE_PAGE("//*[contains(@content-desc, 'На соседние даты есть билеты')]"),
    URAL_LINES_CHOISE("//*[contains(@content-desc, 'Уральские авиалинии')]"),
    CHOOSE_ANY_CHOISE("//*[contains(@content-desc, 'i')]"),
    BTN_CHOISE("//android.widget.Button[contains(@content-desc, 'выбрать вариант перелета')]"),
    CHECK_BOX_ADD_COMFORT("//android.widget.CheckBox[contains(@content-desc, 'Добавить')]");

    public final String xpath;

    AVIAElements(String xpath) {
        this.xpath = xpath;
    }
}
