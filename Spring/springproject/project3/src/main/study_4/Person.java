package main.study_4;

import org.springframework.context.annotation.Bean;

public class Person {
    /*私有 域*/
    private String name; //姓名
    private int age; //年龄
    private Date date;
    /******************************************************************************/

    /*构造器*/
    public Person(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
        System.out.println("Person: 3参数构造器");

    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.date = new Date(1997, 7, 16);
        System.out.println("Person: 2参数构造器");

    }

    public Person() {
        this("姜剑锋", 22);
        System.out.println("Person: 0参数构造器");
    }
    /******************************************************************************/

    /*toString*/
    @Override
    public String toString() {
        return "Name: " + name + "\tAges: " + age + "\tBirth: " + date;
    }
    /******************************************************************************/

    /*setter 方法*/
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    /******************************************************************************/

    /*getter 方法*/
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDate() {
        return date;
    }
}

