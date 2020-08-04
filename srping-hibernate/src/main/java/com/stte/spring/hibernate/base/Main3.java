package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Sort;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 测试Hibernate的级联删除 cascade="delete"
 * create by BloodFly at 2020/7/28
 */
public class Main3 {

    public static void main(String[] args) {
        Session session = HibernateSessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //查询id为29的商品分类记录
            Sort sort = session.get(Sort.class, 29);
            //删除id为29的商品分类记录，所属该分类的商品也为被删除
            session.delete(sort);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
}
