package com.stte.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 子类之间的依赖关系，由其父类的泛型以及父类之间的依赖关系确定，父类的泛型为必须同一类型，
 * 即在父类中建立的依赖关系，在子类继承父类时，传入同一泛型类型的成员变量，然后子类就可以继承父类的之间的依赖关系。
 *
 * create by BloodFly at 2020/6/25
 */
public class BaseService<T> {

    @Autowired
    private BaseRepository<T> repository;

    public void save(T t) {
        repository.save(t);
    }
}
