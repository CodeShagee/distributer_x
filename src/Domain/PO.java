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
public class PO {
    private int POno;
    private String Vender;
    private String date;
    private int status;

    public int getPOno() {
        return POno;
    }

    public void setPOno(int POno) {
        this.POno = POno;
    }

    public String getVender() {
        return Vender;
    }

    public void setVender(String Vender) {
        this.Vender = Vender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public boolean addPO(PO obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into purchasingorder (Vender,date,status) values('" + obj.getVender()+ "','" + obj.getDate()+ "','" + obj.getStatus()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean updatePO(PO obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "update purchasingorder set status='" + obj.getStatus()+ "' where POno ='" + obj.getPOno()+ "' ";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public ArrayList<PO> loadPO() {
        ArrayList<PO> POList = new ArrayList<PO>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasingorder";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PO obj = new PO();
                obj.setPOno(rs.getInt("POno"));
                obj.setVender(rs.getString("Vender"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));
                
               

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }

    public PO viewAPO(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasingorder where GRNno='" + id + "'";
        PO obj = new PO();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setPOno(rs.getInt("POno"));
                obj.setVender(rs.getString("Vender"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<PO> searchPO(String text) {
        ArrayList<PO> POList = new ArrayList<PO>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasingorder where (GRNno like '" + text + "%' or VendorName like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PO obj = new PO();
                obj.setPOno(rs.getInt("POno"));
                obj.setVender(rs.getString("Vender"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }
    public ArrayList<PO> searchPOByFilter(String vendor,String fDate,String tDate) {
        ArrayList<PO> POList = new ArrayList<PO>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from purchasingorder where Vender like '" + vendor + "%'";

        }else{
        qry = "Select * from purchasingorder where (Vender like '" + vendor + "%' and (date between  '" + fDate + "' and'" + tDate + "') )";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PO obj = new PO();
                obj.setPOno(rs.getInt("POno"));
                obj.setVender(rs.getString("Vender"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }
    public int getLastID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(POno) as maxid from purchasingorder";
        int id=0;
        try
         {
        ResultSet rs =objDBcon.excuteReturnQry(qry);
        
        if(rs.next()){
        id = rs.getInt("maxid");
                }
         }
        catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Product Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        return id;
    }
    
}
