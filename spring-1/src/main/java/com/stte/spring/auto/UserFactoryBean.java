package com.stte.spring.auto;

import com.stte.spring.ioc.Car;
import com.stte.spring.ioc.User;
import org.springframework.beans.factory.FactoryBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Spring 中有两种类型的 Bean, 一种是普通Bean, 另一种是工厂Bean, 即FactoryBean.
 * 工厂 Bean 跟普通Bean不同, 其返回的对象不是指定类的一个实例, 其返回的是该工厂 Bean 的 getObject 方法所返回的对象
 * create by BloodFly at 2020/6/24
 */
public class UserFactoryBean implements FactoryBean<User> {
    public User getObject() throws Exception {
        User user = new User();
        user.setName("吴亦凡");
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("东风雪铁龙1", "长春汽车1", 9928.28, 66));
        cars.add(new Car("东风雪铁龙2", "长春汽车2", 8928.28, 76));
        user.setCars(cars);

        Set<String> hobbies = new HashSet<String>();
        hobbies.add("大碗");
        hobbies.add("宽面");
        hobbies.add("skr");
        user.setHobby(hobbies);

        return user;
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
