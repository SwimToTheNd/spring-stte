package com.stte.spring.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 订单表
 * create by BloodFly at 2020/7/28
 */
public class Order {

    private Integer oid;
    private String oname;
    private String omessage;

    //一个订单里面可以有多个商品
    //在多对多关系中，在多的那一方，必须要有一个set集合属性来保存一个那个实体并提供共有的getter和setter方法。
    private Set<Goods> goodsSet;

    public Order() {
        goodsSet = new HashSet<>();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOmessage() {
        return omessage;
    }

    public void setOmessage(String omessage) {
        this.omessage = omessage;
    }

    public Set<Goods> getGoodsSet() {
        return goodsSet;
    }

    public void setGoodsSet(Set<Goods> goodsSet) {
        this.goodsSet = goodsSet;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", omessage='" + omessage + '\'' +
                ", goodsSet=" + goodsSet +
                '}';
    }
}
