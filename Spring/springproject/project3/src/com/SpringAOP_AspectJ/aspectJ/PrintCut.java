package com.SpringAOP_AspectJ.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PrintCut {
    @Pointcut("execution(public * com.phone.MiPhones.*(..))")
    public void allMethod() {

    }

    @Pointcut("execution(public * com.phone.Phone.open(..))")
    public void open() {

    }

    @Pointcut("execution(public * com.phone.Phone.close(..))")
    public void close() {

    }

    @Pointcut("execution(public * com.phone.Phone.runProgram(..))")
    public void runProgram() {

    }
}
