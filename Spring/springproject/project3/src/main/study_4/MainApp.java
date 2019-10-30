package main.study_4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //beanConfigure(); //要使用这个方法，必修去掉Student中的@Requried注解
        //commonly();
        requiredConfigure();
    }

    /*使用一般的方法创建对象*/
    public static void commonly() {
        /*student default value*/
        Student student1 = new Student();

        /*student zxm */
        Date zxmBirth = new Date(1997, 10, 15);
        Student student2 = new Student(new Person("zxm", 22, zxmBirth), "2016045244001", "临床中医");

        /*printWriter student*/
        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }

    /*通过bean配置对象*/
    public static void beanConfigure() {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/study_4/bean-configure.xml");

        Student student = factory.getBean("nonConstructor", Student.class);
        System.out.println(student.toString());

        Person person = factory.getBean("person3", Person.class);
        System.out.println(person.toString());

    }

    /*@Required 注解的使用*/
    public static void requiredConfigure() {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/study_4/Required-annotation.xml");

        Student jjf = factory.getBean("required-person2", Student.class);
        System.out.println(jjf.toString());
        //jjf.getPerson().setName("姜太公");

        jjf = factory.getBean("required-person2", Student.class);
        System.out.println(jjf);

        Student jjf2 = factory.getBean("required-person2", Student.class);
        System.out.println(jjf2.toString());

    }
}
