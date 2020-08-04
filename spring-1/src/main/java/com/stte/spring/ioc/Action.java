package com.stte.spring.ioc;

/**
 * create by BloodFly at 2020/6/7
 */
public class Action {

    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    @Override
    public String toString() {
        return "Action{" +
                "service=" + service +
                '}';
    }
}
