/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Roledene
 */
public class Test {
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:ADB;create=true";
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER); 
        Connection connection = DriverManager.getConnection(JDBC_URL);
//        connection.createStatement().execute("create table channels(channel varchar(20),topic varchar(20),videoclip varchar(20))");
//        connection.createStatement().execute("inset into channels values (c1,t1,v1),(c2,t2,v2);");
          connection.createStatement().execute("Select * from testtable;");
        System.out.println("channel created ...");
        
    }
}
