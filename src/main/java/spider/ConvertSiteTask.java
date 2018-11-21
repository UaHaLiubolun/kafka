package spider;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import spider.db.MongoJDBC;
import util.HttpUtils;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConvertSiteTask {

    static Gson gson = new Gson();

    static MongoDatabase database = MongoJDBC.getDataBase("spider");
    static MongoCollection<Map> news_list_collection = database.getCollection("news_list", Map.class);
    static MongoCollection<Map> news_list_task_collection = database.getCollection("news_list_task", Map.class);
    static MongoCollection<Map> gzh_list = database.getCollection("we_chat_gzh", Map.class);
    static MongoCollection<Map> gzh_content;

    static {
        gzh_content = database.getCollection("wei_xin_content", Map.class);
    }

    static void convert(String[] strings) {
        for (String s : strings) {
            Map newsList = getNewsList(s);
            Map newsListTask = getNewsListTask(newsList.get("urlMd5").toString());
            newsList.remove("_id");
            newsListTask.remove("_id");
            HttpUtils.executePost("http://spider-api.chinamcloud.com/newsList", JSON.toJSONString(newsList));
            HttpUtils.executePost("http://spider-api.chinamcloud.com/siteTask", JSON.toJSONString(newsListTask));
        }
    }

    static Map getNewsList(String s) {
        MongoCursor<Map> result = news_list_collection.find(eq("name", s)).iterator();
        while (result.hasNext()) {
            return result.next();
        }
        return null;
    }

    static Map getNewsListTask(String urlMd5) {
        MongoCursor<Map> result = news_list_task_collection.find(eq("urlMd5", urlMd5)).iterator();
        while (result.hasNext()) {
            return result.next();
        }
        return null;
    }

    static void getGzhToMongo() {
        String result = HttpUtils.executeGet("http://spider-api.chinamcloud.com/gzh", null);
        CodeResult codeResult = gson.fromJson(result, CodeResult.class);
        List<Map<String, String>> list = (List<Map<String, String>>)codeResult.getResult();
        list.stream().forEach(
                l -> gzh_list.insertOne(l)
        );
    }

    static void pushGzhContent() {
        List<Map> result = new ArrayList<>();
        MongoCursor<Map> mapMongoCursor = gzh_content.find().sort(eq("createdAt", -1)).limit(1500).iterator();
        while (mapMongoCursor.hasNext()) {
            Map map = mapMongoCursor.next();
            map.remove("_id");
            result.add(map);
        }
        System.out.println(JSON.toJSONString(result));
        String code = HttpUtils.executePost("http://spider-api.chinamcloud.com/kafka?auth=kafka", JSON.toJSONString(result));
        System.out.println(code);
    }

    public static void main(String[] args) {
//        String[] s = {};
//        ConvertSiteTask.convert(s);
        pushGzhContent();
    }
}
