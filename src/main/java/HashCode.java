import java.text.SimpleDateFormat;

public class HashCode {

    public static void main(String[] args) {
        String[] strings = {"北京时间_新闻搜索", "新浪_新闻搜索", "百度_新闻搜索", "东方网_首页滚动", "zyjwgjjw", "liekutv", "gh_4925269112e0", "zhtv_n21", "newsxinhua"};
        for (String s:
             strings) {
//            System.out.println("INSERT INTO `t_user_crawler` (`userId`, `sourceId`, `sourceType`, `comment`) VALUES ('10310', '"+  Math.abs(s.hashCode()) +"', '1', '"+ s +"');");
            System.out.println(s + ":" + Math.abs(s.hashCode()));
        }

        String time = "   发布时间：2018-09-10 08:38     来源：巢湖晨刊     阅读：";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            System.out.println(sf.parse(time).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
