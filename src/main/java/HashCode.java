import java.text.SimpleDateFormat;

public class HashCode {

    public static void main(String[] args) {
        String[] strings = {"看看新闻_中国", "看看新闻_全球", "看看新闻_上海", "看看新闻_港澳天", "看看新闻_文娱", "看看新闻_社会", "澎湃新闻_精选"};
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
