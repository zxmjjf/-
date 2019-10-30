package com.springAOP.aroundAdvice;import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MiPhAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Around: BeforeMethod");

        Object result =  methodInvocation.proceed();

        System.out.println("Around: AfterReturn");
        return result;

    }
}
