/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAL.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Shiyanrox
 */
public class User {

    private int UID;
    private String Name;
    private String Email;
    private String username;
    private String password;
    private String Level;

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public boolean addUser(User obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into User (Name,Email,username,password,Level) values('" + obj.getName() + "','" + obj.getEmail() + "','" + obj.getUsername() + "','" + obj.getPassword() + "','" + obj.getLevel() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean updateUser(User obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "update User set Name='" + obj.getName() + "',Email='" + obj.getEmail() + "',username='" + obj.getUsername() + "',password='" + obj.getPassword() + "',Level='" + obj.getLevel() + "' where UID='" + obj.getUID() + "'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean deleteUser(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "delete from User where UID='" + id + "'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public int getLastID() {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(UID) as maxid from User";
        int id = 0;
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            if (rs.next()) {
                id = rs.getInt("maxid");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While User Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<User> loadUser() {
        ArrayList<User> UserList = new ArrayList<User>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from User";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                User obj = new User();
                obj.setUID(rs.getInt("UID"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setLevel(rs.getString("Level"));

                UserList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While User Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return UserList;
    }

    public User viewAUser(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from User where UID='" + id + "'";
        User obj = new User();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setUID(rs.getInt("UID"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setLevel(rs.getString("Level"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<User> searchUser(String text) {
        ArrayList<User> UserList = new ArrayList<User>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from User where (UID like '" + text + "%' or Name like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                User obj = new User();
                obj.setUID(rs.getInt("UID"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setLevel(rs.getString("Level"));

                UserList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While User Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return UserList;
    }

    public User getUserByUserName(String uname) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from User where username='" + uname + "'";
        User obj = new User();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {
                obj.setUID(rs.getInt("UID"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setLevel(rs.getString("Level"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Username !");
        }
        return obj;
    }

    public boolean isExsist(String uname) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from User where username='" + uname + "'";
        boolean stat = false;
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {
                stat = true;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Username !");
        }
        return stat;
    }

}
