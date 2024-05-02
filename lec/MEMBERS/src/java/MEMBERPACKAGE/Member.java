/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MEMBERPACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


class Member 
{
    Statement st;

    void addMember(String name, String city, String tele, String email) {
        String query = "INSERT INTO member(name,city,tele,email) VALUES ('"+name+"','"+city+"','"+tele+"','"+email+"')";
        connectToDb();
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connectToDb() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/memberdb";
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, "root","");
             st = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
