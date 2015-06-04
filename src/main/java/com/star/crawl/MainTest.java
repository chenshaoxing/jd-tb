package com.star.crawl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by star on 15/4/30.
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
//        JDProductService jdProductService = (JDProductService)act.getBean("JDProductServiceImpl");
//        JDProductArea area = new JDProductArea();
//        area.setArea("22_1930_4284");
//        area.setDescription("四川成都");
//        area.setId(4);
//
//
//        JDProductArea area1 = new JDProductArea();
//        area1.setArea("25_2235_2236");
//        area1.setDescription("云南昆明");
//        area1.setId(5);
//
//        JDProductArea area2 = new JDProductArea();
//        area2.setArea("24_2144_2145");
//        area2.setDescription("贵州贵阳");
//        area2.setId(6);
//
////
//        JDProduct jdProduct1 = new JDProduct("欧德堡 脱脂","627719",area);
//        JDProduct jdProduct2 = new JDProduct("欧德堡 全脂","627718",area);
//        JDProduct jdProduct3 = new JDProduct("欧德堡 部分脱脂","627718",area);
//        JDProduct jdProduct4 = new JDProduct("欧德堡 小包装","1385736",area);
//
//        JDProduct jdProduct11 = new JDProduct("欧德堡 脱脂","627719",area1);
//        JDProduct jdProduct22 = new JDProduct("欧德堡 全脂","627718",area1);
//        JDProduct jdProduct33 = new JDProduct("欧德堡 部分脱脂","627718",area1);
//        JDProduct jdProduct44 = new JDProduct("欧德堡 小包装","1385736",area1);
//
//        JDProduct jdProduct111 = new JDProduct("欧德堡 脱脂","627719",area2);
//        JDProduct jdProduct222 = new JDProduct("欧德堡 全脂","627718",area2);
//        JDProduct jdProduct333 = new JDProduct("欧德堡 部分脱脂","627718",area2);
//        JDProduct jdProduct444 = new JDProduct("欧德堡 小包装","1385736",area2);
//        jdProductService.save(jdProduct1) ;
//        jdProductService.save(jdProduct2) ;
//        jdProductService.save(jdProduct3)  ;
//        jdProductService.save(jdProduct4)  ;
//        jdProductService.save(jdProduct11)  ;
//        jdProductService.save(jdProduct22)   ;
//        jdProductService.save(jdProduct33)    ;
//        jdProductService.save(jdProduct44)     ;
//        jdProductService.save(jdProduct111)     ;
//        jdProductService.save(jdProduct222)      ;
//        jdProductService.save(jdProduct333)       ;
//        jdProductService.save(jdProduct444)        ;
//
//
//        List<JDProduct> products =  jdProductService.getList();
//        SendMailService productPrice = (SendMailService)act.getBean("sendMailServiceImpl");
//        try {
//            productPrice.sendJDInfo(products);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
