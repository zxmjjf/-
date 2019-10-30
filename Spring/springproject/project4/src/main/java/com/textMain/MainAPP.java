package main.java.com.textMain;

import main.java.com.sayhello.SayHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPP {
    public static void main(String[] args) {
        /*使用 Spring 框架*/
        /* 1.建立AOP切面*/
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");
        SayHello hello = context.getBean("hello1", SayHello.class);// 2.通过Spring捕获对象
        hello.sayHello(); //3.表达对象

        /*不使用Spring 框架*/
        SayHello hello1 = new SayHello(); //1. 建立对象
        hello1.sayHello();//2. 表达对象

    }
}
