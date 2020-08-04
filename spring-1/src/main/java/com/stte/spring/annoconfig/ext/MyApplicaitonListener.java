package com.stte.spring.annoconfig.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 使用观察者模式
 * <p>
 * ApplicationListener可以声明它感觉兴趣的事件类型
 * 当通过SpringContexti注册事件，事件会被相应的过滤，通过事件监听器，执行匹配上的事件对象
 * create by BloodFly at 2020/8/4
 */
@Component
public class MyApplicaitonListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("事件监听器收到事件：" + event);
    }
}
