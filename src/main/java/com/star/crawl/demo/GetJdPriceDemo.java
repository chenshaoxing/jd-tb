package com.star.crawl.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by star on 15/4/30.
 */
public class GetJdPriceDemo {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://p.3.cn/prices/get?skuid=J_627718&type=1&area=22_1930_50947&callback=cnp");
        System.out.println("executing request "+httpGet.getURI());
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());
        if(entity != null){
            System.out.println("Response content length: " + entity.getContentLength());
            // 打印响应内容
            String data = EntityUtils.toString(entity);
            System.out.println("Response content: " +data );
            data = data.substring(data.indexOf("(")+1,data.lastIndexOf(")"));
            List<PriceEntity> list = JSON.parseArray(data,PriceEntity.class);
            for(PriceEntity p:list){
                System.out.println(p.getId());
                System.out.println(p.getP());
                System.out.println(p.getM());
            }
        }
        response.close();
        httpClient.close();
    }


}
