package main.java.com.sampletest;

public abstract class Person {
    private String name;
    private int age;
    private boolean sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        if (sex) {
            return "男";
        } else {
            return "女";
        }
    }
}
