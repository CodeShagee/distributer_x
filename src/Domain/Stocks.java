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
public class Stocks extends Products {

    private String Batch;
    private int Qty;
    private float Bprice;
    private float Sprice;

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public float getBprice() {
        return Bprice;
    }

    public void setBprice(float Bprice) {
        this.Bprice = Bprice;
    }

    public float getSprice() {
        return Sprice;
    }

    public void setSprice(float Sprice) {
        this.Sprice = Sprice;
    }

    public boolean addStock(Stocks obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Stock (PID,Batch,Category,VendorName,Qty,BPrice,SPrice,PDescription) values('" + obj.getPID() + "','" + obj.getBatch() + "','" + obj.getCatname() + "','" + obj.getVendorName() + "','" + obj.getQty() + "','" + obj.getBprice() + "','" + obj.getSprice() + "','" + obj.getDescription() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean updateStocks(Stocks obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "update Stock set Qty='" + obj.getQty() + "',BPrice='" + obj.getBprice() + "',SPrice='" + obj.getSprice() + "' where (PID ='" + obj.getPID() + "' and Batch='" + obj.getBatch() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public ArrayList<Stocks> loadStocks() {
        ArrayList<Stocks> StocksList = new ArrayList<Stocks>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Stock";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Stocks obj = new Stocks();
                obj.setPID(rs.getInt("PID"));
                obj.setDescription(rs.getString("PDescription"));
                obj.setCatname(rs.getString("Category"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setQty(rs.getInt("Qty"));
                obj.setBatch(rs.getString("Batch"));
                obj.setBprice(rs.getFloat("BPrice"));
                obj.setSprice(rs.getFloat("SPrice"));

                StocksList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return StocksList;
    }

    public Stocks viewAStocks(int id, String batch) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Stock where PID='" + id + "' and Batch = '" + batch + "'";
        Stocks obj = new Stocks();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setPID(rs.getInt("PID"));
                obj.setDescription(rs.getString("PDescription"));
                obj.setCatname(rs.getString("Category"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setQty(rs.getInt("Qty"));
                obj.setBatch(rs.getString("Batch"));
                obj.setBprice(rs.getFloat("BPrice"));
                obj.setSprice(rs.getFloat("SPrice"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<Stocks> searchStocks(String text) {
        ArrayList<Stocks> StocksList = new ArrayList<Stocks>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Stock where (PID like '" + text + "%' or PDescription like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Stocks obj = new Stocks();
                obj.setPID(rs.getInt("PID"));
                obj.setDescription(rs.getString("PDescription"));
                obj.setCatname(rs.getString("Category"));
                obj.setVendorName(rs.getString("VendorName"));
                obj.setQty(rs.getInt("Qty"));
                obj.setBatch(rs.getString("Batch"));
                obj.setBprice(rs.getFloat("BPrice"));
                obj.setSprice(rs.getFloat("SPrice"));

                StocksList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return StocksList;
    }
    public boolean isExsist(int Pid,String Batch)
    {
        boolean result=false;
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Stock where (PID = '" + Pid + "' and Batch = '" + Batch + "')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            if(rs.next())
            {
                result=true;
            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return result;
    }
    public boolean updateQty(int pid,String Batch,int qty,int type){
    boolean result=false;
        DBConnection objDBcon = new DBConnection();
        String qry = null;
        /*
        type=1 for Grn
        type=0 for Invoice
        */
        if(type==1){
        qry="update Stock set Qty=Qty+'" + qty + "' where (PID ='" + pid + "' and Batch='" + Batch + "')";
        }else{
        qry="update Stock set Qty=Qty-'" + qty + "' where (PID ='" + pid + "' and Batch='" + Batch + "')";
        }
         result= objDBcon.excuteNonReturnQry(qry);
        return result;
    }
}
