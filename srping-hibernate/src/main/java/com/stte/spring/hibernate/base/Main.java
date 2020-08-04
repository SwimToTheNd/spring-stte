package com.stte.spring.hibernate.base;

import com.stte.spring.hibernate.entity.Account;
import com.stte.spring.hibernate.entity.Book;
import com.stte.spring.hibernate.entity.BookStock;
import org.hibernate.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * create by BloodFly at 2020/6/27
 */
public class Main {


    public static void main(String[] args) {
        Account account = new Account();
        account.setUserName("卢俊义");
        account.setBalance(new BigDecimal("9988"));
        Session session = HibernateSessionFactory.openSession();
        //使用SesssionFactory.getCurrentSessoin方法获取线程私有的Session（从ThreadLocal中获取）
//        Session currentSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // save 新增
            session.save(account); //更新后，会给Account对象设置自增的id值
            System.out.println("after save has got id: " + account.getId());

            // update 修改需要指定所有的字段进行修改,通过id查询
            // update account set user_name=?, balance=? where id=?
            account.setBalance(new BigDecimal("29988"));
            session.update(account);


            // 通过session.get(class,id)查询
            Account result = session.get(Account.class, account.getId());
            System.out.println("get result：" + result);

            // 删除 delete from account where id=?
            session.delete(account);

            // SQL Query 使用session的crateSQLQuery获得SQLQuery对象，使用SQLQuery的list方法获取结果数据集合
            SQLQuery query = session.createSQLQuery("select * from account"); //使用SQL查询需要指定接收的POJO的类型
            query.addEntity(Account.class);
            List<Account> resultList = query.list();
            System.out.println(resultList);

            // HQL
            Query fromAccount = session.createQuery("from Book"); //使用HQL直接获得查询结果 HQL Book为类，首字母大写
            List<Book> list = fromAccount.list();
            System.out.println(list);
            //使用 criteria 条件查询
            Criteria criteria = session.createCriteria(BookStock.class);
            List<BookStock> stockList = criteria.list();
            System.out.println(stockList);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }

    }
}
