
package util;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class HttpUtils {

    public HttpUtils() {
    }

    public static String executePost(String url, String queryParams) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(60000).build();
        httpPost.setConfig(requestConfig);
        StringEntity entity = new StringEntity(queryParams, "UTF-8");
        entity.setContentType("text/json");
        httpPost.setEntity(entity);
        String result = "";

        try {
            response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity2 = response.getEntity();
                result = EntityUtils.toString(entity2);
                EntityUtils.consume(entity2);
            } else {
                System.out.println(url);
            }
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException var16) {
                var16.printStackTrace();
            }

        }

        return result;
    }

    public static String executeGet(String url, Header[] headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(60000).build();
        httpGet.setConfig(requestConfig);
        httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.addHeader("Connection", "Keep-Alive");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        httpGet.addHeader("Cookie", "");
        if (headers != null && headers.length > 0) {
            httpGet.setHeaders(headers);
        }

        String result = null;

        try {
            response = httpClient.execute(httpGet);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            } else {
                System.out.println("failed get: " + url);
            }
        } catch (IOException var16) {
            var16.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException var15) {
                var15.printStackTrace();
            }

        }

        return result;
    }

    public static String executeGet(String url, String queryParams, Header[] headers) {
        Map<String, Object> params = JSON.parseObject(queryParams);
        Entry param;
        if (params != null && !params.isEmpty()) {
            for(Iterator var4 = params.entrySet().iterator(); var4.hasNext(); url = url + "&" + (String)param.getKey() + "=" + param.getValue()) {
                param = (Entry)var4.next();
            }
        }

        return executeGet(url, headers);
    }
}
