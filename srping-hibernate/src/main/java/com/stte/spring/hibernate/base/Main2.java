package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import com.stte.spring.hibernate.entity.Sort;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 测试Hibernate的一对多，多对一
 * create by BloodFly at 2020/7/28
 */
public class Main2 {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //创建两个商品
            Goods good1 = new Goods();
            good1.setGname("蛋糕");
            good1.setGmessage("奶油蛋糕");
            Goods good2 = new Goods();
            good2.setGname("牙膏");
            good2.setGmessage("冷酸灵牙膏");
            Goods good3 = new Goods();
            good3.setGname("面包");
            good3.setGmessage("好利来面包");

            //创建两个类别
            Sort sort1 = new Sort();
            sort1.setSname("食品");
            sort1.setSmessage("食品类");
            Sort sort2 = new Sort();
            sort2.setSname("生活用品");
            sort2.setSmessage("生活用品类");

            // 将商品放到类别中
            sort1.getGoodsSet().add(good1);
            sort1.getGoodsSet().add(good3);
            sort2.getGoodsSet().add(good2);
            //将类别设置到商品中
            good1.setSort(sort1);
            good2.setSort(sort2);
            good3.setSort(sort1);
            //保存类别 保存商品
            session.save(good1);
            session.save(good2);
            session.save(good3);
            session.save(sort1);
            session.save(sort2);
            //提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        System.exit(1);
    }


}


