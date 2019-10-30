package com.SpringAOP_AspectJ.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class PhoneAspectJ {
    //@Before("execution(public * com.phone.Phone.runProgram(String))")

    @Before("com.SpringAOP_AspectJ.aspectJ.PrintCut.runProgram()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("\nAspectJ--BeforeMethodAdvice");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    //@Before("execution(public * com.phone.Phone.close())")
    @Before("com.SpringAOP_AspectJ.aspectJ.PrintCut.close()")
    public void log1Before() {
        System.out.println("Bey...");
    }

    @AfterReturning(value = "com.SpringAOP_AspectJ.aspectJ.PrintCut.runProgram()", returning = "result")
    public void logAfter(JoinPoint joinPoint, String[] result) throws Throwable {
        System.out.println("After：" + Arrays.toString(result));
    }

    @Around(value = "com.SpringAOP_AspectJ.aspectJ.PrintCut.runProgram()")
    public String[] logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around:");
        String[] strings = new String[]{"jjf1", "jj2"};
        joinPoint.proceed();
        joinPoint.proceed(new String[]{"微信"});
        return strings;
    }

    @AfterThrowing(value = "execution(public * com.phone.Phone.throwException(..))", throwing = "mythrow")
    public void afterThrow(JoinPoint joinPoint, ClassNotFoundException mythrow) {
        System.out.println("afterThrow:" + joinPoint.getSignature().getName());
    }
}