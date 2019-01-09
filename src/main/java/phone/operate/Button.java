package phone.operate;

import java.util.Arrays;


public enum Button {

    // 微信底部按钮
    WEIXIN_BTN("微信底部第一个按钮", "120,1800,200,1900"),
    TONGXUNLU_BTN("微信底部第二个按钮(通讯录)", "380,1800,460,1900"),

    GZH_FOLDER("公众号列表", "0,640,900,750"),
    FIRST_GZH_SEARCH_RESULT("搜索公众号第一个结果", "34,225,900,330"),

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
