package com.springAOP.afterThrow;import org.springframework.aop.ThrowsAdvice;

public class MiAfterThrow implements ThrowsAdvice {

    public void otherException(ClassNotFoundException e) throws Throwable{
        System.out.println("OtherException happened");

    }

    /*通过映射定位这个方法，所以，方法名一定不能改变*/
    public void afterThrowing(ClassNotFoundException e) throws Throwable {
        System.out.println("IOException happened!");
    }


}
