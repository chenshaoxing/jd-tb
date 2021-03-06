package com.star.crawl.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created with Intellij IDEA
 * User: star
 * Date: 2015-05-19
 * Time: 17:00
 * function:
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_user")
public class User extends BaseDomain{

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TaoBaoProduct> taoBaoProducts;

    public Set<TaoBaoProduct> getTaoBaoProducts() {
        return taoBaoProducts;
    }

    public void setTaoBaoProducts(Set<TaoBaoProduct> taoBaoProducts) {
        this.taoBaoProducts = taoBaoProducts;
    }

    @Column
    private String nickname;
    @Column
    private String sessionKey;
    @Column
    private String email;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Column
    private String refreshToken;



    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date overDate;

    public Date getSessionKeyOverDate() {
        return sessionKeyOverDate;
    }

    public void setSessionKeyOverDate(Date sessionKeyOverDate) {
        this.sessionKeyOverDate = sessionKeyOverDate;
    }

    @Transient
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionKeyOverDate;

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
