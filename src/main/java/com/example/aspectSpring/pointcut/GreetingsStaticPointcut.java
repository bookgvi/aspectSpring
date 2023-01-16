package com.example.aspectSpring.pointcut;

import com.example.aspectSpring.domain.GreetingsImpl;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class GreetingsStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().contains("sayHello") || method.getName().contains("getMsg");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {

            @Override
            public boolean matches(Class<?> clazz) {
                boolean res = clazz == GreetingsImpl.class;
                return res;
            }
        };
    }
}
