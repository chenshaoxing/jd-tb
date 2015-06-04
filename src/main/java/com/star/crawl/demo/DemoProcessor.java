package com.star.crawl.demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.UUID;

/**
 * Created by star on 15/4/30.
 */
public class DemoProcessor implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3);


    @Override
    public void process(Page page) {
        page.addTargetRequest("http://item.jd.com/627718.html");
//        page.putField("id",page.getUrl().regex());
        page.putField("name",page.getHtml().xpath("//div[@id='name']/h1/text()").get());
//        System.out.println(page.getResultItems().get("price"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DemoProcessor()).addUrl("http://item.jd.com/740771.html").thread(1).run();
    }
}
