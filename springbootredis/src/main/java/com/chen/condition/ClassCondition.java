package com.chen.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 陈宇超
 * 22:57
 */
public class ClassCondition implements Condition {
    //通过boolean返回值，就能确定是否生成bean对象
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
