package com.star.crawl.task;

import com.star.crawl.common.Utils;
import com.star.crawl.dao.PageInfo;
import com.star.crawl.entity.JDProduct;
import com.star.crawl.entity.TaoBaoProduct;
import com.star.crawl.service.CrawlJdProductInfoService;
import com.star.crawl.service.JDProductService;
import com.star.crawl.service.TaoBaoProductInfoService;
import com.star.crawl.service.TaoBaoProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-06-08
 * Time: 15:41
 * function:
 * To change this template use File | Settings | File Templates.
 */
public class ScanJDProductInfoTask {
    private static final Logger LOG = LoggerFactory.getLogger(ScanJDProductInfoTask.class);

    @Resource
    private JDProductService jdProductService;
    @Resource
    private CrawlJdProductInfoService crawlJdProductInfoService;
    @Resource
    private TaoBaoProductService taoBaoProductService;
    @Resource
    private TaoBaoProductInfoService taoBaoProductInfoService;



    public void scan(){
        try{
            int currentPage = 1;
            PageInfo pageInfo = jdProductService.getList(currentPage, 10);
            int pageNum = pageInfo.getPageTotalNum();
            for(int i = 1;i<=pageNum;i++){
                pageInfo = jdProductService.getList(i,100);
                List<JDProduct> jdProductList = pageInfo.getList();
                for(JDProduct jd:jdProductList){
                    Map<String,Object> result = crawlJdProductInfoService.crawl(jd.getSkuid());
                    if(result != null){
                        Float price = Float.valueOf(result.get("price").toString());
                        BigDecimal latestPrice = new BigDecimal(price);
                        BigDecimal afterPrice = new BigDecimal(jd.getPrice());
                        if(latestPrice.compareTo(afterPrice) != 0){
                            jd.setPrice(price);
                            jd.setDiscount(Float.valueOf(result.get("discount").toString()));
                            jd.setName(result.get("name").toString());
                            jdProductService.save(jd);
                            Set<TaoBaoProduct> taoBaoProducts =  jd.getTaoBaoProducts();
                            for(TaoBaoProduct tb:taoBaoProducts){
                               tb.setPrice(price+tb.getDifferenceOfPrices());
                               boolean flag = taoBaoProductInfoService.updateProductPrice(tb,tb.getUser().getSessionKey());
                               if(flag){
                                   taoBaoProductService.add(tb);
                               }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            LOG.error(e.getMessage());
        }
    }
}
