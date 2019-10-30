package JDBC.Spring_JDBC.student;

public class Student {

    private String name;

    private int age;
    private int id;
    /*setter*/
    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" + id + "\t" + name + "\t\t" + age + "}";
    }
}

