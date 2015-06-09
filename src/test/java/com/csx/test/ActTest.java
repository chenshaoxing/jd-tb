package com.csx.test;

import com.star.crawl.entity.JDProduct;
import com.star.crawl.entity.TaoBaoProduct;
import com.star.crawl.service.CrawlJdProductInfoService;
import com.star.crawl.service.JDProductService;
import com.star.crawl.service.TaoBaoProductInfoService;
import com.star.crawl.service.TaoBaoProductService;
import com.taobao.api.domain.Item;
import com.taobao.api.response.ItemsOnsaleGetResponse;
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
//        CrawlJdProductInfoService service = (CrawlJdProductInfoService)act.getBean("crawlJdProductInfoService");
//        Map<String,Object> result = service.crawl("1290748");
//        JDProductService jdProductService = (JDProductService)act.getBean("JDProductServiceImpl");
//        JDProduct p = jdProductService.save(result);

        TaoBaoProductInfoService infoService = (TaoBaoProductInfoService)act.getBean("taoBaoProductInfoService");
//        TaoBaoProductService taoBaoProductService = (TaoBaoProductService)act.getBean("taoBaoProductServiceImpl");
//        TaoBaoProduct product = taoBaoProductService.findById(1L);
//        ItemsOnsaleGetResponse response = infoService.search(1l, 30l, "", "61009279751266b2eef966ead7d1eea78521cb4c4d40aff2074082787");
//        for(Item item:response.getItems()){
//            System.out.println(item.getNum() + "  - "+item.getPrice()+"  --   "+item.getNumIid());
//        }
        TaoBaoProduct product = new TaoBaoProduct();
        product.setNumIid(2100608385066l);
        product.setPrice(99f);
//        infoService.updateProductPrice(product,"6102917987b523e06b6565087165bd84a3be5fe4b699a492074082787");
        infoService.updateProductPrice(product,"61020190440fb4fd5411b4d658c1ce0fb99aea29ab415322074082787");
        System.out.println(1);
    }
}
