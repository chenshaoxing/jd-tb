package com.star.crawl.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-09-02
 * Time: 11:45
 * function:
 * To change this template use File | Settings | File Templates.
 */
public class DemoProcessor1  implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3);

    public DemoProcessor1(List<Map<String, Object>> list) {
        this.list = list;
    }

    public DemoProcessor1() {

    }

    private static  boolean isStop = false;
    List<Map<String,Object>> list;

    @Override
    public void process(Page page) {
        Document document = page.getHtml().getDocument();
        String text = document.body().children().get(1).html().replaceAll("&quot;","").replaceAll("\\\\", "");
        Document doc = Jsoup.parse(text);
        Elements total = doc.getElementById("shop-search-list").getElementsByClass("search-result");
        if(total.size() == 1){
            String count = total.get(0).getElementsByTag("span").get(0).text();
            if(count.equals("0")){
                isStop = true;
                return;
            }
        }
        Elements elements = doc.getElementsByClass("item");
        for(Element element : elements){
            try{
                Map<String,Object> product = new HashMap<String, Object>();
                product.put("id",element.attr("data-id"));
                System.out.println("id:"+element.attr("data-id"));
                Elements item = element.children();
                if(item.size() == 3){
                    Element photo = item.get(0);
                    Elements img = photo.getElementsByTag("img");
                    if(img.size() == 1){
                        System.out.println("图片:"+img.get(0).attr("src"));
                        product.put("img","https:"+img.get(0).attr("src"));
                    }
                    Element detail = item.get(1);
                    Elements detailChild = detail.children();
                    if(detailChild.size() ==  2){
                        Element detailE = detailChild.get(0);
                        System.out.println("title: "+detailE.text());
                        product.put("title",detailE.text());
                        Elements elements1 = detailChild.get(1).getElementsByClass("c-price");
                        if(elements1.size() == 1){
                            System.out.println("price: "+elements1.get(0).text());
                            product.put("price",elements1.get(0).text());
                        }
                    }
                }
                list.add(product);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws Exception {
//        test();
    }

    public List<Map<String,Object>> crawlTaoBao() throws Exception{
        int i = 1;
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        isStop = false;
        while (true){
            if(isStop){
                break;
            }
//            String myurl = "https://fuckbug.taobao.com/i/asynSearch.htm?_ksTS=1441112489944_268&callback=jsonp269&mid=w-129628754-0&wid=129628754&search=y&spm=a1z10.1-c.0.0.dSqoFq&pageNo="+i;
            String jingchaourl = "https://shop129597975.taobao.com/i/asynSearch.htm?_ksTS=1441174290828_108&callback=jsonp109&mid=w-12037889555-0&wid=12037889555&path=/search.htm&search=y&spm=a1z10.1-c.0.0.yfDgSS&pageNo="+i;
            String shazurl = "https://shop126833539.taobao.com/i/asynSearch.htm?_ksTS=1441174433512_122&callback=jsonp123&mid=w-11648329877-0&wid=11648329877&path=/category.htm&spm=a1z10.3-c.w4010-11648329875.2.wCaLZN&search=y&pageNo="+i;
            Spider.create(new DemoProcessor1(list)).addUrl(shazurl).thread(1).run();
            i++;
        }
        return list;

    }
}
