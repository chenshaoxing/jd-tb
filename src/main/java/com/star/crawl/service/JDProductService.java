package com.star.crawl.service;

import com.alibaba.fastjson.JSONObject;
import com.star.crawl.dao.PageInfo;
import com.star.crawl.entity.JDProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by star on 15/5/12.
 */
public interface JDProductService {
    public JDProduct save(Map<String,Object> objectMap);

    public JDProduct save(JDProduct jdProduct);

    public List<JDProduct> getList();

    public JDProduct findBySkuId(String skuId);

    public PageInfo<JDProduct> getList(int currentPage,int pageSize);
}
