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
public class Categorys {

    private int catID;
    private String catName;

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean addCategory(Categorys obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Category (catName) values('" + obj.getCatName() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean updateCategory(Categorys obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "update Category set catName='" + obj.getCatName() + "'where catID='" + obj.getCatID() + "'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean deleteCategory(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "delete from Category where catID='" + id + "'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public int getLastcatID() {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(catID) as maxid from Category";
        int id = 0;
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            if (rs.next()) {
                id = rs.getInt("maxid");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Category Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<Categorys> loadCategorys() {
        ArrayList<Categorys> CategorysList = new ArrayList<Categorys>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Category";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Categorys obj = new Categorys();
                obj.setCatID(rs.getInt("catID"));
                obj.setCatName(rs.getString("catName"));

                CategorysList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Categorys Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return CategorysList;
    }

    public Categorys viewACategorys(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Category where catID='" + id + "'";
        Categorys obj = new Categorys();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setCatID(rs.getInt("catID"));
                obj.setCatName(rs.getString("catName"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<Categorys> searchCategorys(String text) {
        ArrayList<Categorys> CategorysList = new ArrayList<Categorys>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Category where (catID like '" + text + "%' or catname like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Categorys obj = new Categorys();
                obj.setCatID(rs.getInt("catID"));
                obj.setCatName(rs.getString("catName"));

                CategorysList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Categorys Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return CategorysList;
    }
}
