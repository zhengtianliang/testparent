package com.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    //操作大类
    String category();
    //操作子类
    String subcategory();
    //操作描述
    String desc();
    //操作类型
    String type() ;


}