package com.star.crawl.entity;

import javax.persistence.*;

/**
 * Created by star on 15/5/12.
 */
@Entity
@Table(name = "t_jd_product_area")
public class JDProductArea extends BaseDomain{
    @Column
    private String area;
    @Column
    private String description;


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
