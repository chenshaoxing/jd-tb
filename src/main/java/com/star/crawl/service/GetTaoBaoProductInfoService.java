package com.star.crawl.service;

import com.star.crawl.common.Constants;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-06-04
 * Time: 17:58
 * function:
 * To change this template use File | Settings | File Templates.
 */
public class GetTaoBaoProductInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(GetTaoBaoProductInfoService.class);

    public ItemsOnsaleGetResponse search(Long currentPage,Long pageSize,String nameSearch) throws Exception{
        try{
            TaobaoClient client=new DefaultTaobaoClient(Constants.TB_SANDBOX_API_URL, Constants.TB_SANDBOX_APP_KEY, Constants.TB_SANDBOX_APP_SECRET);
            ItemsOnsaleGetRequest req=new ItemsOnsaleGetRequest();
            req.setFields("num_iid,num,pic_url,detail_url,nick,sold_quantity,title,price");
            req.setPageNo(currentPage);
            req.setQ(nameSearch);
            req.setOrderBy("list_time:desc");
            req.setIsTaobao(true);
            req.setPageSize(pageSize);
            ItemsOnsaleGetResponse response = client.execute(req , Constants.TB_SANDBOX_SESSION_KEY);
            return response;
        }catch (Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {

//        search();
    }


}
