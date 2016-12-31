/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.database;

import static assignment.database.CreateDB.JDBC_URL;
import static assignment.database.QueryDB.SQL_STATEMENT;
import assignment.database.models.User;
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
public class UserService {

    void insert(User user) throws SQLException {
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        connection.createStatement().execute("insert into Users values ('" + user.getName() + "','" + user.getRole() + "','" + user.getUsername() + "', '" + user.getPassword() + "')");
        System.out.println("User name " + user.getName() + " added to the database");
    }

    public static void main(String[] args) throws SQLException {
        User user = new User();
        UserService u = new UserService();

        user.setName("Sasika");
        user.setRole("Admin");
        user.setUsername("sasika");
        user.setPassword("password");
        u.insert(user);

        user.setName("Saman");
        user.setRole("Lecture");
        user.setUsername("saman");
        user.setPassword("password");
        u.insert(user);
    }

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
    
    public static ResultSet getAll() throws SQLException{
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        return resultSet;
    }
}
