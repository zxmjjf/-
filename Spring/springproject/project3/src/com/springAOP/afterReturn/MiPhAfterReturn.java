package com.springAOP.afterReturn;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MiPhAfterReturn implements AfterReturningAdvice {
    /*私有域*/
    private String say;

    /*setter 方法*/
    public void setSay(String say) {
        this.say = say;
    }


    /**
     * @param o 原方法返回值
     * @param method 原方法
     * @param objects 原方法参数列别
     * @param o1 方法所在的对象引用
     * @throws Throwable 可能抛出的异常
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if (say == null) {
            System.out.println("小米手机: AfterRun\t" + o1);
        }
    }
}
