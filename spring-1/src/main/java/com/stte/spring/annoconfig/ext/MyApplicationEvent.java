package com.stte.spring.annoconfig.ext;

import org.springframework.context.ApplicationEvent;

/**
 * create by BloodFly at 2020/8/4
 */
public class MyApplicationEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
