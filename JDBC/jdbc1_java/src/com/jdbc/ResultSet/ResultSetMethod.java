package com.jdbc.ResultSet;

import java.sql.*;

public class ResultSetMethod {
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    /*连接数据库*/
    private static void connection(int[] types) {
        String URL = "jdbc:mysql://localhost/jdbc?serverTimezone=GMT%2B8&useSSL=false";
        String JDBCDriver = "com.mysql.cj.jdbc.Driver";

        /*连接操作*/
        try {
            /*加载数据库驱动程序*/
            Class.forName(JDBCDriver); //加载数据库驱动程序

            /*连接数据库*/
            try {
                connection = DriverManager.getConnection(URL, "jjf", "mysqlroot");
                System.out.println("数据库已连接");
            } catch (SQLException e) {
                System.out.println("数据库连接异常");
                e.printStackTrace();
            }

            /*设置数据库执行器 Statement*/
            try {
                if (types.length == 0) {
                    statement = connection.createStatement();
                    System.out.println("默认Statement");
                } else {
                    System.out.println("非默认Statement：");
                    statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                }
/*删除当前行*/
            } catch (SQLException e) {
                System.out.println("Statement Create Exception");
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBCDriver Exception");
            e.printStackTrace();
        }
    }

    /*数据库查询*/
    private static void selectData() {
        String select = "select * from student";
        try {
            resultSet = statement.executeQuery(select);
            System.out.println("msyql > " + select);
            while (resultSet.next()) {
                System.out.println("+------|-------------------|------+");
                System.out.printf("|%-6s", "  " + resultSet.getInt(1));
                System.out.printf("|%-16s", "  " + resultSet.getString(2));
                System.out.printf("|%-6s", "  " + resultSet.getInt(3));
                System.out.println("|");
            }
            System.out.println("+------|-------------------|------+");

            /*把标签置为第一位*/
            resultSet.first();

        } catch (SQLException e) {
            System.out.println("select * had Exception");
        }

    }

    /*测试ResultSet的游标类型*/
    private static void testRSType() {
        System.out.println("更新数据");
        String update = "update student set id = 10, name = '陈万锦' where id = 15";
        try {
            statement.executeUpdate(update);
            System.out.println("更新完成");
        } catch (SQLException e) {
            System.out.println("数据未更新！");
        }
        selectData();
    }

    /*测试ResultSet的结果集更新状态*/
    private static void testRSConcurrency() {
        try {
            System.out.println("update!!");
            resultSet.next();
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));
            resultSet.moveToInsertRow();
            resultSet.updateString("name", "蓝雁勇");
            resultSet.updateInt("age", 23);
            //resultSet.refreshRow();
            resultSet.insertRow();
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        selectData();
    }

    /*移动结果集的光标*/
    private static void testMoveCursor() {
        System.out.println("Move Cursor Test");
        try {
            System.out.println("当前行数： " + resultSet.getRow());
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));
            System.out.println("进入下一行：next()");
            resultSet.next();
            System.out.println("当前行数： " + resultSet.getRow());

            resultSet.previous(); //返回到上一行
            System.out.println("返回到上一行: previous()");
            System.out.println("当后行数： " + resultSet.getRow());
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));

            /*向后移动五行*/
            System.out.println("向后移动五行：relative(5)");
            resultSet.relative(5);
            System.out.println("当后行数： " + resultSet.getRow());
            /*向前移动三行*/
            System.out.println("向前移动三行");
            resultSet.relative(-3);
            System.out.println("当后行数： " + resultSet.getRow());

            /*移动到特定的行*/
            System.out.println("移动到第3行");
            resultSet.absolute(3);
            System.out.println("当后行数： " + resultSet.getRow());
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));

            /*statement.executeUpdate("update student set name = 'jjf' where id = 3");*/


            //resultSet.moveToInsertRow(); //建立特殊的插入行,插入新的数据；
            resultSet.updateString(2, "胡伟杰_3");
            //resultSet.updateInt(1, 8);
            resultSet.updateInt(3, 23);
            resultSet.cancelRowUpdates();
            resultSet.updateRow();
            //resultSet.insertRow();
            //resultSet.moveToCurrentRow();
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));

        } catch (SQLException e) {
            System.out.println("操作光标异常");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        connection(new int[]{ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE});
        selectData();

        //testRSType();
        //testRSConcurrency();
        testMoveCursor();


        /*关闭数据库资源*/
        try {
            resultSet.close();
            statement.cancel();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
