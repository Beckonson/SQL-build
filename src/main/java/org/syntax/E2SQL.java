package org.syntax;

import java.sql.*;

public class E2SQL {
    public static void main(String[] args) throws SQLException {

        String dbUrl="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        //create the connection between java and database
        Connection connection=DriverManager.getConnection(dbUrl,userName,password);
        //take our queries execute them and  brings the result back
        Statement statement=connection.createStatement();
        String query= "select * from person";
        ResultSet rs =statement.executeQuery(query);
        // This object gives us info about the data that is being returned  by the query
        ResultSetMetaData rsm = rs.getMetaData();
        System.out.println(rsm.getColumnCount());
        for (int i=1;i<= rsm.getColumnCount(); i++){
            System.out.println(rsm.getColumnName(i)+" ");
        }
        System.out.println();
        while (rs.next()){

            for (int i=1;i<= rsm.getColumnCount(); i++){
                System.out.print(rs.getString(i)+" ");

            }
            System.out.println();
        }
    }
}