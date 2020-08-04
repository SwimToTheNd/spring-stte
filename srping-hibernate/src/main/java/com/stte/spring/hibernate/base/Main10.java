package com.stte.spring.hibernate.base;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;

/**
 * HQL多表查询 使用inner join 或 left outer join
 * create by BloodFly at 2020/7/28
 */
public class Main10 {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.openSession();
        // 使用HQL语句进行内连接查询。 s.goodSet为商品分类表对应一对多的商品集合引用
        // 内连接使用 from 实体类 实体类别名 inner join 实体类别名.关联实体集合
        Query query = session.createQuery("from Sort s inner join s.goodsSet");
        List list = query.list();
        //结果使用数组封装
        for (Object o : list) {
            Object[] objects = (Object[]) o;
            System.out.println(Arrays.toString(objects));
        }


        // 迫切内连接，返回的数据以对象封装
        System.out.println("迫切内连接......");
        query = session.createQuery("from Sort s inner join fetch s.goodsSet");
        List result = query.list();
        for (Object o : result) {
            System.out.println(o);
        }

        // 外连接 from 实体类名 实体类别名 left outer join 实体类别.关联的其他实体集合
        System.out.println("外连接......");
        query = session.createQuery("from Sort s left outer join s.goodsSet");
        List list1 = query.list();
        for (Object o : list1) {
            Object[] objects = (Object[]) o;
            System.out.println(Arrays.toString(objects));
        }

        //迫切外连接 from 实体类名 实体类别名 left outer join fetch 实体类别.关联的其他实体集合
        System.out.println("迫切外连接......");
        query = session.createQuery("from Sort s left outer join fetch s.goodsSet");
        List list2 = query.list();
        System.out.println(list2);


        System.exit(1);
    }
}
