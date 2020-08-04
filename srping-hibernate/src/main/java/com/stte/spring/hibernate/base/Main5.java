package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import com.stte.spring.hibernate.entity.Sort;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 测试级联保存 cascade="save-update"
 * create by BloodFly at 2020/6/27
 */
public class Main5 {


    public static void main(String[] args) {
        Session session = HibernateSessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //创建两个商品
            Goods good1 = new Goods();
            good1.setGname("蛋糕123");
            good1.setGmessage("奶油蛋糕123");
            Goods good2 = new Goods();
            good2.setGname("牙膏456");
            good2.setGmessage("冷酸灵牙膏456");
            Goods good3 = new Goods();
            good3.setGname("面包789");
            good3.setGmessage("好利来面包789");

            //创建两个类别
            Sort sort1 = new Sort();
            sort1.setSname("食品223");
            sort1.setSmessage("食品类223");
            Sort sort2 = new Sort();
            sort2.setSname("生活用品332");
            sort2.setSmessage("生活用品类332");

            // 将商品放到类别中
            sort1.getGoodsSet().add(good1);
            sort1.getGoodsSet().add(good3);
            sort2.getGoodsSet().add(good2);
            //置到商品所属类别
            good1.setSort(sort1);
            good2.setSort(sort2);
            good3.setSort(sort1);
            // 只保存商品分类，商品分类包含的多个商品也会被保存
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
