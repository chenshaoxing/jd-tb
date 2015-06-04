package com.star.crawl.entity;

import javax.persistence.*;

/**
 * Created by star on 15/5/7.
 */
@Entity
public class JDProduct extends BaseDomain {
    @Column                //商品最新价格
    private Float price;
    @Column               //商品名称
    private String productName;
    @Column               //商品完整的URL
    private String productUrl;
    @Column               //商品的主图片URL
    private String productPicUrl;
    @Column               //商品的id
    private String skuId;
    @Column              //商品的最新折扣

    public Float getDiscount() {
        return discount;
    } public void setDiscount(Float discount) {
        this.discount = discount;
    } private Float discount;

    public String getCrawlProductInfoUrl() {
        return crawlProductInfoUrl;
    }

    public void setCrawlProductInfoUrl(String crawlProductInfoUrl) {
        this.crawlProductInfoUrl = crawlProductInfoUrl;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column
    private String crawlProductInfoUrl;

}
