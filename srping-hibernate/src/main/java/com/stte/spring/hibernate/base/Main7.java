package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 测试多对多
 * create by BloodFly at 2020/7/28
 */
public class Main7 {

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.openSession();
            tx = session.beginTransaction();
            //获取id为60的商品
            Goods goods = session.get(Goods.class, 60);
            //删除id为60的商品，级联删除hb_order_goods关系表
            session.delete(goods);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }
}
