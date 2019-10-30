package com.jdbc;import java.sql.*;
public class TestConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/jdbc";
    private static final String USER = "jjf";
    private static final String PSWD = "mysqlroot";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER); //注册驱动程序
            /*Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);*/

            System.out.println("Connecting to database....");
            connection = DriverManager.getConnection(DB_URL, USER, PSWD);

            //执行查询
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            String sql = "SELECT id, name, age FROM student";

            statement.executeUpdate("insert into student value (null, '陈溢',21)");
            ResultSet rs = statement.executeQuery(sql);





            while(rs.next()){
                //检索
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");

                //显示
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", Name: " + name);
                System.out.println();
            }
            //清理环境
            rs.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFondException!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connecting had Exception");
            e.printStackTrace();
        }finally{
            //这里一般用来关闭资源的
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
                System.out.println("close had Exception in Statement");
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                System.out.println("close had Exception in Connection");
            }
        }
        System.out.println("Goodbye!");
    }
}
