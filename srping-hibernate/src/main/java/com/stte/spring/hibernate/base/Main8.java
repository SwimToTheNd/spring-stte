package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import com.stte.spring.hibernate.entity.Sort;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

/**
 * 查询
 * create by BloodFly at 2020/7/28
 */
public class Main8 {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.openSession();
        // 通过OID查询，商品分类
        Sort sort = session.get(Sort.class, 37);
        System.out.println("还没有查询商品分类下的所有商品....");
        // 通过对象导航的方式查询
        Set<Goods> goodsSet = sort.getGoodsSet();
        for (Goods goods : goodsSet) {
            System.out.println(goods);
        }

        //HQL查询 Hibernate Query Language，需要编写HQL语句
        Query queryGoods = session.createQuery("from Goods");
        List list = queryGoods.list();
        System.out.println(list);


        //HQL 条件查询，条件查询分为准确查询和模糊查询
        //from 实体类名 where 实体属性名1 = ? and 实体属性名2 = ?
        Query query = session.createQuery("from Goods where gname=? and gmessage=?");
        query.setParameter(0, "蛋糕");
        query.setParameter(1, "奶油蛋糕");
        List list1 = query.list();
        System.out.println(list1);

        //HQL模糊查询 from 实体类名 where 实体类属性名 like ?
        query = session.createQuery("from Goods where gname like ?");
        query.setParameter(0, "%蛋%");
        System.out.println(query.list());

        //HQL排序 from 实体类名 order by 实体类属性名 asc/desc
        query = session.createQuery("from Goods order by gname desc");
        System.out.println(query.list());

        //HQL分页查询 设置Query对象的firstResult和maxResults来进行分页
        query = session.createQuery("from Goods");
        //页启始位置，从第几条记录开始查询，(当前页数-1)*每页记录数
        query.setFirstResult(0);
        //每页记录数
        query.setMaxResults(2);
        System.out.println(query.list());

        //HQL查询 查询表中的部分字段，而不是所有字段
        query = session.createQuery("select gname from Goods");
        System.out.println(query.list());

        //HQL的聚集函数查询 常用聚集函数：count avg max min sum
        query = session.createQuery("select count(*) from Goods");
        System.out.println(query.uniqueResult());


        System.exit(1);
    }
}
