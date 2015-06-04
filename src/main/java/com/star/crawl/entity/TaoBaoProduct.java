package com.star.crawl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-06-04
 * Time: 18:07
 * function:
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class TaoBaoProduct extends BaseDomain {
    @Column
    private Long numIid;
}
