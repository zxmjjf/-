package main.java.com.sampletest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author jjf
 * @version 2019/10/21 1.0.1
 *
 * <describe>测试：配置内部的bean模块</describe>
 */
public class JiangJianFeng extends Person {
    private Job job;//工作对象，这个域在xml配置文件中需要内部配置
    public JiangJianFeng(Job job) {
        System.out.println("含参构造函数");
        this.job = job;
    }
    public JiangJianFeng(){
        System.out.println("无参构造函数");
    }
    /*public JiangJianFeng(String name, int age, boolean sex) {
        setName(name);
        setAge(age);
        setSex(sex);
    }*/

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return getName() + "\t" + getAge() + "\t" + getSex() + "\t" + job.toString();
    }

    public static void main(String[] args) {
        //test1();
        test2();

    }

    /**
     * <describe>测试用三种不同的方式构造内部的bean：xml文件如下</decribe>
     * <file1>makebean-method1.xml</file1>
     * <file2>makebean-method2.xml</file2>
     * <file3>makebean-method3.xml</file3>
     */
    public static void test1() {
        System.out.println("************* In test1() method ************");
        ApplicationContext context = new ClassPathXmlApplicationContext("main/java/com/sampletest/makebean-method1.xml");
        JiangJianFeng jiangJianFeng = context.getBean("bean1", JiangJianFeng.class);
        System.out.println(jiangJianFeng.toString());

        context = new ClassPathXmlApplicationContext("main/java/com/sampletest/makebean-method2.xml");
        jiangJianFeng = context.getBean("bean1", JiangJianFeng.class);
        System.out.println(jiangJianFeng.toString());
        context = new ClassPathXmlApplicationContext("main/java/com/sampletest/makebean-method3.xml");
        jiangJianFeng = context.getBean("bean1", JiangJianFeng.class);
        System.out.println(jiangJianFeng.toString());
    }


    /**
     * <descirbe>多种不同的方式使用 IoC</descirbe>
     */
    public static void test2() {
        System.out.println("************* In test2() method ************");

        /*method 1*/
        /*File file = new File("src/main/java/com/sampletest/makebean-method1.xml");
        Resource resource = new FileSystemResource(file);*/
        System.out.println("method1: ");
        Resource resource = new ClassPathResource("main/java/com/sampletest/makebean-method1.xml");//注意对比上面的路径
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        JiangJianFeng jiangJianFeng = beanFactory.getBean("bean1", JiangJianFeng.class);
        System.out.println(jiangJianFeng.toString());

        /*method 2*/
        System.out.println("\nmethod2: ");
        BeanFactory beanFactory1 = new ClassPathXmlApplicationContext("main/java/com/sampletest/makebean-method1.xml");
        jiangJianFeng = beanFactory1.getBean("bean1", JiangJianFeng.class);
        System.out.println(jiangJianFeng.toString());

        /*method 3*/
        System.out.println("\nmethod3: ");
        BeanFactory beanFactory2 = new FileSystemXmlApplicationContext("src/main/java/com/sampletest/makebean-method1.xml");
        jiangJianFeng = beanFactory1.getBean("bean1", JiangJianFeng.class);
        System.out.println(jiangJianFeng.toString());




    }
}
