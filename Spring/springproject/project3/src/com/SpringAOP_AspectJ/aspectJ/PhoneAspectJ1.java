package com.SpringAOP_AspectJ.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PhoneAspectJ1 {
    //@Before("execution(public * com.phone.Phone.open())")
    @Before("com.SpringAOP_AspectJ.aspectJ.PrintCut.open()")
    public void towBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + ": 正在为您开机....");
    }
}
