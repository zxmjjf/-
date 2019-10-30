package com.SpringAOP_AspectJ.aspectJ;

import com.phone.Phone;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class TestAspectJ {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/SpringAOP_AspectJ/aspectJ/AspectJ-Auto.xml");
        Phone phone = factory.getBean("mi_Phones", Phone.class);
        phone.open();
        System.out.println(phone.toString());
        phone.runProgram("QQ");
        phone.close();
        try {
            phone.throwException();
        } catch (FileNotFoundException e) {

        }
    }
}
