package com.annotation; //放自定义注解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录用户信息
 */
@Target(ElementType.PARAMETER) //@Target(取值.用于描述参数):说明annotation（自定义注解修饰范围）;
@Retention(RetentionPolicy.RUNTIME) //注解保留到何处 RetentionPolicy.RUNTIME:保存在class文件中，class加载后也会保留
public @interface APPLoginUser {
//@interface：自定义注解
}
