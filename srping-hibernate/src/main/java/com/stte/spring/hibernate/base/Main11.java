package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Goods;
import com.stte.spring.hibernate.entity.Sort;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

/**
 * 批量抓取
 */
public class Main11 {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sort.class);
        List<Sort> list = criteria.list();
        for (Sort sort : list) {
            System.out.println("商品分类：" + sort);
            Set<Goods> goodsSet = sort.getGoodsSet();
            for (Goods goods : goodsSet) {
                System.out.println("商品：" + goods);
            }
        }


        System.exit(1);
    }
}
