/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shiyanrox
 */
public class DBConnection {

    String DBurl;
    Statement stmt;
    ResultSet rs;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DBurl = "jdbc:mysql://localhost/distributerxdb?" + "user=root&password=";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "JDBC Driver does not work");
        }
    }

    public Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DBurl);
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.getMessage() + "DB connection failure");
        }

        return con;
    }

    public void con_close(Connection Con) {
        try {
            Con.close();
        } catch (SQLException sqlex) {

            JOptionPane.showMessageDialog(null, sqlex.getMessage() + "JDBC Driver does not work");

        }
    }

    public boolean excuteNonReturnQry(String qry) {
        Connection con = this.connect();
        boolean flag = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(qry);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        }
        this.con_close(con);
        return flag;

    }

    public ResultSet excuteReturnQry(String qry) {
        Connection con = this.connect();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(qry);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.con_close(con);
        return rs;
    }
}
