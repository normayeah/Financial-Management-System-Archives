package com.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented //@Documented:注解类型信息也会在生成文档里
public @interface IgnoreAuth {

}
