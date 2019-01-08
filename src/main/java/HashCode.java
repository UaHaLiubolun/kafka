import java.text.SimpleDateFormat;

public class HashCode {

    public static void main(String[] args) {
        String[] strings = {"中国吉林网_时间轴", "中国吉林网_第一新闻 _吉网原创", "人民网_滚动新闻", "澎湃新闻_财经", "澎湃新闻_思想", "澎湃新闻_问政", "澎湃新闻_精选", "sytv1994 ", "网易新闻_国内", "网易新闻_国际"};
        for (String s:
             strings) {
//            System.out.println("INSERT INTO `t_user_crawler` (`userId`, `sourceId`, `sourceType`, `comment`) VALUES ('10310', '"+  Math.abs(s.hashCode()) +"', '1', '"+ s +"');");
            System.out.println(s + ":" + Math.abs(s.hashCode()));
        }

        String time = "2018-09-10 08:38     来源：巢湖晨刊     阅读：";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            System.out.println(sf.parse(time).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
