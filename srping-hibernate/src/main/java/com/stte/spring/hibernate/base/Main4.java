package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import com.stte.spring.hibernate.entity.Sort;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 测试Hibernate级联更新
 * create by BloodFly at 2020/7/28
 */
public class Main4 {

    public static void main(String[] args) {
        Session session = HibernateSessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // 获得id为35的商品分类
            Sort sort = session.get(Sort.class, 36);
            // 获取id为51的商品分类，属性于商品分类35
            Goods goods = session.get(Goods.class, 51);
            System.out.println("还没有加载商品分类的所有商品信息，调用getGoodSet时会延迟加载......");
            //将商品51的加入到时商品分类36中，保存商品分类时将自动更新商品所属的商品分类
            sort.getGoodsSet().add(goods);
            //设置商品51的所属分类
            goods.setSort(sort);
            //只保存商品分类，但分级联更新商品表
            session.save(sort);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        System.exit(1);
    }
}
