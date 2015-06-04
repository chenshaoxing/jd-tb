package com.star.crawl.service;

import com.alibaba.fastjson.JSONObject;
import com.star.crawl.dao.PageInfo;
import com.star.crawl.entity.JDProduct;

import java.util.List;

/**
 * Created by star on 15/5/12.
 */
public interface JDProductService {
    public JDProduct save(JSONObject productObj);

    public List<JDProduct> getList();

    public PageInfo<JDProduct> getList(int currentPage,int pageSize);
}
