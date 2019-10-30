package com.Spring_JDBC.jdbcJava;

import com.Spring_JDBC.student.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class JDBCOperator {
    public static void main(String[] args) {
        //insertData();
        //deleteData();
        //updateData();
        selectData();
    }

    private static void insertData() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/Spring_JDBC/jdbc_configure/JDBC_Configure.xml");
        JdbcTemplate jdbcTemplate = factory.getBean("jdbcTemplate", JdbcTemplate.class);
        String sqlInsert = "insert into student values(null ,'jjf',22)";
        int count = jdbcTemplate.update(sqlInsert);
        System.out.println(count);
    }

    private static void deleteData() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/Spring_JDBC/jdbc_configure/JDBC_Configure.xml");
        JdbcTemplate jdbcTemplate = factory.getBean("jdbcTemplate", JdbcTemplate.class);
        String sqlDelete = "delete from student where id > 3";
        System.out.println(jdbcTemplate.update(sqlDelete));
    }

    private static void updateData() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/Spring_JDBC/jdbc_configure/JDBC_Configure.xml");
        JdbcTemplate jdbcTemplate = factory.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println(jdbcTemplate.update("update student set " + "name='jjf' where  id = 1"));

    }

    private static void selectData() {
        BeanFactory factory = new ClassPathXmlApplicationContext("com/Spring_JDBC/jdbc_configure/JDBC_Configure.xml");
        JdbcTemplate template = factory.getBean("jdbcTemplate", JdbcTemplate.class);

        RowMapper<Student> mapper = new BeanPropertyRowMapper<>(Student.class);
        List<Student> student = template.query("select * from student", mapper);

        for (Student stu : student) {
            System.out.println(stu);
        }
        /*根据数据库中的字段名称找到匹配Student类中匹配的setter方法*/
    }



}
