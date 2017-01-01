/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Roledene
 */
public class CreateDB {
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:ADB;create=true";
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER); 
        Connection connection = DriverManager.getConnection(JDBC_URL);
        connection.createStatement().execute("create table Users(name varchar(20),role varchar(20),username varchar(20),password varchar(20))");
        connection.createStatement().execute("insert into Users values ('Chamal','Lecturer','lecturer', 'admin'),('Amith','Admin','admin','admin'),('Damith','Moderator','moderator','admin')");
        System.out.println("User database and table created  ...");
        
        connection.createStatement().execute("create table Students(id varchar(20), name varchar(20),module varchar(20),marks int,grade varchar(20),comments varchar(2000),batchCode varchar(20),description varchar(3000))");
        connection.createStatement().execute("insert into Students values ('sid_01','Chamara','Maths',45, 'C', 'No comments','b001','no description')");
        connection.createStatement().execute("insert into Students values ('sid_02','Nadun','Maths',98, 'A+', 'No comments','b001','no description')");
        System.out.println("Student database and table created  ...");
    }
}
