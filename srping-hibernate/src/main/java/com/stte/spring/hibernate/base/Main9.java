package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * 查询QBC查询，使用Criteria对象查询
 * create by BloodFly at 2020/7/28
 */
public class Main9 {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.openSession();

        // 使用Criteria对象查询，指明要查询的实体类的名称，查询实体对应表的所有记录
        Criteria criteria = session.createCriteria(Goods.class);
        System.out.println(criteria.list());

        //Criteria对象的条件查询,，使用Criteria的add方法添加条件，Restrictions设置约束、限制
        criteria = session.createCriteria(Goods.class);
        criteria.add(Restrictions.eq("gname", "蛋糕"));
        System.out.println(criteria.list());

        //Criteria对象使用Restriction进行模糊查询
        criteria = session.createCriteria(Goods.class);
        criteria.add(Restrictions.like("gname", "%面%"));
        System.out.println(criteria.list());

        //Criteria对象的addOrder方法,结合Order类进行排序
        criteria = session.createCriteria(Goods.class);
        criteria.addOrder(Order.desc("gid"));
        System.out.println(criteria.list());

        //Criteria对象通过设置setFirstResult和setMaxResults进行分页查询
        criteria = session.createCriteria(Goods.class);
        //从第几条记录开始查询，查询第二2页，即从 (页码-1)*每页记录数 开始查询
        criteria.setFirstResult((2 - 1) * 2);
        //每页最大记录数
        criteria.setMaxResults(2);
        System.out.println(criteria.list());

        //Criteria使用setProjection进行投影查询
        // 聚集函数函数查询，使用Projections
        criteria = session.createCriteria(Goods.class);
        criteria.setProjection(Projections.rowCount());
        System.out.println("一共有商品记录数: " + criteria.uniqueResult());

        //离线查询
        //创建DetachedCriteria对象，指定要查询的实体
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Goods.class);
        //获取Criteria对象，最终执行时用到Session
        criteria = detachedCriteria.getExecutableCriteria(session);
        criteria.setProjection(Projections.max("gid"));
        System.out.println("最大gid: " + criteria.uniqueResult());

        System.exit(1);
    }
}
