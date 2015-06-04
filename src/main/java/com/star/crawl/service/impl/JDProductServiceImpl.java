package com.star.crawl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.star.crawl.common.Constants;
import com.star.crawl.dao.Expression;
import com.star.crawl.dao.IBasePersistence;
import com.star.crawl.dao.PageInfo;
import com.star.crawl.entity.JDProduct;
import com.star.crawl.service.JDProductService;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by star on 15/5/12.
 */
@Service(value ="JDProductServiceImpl")
public class JDProductServiceImpl implements JDProductService {
    @Resource
    private IBasePersistence basePersistence;

    @Override
    public JDProduct save(JSONObject productObj) {
        return basePersistence.save(jsonObjChangeJDProduct(productObj));
    }


    @Override
    public List<JDProduct> getList() {
        return basePersistence.getAllEntities(JDProduct.class);
    }

    @Override
    public PageInfo<JDProduct> getList(int currentPage, int pageSize) {
        List<Expression> list = new ArrayList<Expression>();
        return basePersistence.getEntitiesByExpressions(JDProduct.class,list,"id",currentPage,pageSize);
    }


    private JDProduct jsonObjChangeJDProduct(JSONObject productObj){
        Map<String,String> master = (Map<String,String>)productObj.get("master");
        JDProduct product = new JDProduct();
        product.setCrawlProductInfoUrl(productObj.getString("crawlUrl"));
        product.setDiscount(Float.valueOf(master.get("discount")));
        product.setPrice(Float.valueOf(master.get("price")));
        product.setProductName(master.get("name"));
        product.setProductUrl(Constants.JD_PRODUCT_ITEM_PREFIX+master.get("skuid")+Constants.JD_PRODUCT_ITEM_END_PREFIX);
        product.setSkuId(master.get("skuid"));
        product.setProductPicUrl(Constants.JD_PRODUCT_INFO_IMAGE_URL_PREFIX+master.get("pic"));
        return product;
    }
}
