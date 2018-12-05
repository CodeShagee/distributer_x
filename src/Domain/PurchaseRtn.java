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
public class PurchaseRtn {
    private int rtnNoteNo;
    private int GrnNo;
    private String Vendor;
    private String Date;
    private float Total;

    public int getRtnNoteNo() {
        return rtnNoteNo;
    }

    public void setRtnNoteNo(int rtnNoteNo) {
        this.rtnNoteNo = rtnNoteNo;
    }

    public int getGrnNo() {
        return GrnNo;
    }

    public void setGrnNo(int GrnNo) {
        this.GrnNo = GrnNo;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    public boolean addPurchaseRtn(PurchaseRtn obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into purchasertn (GrnNo,Vendor,Date,Total) values('" + obj.getGrnNo()+ "','" + obj.getVendor()+ "','" + obj.getDate()+ "','" + obj.getTotal()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public ArrayList<PurchaseRtn> loadPurchaseRtn() {
        ArrayList<PurchaseRtn> PurchaseRtnList = new ArrayList<PurchaseRtn>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasertn";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PurchaseRtn obj = new PurchaseRtn();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setGrnNo(rs.getInt("GrnNo"));
                obj.setVendor(rs.getString("Vendor"));
                obj.setDate(rs.getString("Date"));
                obj.setTotal(rs.getFloat("Total"));
                
               

                PurchaseRtnList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return PurchaseRtnList;
    }

    public PurchaseRtn viewAPurchaseRtn(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasertn where rtnNoteNo='" + id + "'";
        PurchaseRtn obj = new PurchaseRtn();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setGrnNo(rs.getInt("GrnNo"));
                obj.setVendor(rs.getString("Vendor"));
                obj.setDate(rs.getString("Date"));
                obj.setTotal(rs.getFloat("Total"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in  Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<PurchaseRtn> searchPurchaseRtn(String text) {
        ArrayList<PurchaseRtn> PurchaseRtnList = new ArrayList<PurchaseRtn>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasertn where (rtnNoteNo like '" + text + "%' or Vendor like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PurchaseRtn obj = new PurchaseRtn();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setGrnNo(rs.getInt("GrnNo"));
                obj.setVendor(rs.getString("Vendor"));
                obj.setDate(rs.getString("Date"));
                obj.setTotal(rs.getFloat("Total"));

                PurchaseRtnList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return PurchaseRtnList;
    }
    public int getLastGRNID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(rtnNoteNo) as maxid from purchasertn";
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
             JOptionPane.showMessageDialog(null, "Error While  Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        return id;
    }
     public ArrayList<PurchaseRtn> searchGRNByFilter(String customer,String fDate,String tDate) {
        ArrayList<PurchaseRtn> POList = new ArrayList<PurchaseRtn>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from purchasertn where Vendor like '" + customer + "%'";

        }else{
        qry = "Select * from purchasertn where (Vendor like '" + customer + "%' and (date between  '" + fDate + "' and'" + tDate + "') )";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PurchaseRtn obj = new PurchaseRtn();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setGrnNo(rs.getInt("GrnNo"));
                obj.setVendor(rs.getString("Vendor"));
                obj.setDate(rs.getString("Date"));
                obj.setTotal(rs.getFloat("Total"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }
}
