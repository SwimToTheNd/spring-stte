package com.stte.spring.ioc;

/**
 * create by BloodFly at 2020/6/7
 */
public class Service {

    private Dao dao;

    @Override
    public String toString() {
        return "Service{" +
                "dao=" + dao +
                '}';
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

}
