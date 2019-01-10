package phone.operate;

import java.util.Arrays;


public enum Button {

    // 微信底部按钮
    WEIXIN_BTN("微信底部第一个按钮", "120,1800,200,1900"),
    TONGXUNLU_BTN("微信底部第二个按钮(通讯录)", "380,1800,460,1900"),

    GZH_FOLDER("公众号列表", "0,640,900,750"),
    FIRST_GZH_SEARCH_RESULT("搜索公众号第一个结果", "34,225,900,330"),

    ADD_FRIEND("添加朋友", "520,345,1030,450"),
    INPUT("输入框", "180,290,854,354"),
    FIRST_ADD_FRIEND_RESULT("搜索后第一个结果", "64,280,633,317"),
    SEARCH("搜一搜", "82,580,895,685"),
    GZH_BUTTON("公众号按钮", "224,238,345,294"),
    FIRST_SEARCH_RESULT("搜一搜后第一个结果", "90,521,850,689"),

    GUAN_ZHU1("关注", "520,850,558,900"),
    GUAN_ZHU2("关注", "520,900,558,950"),
    GUAN_ZHU3("关注", "520,950,558,1000"),
    GUAN_ZHU4("关注", "520,1000,558,1050"),
    GUAN_ZHU5("关注", "520,1050,558,1100"),
    GUAN_ZHU6("关注", "520,1100,558,1150"),

    RETURN("返回", "12,83,96,183"),



    BLACK("空白区域", "311,112,619,163"),

    // 公众号列表页面
    SEARCH_BTN("搜索公众号", "800,120,860,200"),
    ADD_BTN("添加公众号", "950,100,1020,200"),

    PROFILE_BTN("公众号详情（右上角小人头）", "950,100,1020,200"),

    ALL_HISTORY_MSG("公众号全部消息", "34,1720,1024,1720")
    ;

    Button(String name, String add) {
        this.name = name;
        String[] s = add.split(",");
        Object[] integers = Arrays.stream(s).map(Integer::parseInt).toArray();
        int i = 0;
        this.addresss = new Integer[4];
        for (Object o:
             integers) {
            this.addresss[i] = (Integer) o;
            i++;
        }
    }

    private String name;
    private Integer[] addresss;

    public String getName() {
        return name;
    }

    public Integer[] getAddresss() {
        return addresss;
    }
}
