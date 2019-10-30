package com.springAOP.beforeRun;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;
import java.util.Objects;

public class MiPhBeforeRun implements MethodBeforeAdvice {
    /*私有域*/
    String say;
    //**********************************************************************
    /*setter 方法*/
    public void setSay(String say) {
        this.say = say;
    }
    //**********************************************************************
    /*继承*/
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(Objects.requireNonNullElse(say , "小米手机:BeforeRun"));
    }
}
