package com.star.crawl.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.star.crawl.common.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-06-04
 * Time: 15:26
 * function:
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "crawlJdProductInfoService")
public class CrawlJdProductInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(CrawlJdProductInfoService.class);

    /**
     * key:sort(排序),price(最新价格),name(商品名称),crawlUrl(商品url),pic(图片地址),skuid(id),discount(优惠金额)
     * @param skuId
     * @return
     * @throws Exception
     */
    public  Map<String,Object> crawl(String skuId) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urls = Constants.CRAWL_JD_PRODUCT_INFO_URL_PREFIX+"skuId="+skuId+"&_="+new Date().getTime();
        HttpGet httpGet = new HttpGet(urls);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine());
            if(entity != null){
                String data = EntityUtils.toString(entity);
                LOG.info("Response content: " + data);
                data = data.substring(data.indexOf("(")+1,data.lastIndexOf(")"));
                JSONObject obj = JSON.parseObject(data);
                obj.put("crawlUrl",urls);
                Map<String,Object> result = (Map<String,Object>)obj.get("master");
                result.put("crawlUrl",urls);
                return result;
            }
            return null;
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw e;
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception{
        CrawlJdProductInfoService service = new CrawlJdProductInfoService();
        String skUid = "1217499";
        Map<String,Object> obj = service.crawl(skUid);
        System.out.println(obj);
    }

}
