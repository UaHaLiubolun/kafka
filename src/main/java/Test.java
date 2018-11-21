import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

    private static Gson gson = new Gson();

    private static final Type mapType = new TypeToken<Map<String,Object>>(){}.getType();


    public static void main(String[] args) {

        String input = "[\n" +
                "  {\n" +
                "    \"headers\" : {\n" +
                "      \"logtype\" : \"read\",\n" +
                "      \"tenant\" : \"default\"\n" +
                "    },\n" +
                "    \"body\" : \"{\\n  \\\"tenant\\\" : \\\"default\\\",\\n  \\\"mobile\\\" : \\\"18108100946\\\",\\n  \\\"client\\\" : \\\"IOS\\\",\\n  \\\"userName\\\" : \\\"log了咯哦哦咯\\\",\\n  \\\"content\\\" : {\\n    \\\"catalogId\\\" : \\\"1172\\\",\\n    \\\"virtualIncrement\\\" : \\\"1\\\",\\n    \\\"title\\\" : \\\"1234567\\\",\\n    \\\"source\\\" : \\\"cms\\\",\\n    \\\"type\\\" : \\\"1\\\",\\n    \\\"articleId\\\" : \\\"30104529\\\"\\n  },\\n  \\\"message_type\\\" : \\\"read\\\",\\n  \\\"timeStamp\\\" : 1533879736647,\\n  \\\"user_id\\\" : \\\"2656973\\\",\\n  \\\"deviceInfo\\\" : {\\n    \\\"deviceId\\\" : \\\"e2a391aaaf96d8247235d453557064be03408ed0\\\",\\n    \\\"device_producer\\\" : \\\"苹果\\\",\\n    \\\"device_model\\\" : \\\"iPhone X\\\",\\n    \\\"system_version\\\" : \\\"11.4.1\\\"\\n  }\\n}\"\n" +
                "  }\n" +
                "]";
        String regexS = "\\[\\{\"headers\":\\{.*},\"body\":\"\\{(.*)}\"}]";
        Pattern pattern = Pattern.compile(regexS);
        input = input.replace("\n", "").replace("\\n", "")
                .replace(" ", "")
                .replace("\\", "");
        Matcher matcher = pattern.matcher(input);

        String oData =null;
        if (matcher.find()) {
            oData = "{" + matcher.group(1) + "}";
        }

//        String oData = "{\"tenant\":\"default\",\"mobile\":\"18190710787\",\"client\":\"IOS\",\"action\":\"behivor\",\"userName\":\"1234\",\"message_type\":\"read\",\"timeStamp\":1533809494888,\"content\":{\"catalogId\":\"1172\",\"virtualIncrement\":\"1\",\"title\":\"1234567\",\"source\":\"cms\",\"type\":\"1\",\"articleId\":\"30104529\"},\"user_id\":\"2656961\",\"deviceInfo\":{\"deviceId\":\"e2a391aaaf96d8247235d453557064be03408ed0\",\"device_producer\":\"苹果\",\"device_model\":\"iPhoneX\",\"system_version\":\"11.4.1\"}}\n";
        Map<String, Object> map = gson.fromJson(oData, mapType);
        if (!map.get("action").toString().equals("behivor") || !map.get("message_type").equals("read")) {
            return;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("action", "behivor");
        result.put("user_id", map.get("user_id"));
        result.put("tenant", map.get("tenant"));
        Map<String, String> contentMap = (Map<String, String>) map.get("content");
        result.put("act_obj", contentMap.get("articleId"));
        result.put("timeStamp", map.get("timeStamp"));
        result.put("client", map.get("client"));
        result.put("userName", map.get("userName"));
        result.put("mobile", map.get("mobile"));
        System.out.println(gson.toJson(result));
    }
}
