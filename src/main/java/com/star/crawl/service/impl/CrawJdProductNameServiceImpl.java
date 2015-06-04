package com.star.crawl.service.impl;

import com.star.crawl.demo.DemoProcessor;
import com.star.crawl.entity.JDProduct;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by star on 15/5/2.
 */
public class CrawJdProductNameServiceImpl implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3);

    private JDProduct jdProduct;

    public CrawJdProductNameServiceImpl(JDProduct jdProduct) {
        this.jdProduct = jdProduct;
    }

    @Override
    public void process(Page page) {
//        page.addTargetRequest("http://item.jd.com/627718.html");
        page.putField("name",page.getHtml().xpath("//div[@id='name']/h1/text()").get());
//        jdProduct.setName(page.getResultItems().get("name").toString());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DemoProcessor()).addUrl("http://item.jd.com/740771.html").thread(1).run();
    }
}
