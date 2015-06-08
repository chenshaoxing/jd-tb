package com.csx.test;

import com.star.crawl.entity.JDProduct;
import com.star.crawl.service.CrawlJdProductInfoService;
import com.star.crawl.service.JDProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-06-08
 * Time: 16:52
 * function:
 * To change this template use File | Settings | File Templates.
 */
public class ActTest {
    public static void main(String[] args) throws Exception{
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        CrawlJdProductInfoService service = (CrawlJdProductInfoService)act.getBean("crawlJdProductInfoService");
        Map<String,Object> result = service.crawl("1290748");
        JDProductService jdProductService = (JDProductService)act.getBean("JDProductServiceImpl");
        JDProduct p = jdProductService.save(result);
        System.out.println(p);
    }
}
