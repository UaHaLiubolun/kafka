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

       try {
           System.out.println("Exception Main");
           String s = null;
           s.toCharArray();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
