package com.example.aspectSpring.advise;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingsDecoratorAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.printf("preInvoke method %s()\n", invocation.getMethod().getName());
        Object res = invocation.proceed();
        System.out.printf("postInvoke method %s()\n", invocation.getMethod().getName());
        return res;
    }
}
