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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roledene
 */
public class StudentService {

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    public static ResultSet getAll() throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        return resultSet;
    }

    public static ResultSet getForAdmin() throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select id,module,marks from students");
        return resultSet;
    }

    public static ResultSet getForModerator() throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select id,module,marks,grade from students");
        return resultSet;
    }

    public static ResultSet findStudent(String id) throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students where id='" + id + "'");

        return resultSet;
    }

    public static boolean updateAssignment(String module,String batchCode, String description, String sid) throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        statement.execute("update students set module='"+module+"', batchCode='"+batchCode+"', description='"+description+"' where id='"+sid+"'");
        if(connection != null) connection.close();
        if(statement != null) statement.close();
        return true;
    }
    
    public static boolean updateMarks(String module,String marks, String sid) throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        statement.execute("update students set module='"+module+"', marks="+marks+" where id='"+sid+"'");
        if(connection != null) connection.close();
        if(statement != null) statement.close();
        return true;
        
    }
    
    public static boolean updateGrade(String grade, String sid) throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        statement.execute("update students set grade='"+grade+"' where id='"+sid+"'");
        if(connection != null) connection.close();
        if(statement != null) statement.close();
        return true;
    }
    
    public static boolean updateComment(String comments, String sid) throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        statement.execute("update students set comments='"+comments+"' where id='"+sid+"'");
        if(connection != null) connection.close();
        if(statement != null) statement.close();
        return true;
    }
    
    public static void main(String[] args) throws SQLException{
    }
}
