/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Roledene
 */
public class QueryDB {
    public static final String SQL_STATEMENT = "select * from users";
    public static void main(String[] args) throws SQLException{
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(resultSetMetaData.getColumnName(i)+" | ");
        }
        while(resultSet.next()){
            System.out.println("");
            for (int i = 1; i <= columnCount; i++) {
            System.out.print(resultSet.getString(i)+" | ");
        }
        }
        if(statement != null) statement.close();
        if(connection != null) connection.close();
    }
    
}
