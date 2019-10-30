package com.springAOP;

import com.phone.Phone;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class Mi8Test {
    public static void main(String[] args) {
        {
            /* No_pointCut*/
            //beforeMethod();
            //afterMethod();
            //afterThrow();
            //aroundMethod();
        }
        {
            /*Had_pointCut*/
            //pCBeforeMethod();
            autoProxy();
        }
    }

    public static void beforeMethod() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/springAOP/Phone-proxy.xml");

        /*MiPhones.class*//*
        System.out.println("class:");
        MiPhones mi8 = factory.getBean("mi8_MiPhones", MiPhones.class);
        mi8.open();
        mi8.runProgram("微信");
        mi8.close();
*/
        /*Phone.interface*/
        System.out.println("\n\ninterface:");
        Phone phone1 = factory.getBean("proxy_mi_BeforeRun", Phone.class);
        phone1.open();
        /*phone1.runProgram("王者荣耀");
        phone1.close();*/
    }

    public static void afterMethod() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/springAOP/Phone-proxy.xml");

        Phone phone = factory.getBean("proxy_mi_AfterRun", Phone.class);
        phone.open();
        phone.runProgram("QQ");
        phone.close();
    }

    public static void afterThrow() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/springAOP/Phone-proxy.xml");

        Phone phone = factory.getBean("proxy_mi_AfterThrow", Phone.class);
        phone.open();
        phone.runProgram("淘宝");

        try {
            phone.throwException();
        } catch (FileNotFoundException e) {
            System.out.println("手机抛出异常");
        }
    }

    public static void aroundMethod() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/springAOP/Phone-proxy.xml");

        Phone phone = factory.getBean("mi_AroundAdvices", Phone.class);
        phone.open();
    }

    public static void pCBeforeMethod() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/springAOP/Phone-proxy.xml");
        Phone phone = factory.getBean("pCProxy_miBeforeRun", Phone.class);
        phone.open();
        phone.runProgram("Boss招聘");
        phone.close();
    }

    public static void autoProxy() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/springAOP/Phone-Autoproxy.xml");
        Phone phone = factory.getBean("mi8_MiPhones", Phone.class);
        System.out.println("*****小米手机*******");
        phone.open();
        System.out.println(phone.toString());
        phone.runProgram("微信");
        phone.close();

        System.out.println("\n*****华为手机*******");
        phone = factory.getBean("hw_HwPhones", Phone.class);
        phone.open();
        System.out.println(phone.toString());
        phone.runProgram("王者荣耀");
        phone.close();
    }
}
