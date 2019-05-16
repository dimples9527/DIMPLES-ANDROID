package com.dimples.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 自定义注解
 * 处理MVP架构中的EmptyView
 *
 * @author zhongyj
 * @date 2019/5/15
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface MvpEmptyViewFactory {
}




















