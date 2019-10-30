package main.study_4;

import org.springframework.beans.factory.annotation.Required;

public class Student {
    /*私有域*/
    private Person person; //人的属性
    private String studentId; //学生学号
    private String specialized; //专业

    /**********************************************************************/

    /*构造器*/

    /**
     * @param studentId   学生学号
     * @param specialized 专业
     */
    /*@Autowired*/
    public Student(String studentId, String specialized) {
        this.studentId = studentId;
        this.specialized = specialized;
        System.out.println("Student: 2参数构造器");
    }

    public Student(Person person, String studentId, String specialized) {
        this.person = person;
        this.studentId = studentId;
        this.specialized = specialized;
        System.out.println("Student: 3参数构造器");
    }


    public Student() {
        this(new Person("jjf", 22), "2016045244003", "软件工程");
        System.out.println("Student: 0参数构造器");

    }

    /*************************************************************************************/

    /*toSting 方法*/
    @Override
    public String toString() {
        return person.toString() + "\t学号: " + studentId + "\t专业: " + specialized;
    }

    /******************************************************************************************/

    /*setter 方法*/
    @Required
    public void setPerson(Person person) {
        this.person = person;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    /**********************************************************************************/

    /*getter 方法*/
    public Person getPerson() {
        return person;
    }

    public String getSpecialized() {
        return specialized;
    }

    public String getStudentId() {
        return studentId;
    }
}



