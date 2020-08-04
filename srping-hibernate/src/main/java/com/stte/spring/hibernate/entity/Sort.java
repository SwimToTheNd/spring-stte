package com.stte.spring.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 商品分类类
 * <p>
 * create by BloodFly at 2020/7/28
 */
public class Sort {

    private Integer sid;
    private String sname;
    private String smessage;

    // 一个商品分类对应多种商品 one to many
    private Set<Goods> goodsSet;

    public Sort() {
        goodsSet = new HashSet<>();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSmessage() {
        return smessage;
    }

    public void setSmessage(String smessage) {
        this.smessage = smessage;
    }

    public Set<Goods> getGoodsSet() {
        return goodsSet;
    }

    public void setGoodsSet(Set<Goods> goodsSet) {
        this.goodsSet = goodsSet;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", smessage='" + smessage + '\'' +
                ", goodsSet=" + goodsSet +
                '}';
    }
}
