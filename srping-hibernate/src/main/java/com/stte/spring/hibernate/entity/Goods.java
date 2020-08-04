package com.stte.spring.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 商品类
 * <p>
 * create by BloodFly at 2020/7/28
 */
public class Goods {

    private Integer gid;
    private String gname;
    private String gmessage;

    // 一个商品对应一个商品分类
    private Sort sort;

    //一个商品可以属于多个订单
    //在多对多关系中，在多的那一方，必须要有一个set集合属性来保存一个那个实体并提供共有的getter和setter方法。
    private Set<Order> orderSet;

    public Goods() {
        orderSet = new HashSet<>();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGmessage() {
        return gmessage;
    }

    public void setGmessage(String gmessage) {
        this.gmessage = gmessage;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gmessage='" + gmessage + '\'' +
//                ", sort=" + sort +
                ", orderSet=" + orderSet +
                '}';
    }
}
