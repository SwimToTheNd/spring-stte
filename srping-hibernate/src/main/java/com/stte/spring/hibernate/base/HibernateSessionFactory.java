package com.stte.spring.hibernate.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 1. 使用Configuration加载hibernate.cfg.xm配置文件
 * 2. 使用Configuration构建SessionFactory
 * 3. 使用SessionFactory构建Session
 *
 * create by BloodFly at 2020/6/27
 */
public class HibernateSessionFactory {

    private static String configFile = "/hibernate.cfg.xml";

    // hibernate配置类
    private static Configuration configuration = new Configuration();

    private static SessionFactory sessionFactory;

    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

    static {
        try {
            // 装入配置文件
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e){
            System.err.println("%%% Error creating SessionFactory! %%%");
            e.printStackTrace();
        }

    }

    /**
     * 获得Session
     * @return
     */
    public static Session openSession() {
        Session session = sessionThreadLocal.get();
        // ThreadLocal没有当前线程的Session或者session没有打开，则新建一个Session
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = sessionFactory != null ? sessionFactory.openSession() : null;
            sessionThreadLocal.set(session);
        }
        return session;
    }

    /**
     * 重新构建SessionFactory
     */
    private static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("%%% Error Rebuild SessionFactory! %%%");
            e.printStackTrace();
        }
    }

    /**
     * 关闭Session
     */
    public static void closeSession(){
        Session session = sessionThreadLocal.get();
        sessionThreadLocal.remove();
        if (session != null) {
            session.close();
        }
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
