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
public class Grn {
    private int GRNno;
    private String GRNtype;
    private int poNo;
    private String GrnDate;
    private String VendorName;
    private String Batch;
    private float Total;

    public int getGRNno() {
        return GRNno;
    }

    public void setGRNno(int GRNno) {
        this.GRNno = GRNno;
    }

    public String getGRNtype() {
        return GRNtype;
    }

    public void setGRNtype(String GRNtype) {
        this.GRNtype = GRNtype;
    }

    public int getPoNo() {
        return poNo;
    }

    public void setPoNo(int poNo) {
        this.poNo = poNo;
    }

    public String getGrnDate() {
        return GrnDate;
    }

    public void setGrnDate(String GrnDate) {
        this.GrnDate = GrnDate;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    public boolean addGrn(Grn obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Grn (GRNtype, poNo, GrnDate, VendorName, Batch, Total) values('" + obj.getGRNtype()+ "','" + obj.getPoNo()+ "','" + obj.getGrnDate()+ "','" + obj.getVendorName()+ "','" + obj.getBatch()+ "','" + obj.getTotal()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

//    public boolean updateGrn(Grn obj) {
//        DBConnection objDBcon = new DBConnection();
//        String qry = "update Grn set Qty='" + obj.getQty() + "',BPrice='" + obj.getBprice() + "',SPrice='" + obj.getSprice() + "' where (PID ='" + obj.getPID() + "' and Batch='" + obj.getBatch() + "')";
//        boolean flag = objDBcon.excuteNonReturnQry(qry);
//        return flag;
//    }
    public ArrayList<Grn> loadGrn() {
        ArrayList<Grn> GrnList = new ArrayList<Grn>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Grn";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Grn obj = new Grn();
                obj.setGRNno(rs.getInt("GRNno"));
                obj.setGRNtype(rs.getString("GRNtype"));
                obj.setPoNo(rs.getInt("poNo"));
                obj.setGrnDate(rs.getString("GrnDate"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setBatch(rs.getString("Batch"));
                obj.setTotal(rs.getFloat("Total"));
               

                GrnList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return GrnList;
    }

    public Grn viewAGrn(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Grn where GRNno='" + id + "'";
        Grn obj = new Grn();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setGRNno(rs.getInt("GRNno"));
                obj.setGRNtype(rs.getString("GRNtype"));
                obj.setPoNo(rs.getInt("poNo"));
                obj.setGrnDate(rs.getString("GrnDate"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setBatch(rs.getString("Batch"));
                obj.setTotal(rs.getFloat("Total"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<Grn> searchGrn(String text) {
        ArrayList<Grn> GrnList = new ArrayList<Grn>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Grn where (GRNno like '" + text + "%' or VendorName like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Grn obj = new Grn();
                obj.setGRNno(rs.getInt("GRNno"));
                obj.setGRNtype(rs.getString("GRNtype"));
                obj.setPoNo(rs.getInt("poNo"));
                obj.setGrnDate(rs.getString("GrnDate"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setBatch(rs.getString("Batch"));
                obj.setTotal(rs.getFloat("Total"));

                GrnList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return GrnList;
    }
    public int getLastGRNID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(GRNno) as maxid from Grn";
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
     public ArrayList<Grn> searchGRNByFilter(String vendor,String fDate,String tDate) {
        ArrayList<Grn> POList = new ArrayList<Grn>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from Grn where VendorName like '" + vendor + "%'";

        }else{
        qry = "Select * from Grn where (VendorName like '" + vendor + "%' and (GrnDate between  '" + fDate + "' and'" + tDate + "') )";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Grn obj = new Grn();
                obj.setGRNno(rs.getInt("GRNno"));
                obj.setGRNtype(rs.getString("GRNtype"));
                obj.setPoNo(rs.getInt("poNo"));
                obj.setGrnDate(rs.getString("GrnDate"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setBatch(rs.getString("Batch"));
                obj.setTotal(rs.getFloat("Total"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }
     public ArrayList<Grn> searchGRNByDates(String fDate,String tDate) {
        ArrayList<Grn> POList = new ArrayList<Grn>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from Grn";

        }else{
        qry = "Select * from Grn where (GrnDate between  '" + fDate + "' and'" + tDate + "')";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Grn obj = new Grn();
                obj.setGRNno(rs.getInt("GRNno"));
                obj.setGRNtype(rs.getString("GRNtype"));
                obj.setPoNo(rs.getInt("poNo"));
                obj.setGrnDate(rs.getString("GrnDate"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setBatch(rs.getString("Batch"));
                obj.setTotal(rs.getFloat("Total"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }
}
