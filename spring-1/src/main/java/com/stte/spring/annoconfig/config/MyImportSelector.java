package com.stte.spring.annoconfig.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过实现ImportSelector接口，@Import注解能够将ImportSelector接口返回的Bean定义名称注册到Spring容器
 * create by BloodFly at 2020/7/29
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 返回需要注入到容器类的全类名数组
     * 返回值就是需要导入到容器中的组件的全类名
     * annotationMetadata：是标注了@Import注解的类的所有注解的元信息，能够获得其他注解。
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.stte.spring.annoconfig.Blue", "com.stte.spring.annoconfig.Yellow"};
    }
}
