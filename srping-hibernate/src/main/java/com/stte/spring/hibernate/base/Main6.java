package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import com.stte.spring.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 测试多对多
 * create by BloodFly at 2020/7/28
 */
public class Main6 {

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.openSession();
            tx = session.beginTransaction();
            //创建两个商品

            Goods goods1 = new Goods();
            goods1.setGmessage("奶油蛋糕");

            Goods goods2 =new Goods();
            goods2.setGname("牙膏");
            goods2.setGmessage("冷酸灵牙膏");
            //创建三个订单
            Order order1 = new Order();
            order1.setOname("订单1");
            order1.setOmessage("001111");

            Order order2 = new Order();
            order2.setOname("订单2");
            order2.setOmessage("002222");

            Order order3 = new Order();
            order3.setOname("订单3");
            order3.setOmessage("003333");

            //建立关系，设置商品所属的订单
            goods1.getOrderSet().add(order1);
            goods1.getOrderSet().add(order2);

            goods2.getOrderSet().add(order2);
            goods2.getOrderSet().add(order3);
            //保存商品,会级联保存订单1，订单2
            session.save(goods1);
            session.save(goods2);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }
}
