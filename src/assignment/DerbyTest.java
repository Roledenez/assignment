/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Roledene
 */
public class DerbyTest {
        private Connection connect = null;
        private Statement statement = null;
        private ResultSet resultSet = null;

        public DerbyTest() throws Exception {
                try {

                        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                        connect = DriverManager
                                        .getConnection("jdbc:derby://localhost:1527/DbTest;");
                        PreparedStatement statement = connect
                                        .prepareStatement("SELECT * from testTable");

                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("name");
                                System.out.println("ID: " + id);
                                System.out.println("Name: " + name);
                        }
                } catch (Exception e) {
                        throw e;
                } finally {
                        close();
                }

        }
        
        private void close() {
                try {
                        if (resultSet != null) {
                                resultSet.close();
                        }
                        if (statement != null) {
                                statement.close();
                        }
                        if (connect != null) {
                                connect.close();
                        }
                } catch (Exception e) {

                }
        }
        
        public static void main(String[] args) throws Exception {
                DerbyTest dao = new DerbyTest();
        }
    
}
