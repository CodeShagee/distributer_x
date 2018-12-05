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
public class SalesRtn {
    private int rtnNoteNo;
    private int InvoiceNo;
    private String Customer;
    private String Date;
    private float Net;
    private float Discount;
    private float Total;

    public int getRtnNoteNo() {
        return rtnNoteNo;
    }

    public void setRtnNoteNo(int rtnNoteNo) {
        this.rtnNoteNo = rtnNoteNo;
    }

    public int getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(int InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public float getNet() {
        return Net;
    }

    public void setNet(float Net) {
        this.Net = Net;
    }

    public float getDiscount() {
        return Discount;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    public boolean addSalesRtn(SalesRtn obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into salesrtn (InvoiceNo, Customer, Date, Net, Discount, Total) values('" + obj.getInvoiceNo()+ "','" + obj.getCustomer()+ "','" + obj.getDate()+ "','" + obj.getNet()+ "','" + obj.getDiscount()+ "','" + obj.getTotal()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public ArrayList<SalesRtn> loadSalesRtn() {
        ArrayList<SalesRtn> SalesRtnList = new ArrayList<SalesRtn>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesrtn";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesRtn obj = new SalesRtn();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setInvoiceNo(rs.getInt("InvoiceNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                
               

                SalesRtnList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SalesRtnList;
    }

    public SalesRtn viewASalesRtn(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesrtn where rtnNoteNo='" + id + "'";
        SalesRtn obj = new SalesRtn();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setInvoiceNo(rs.getInt("InvoiceNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in  Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<SalesRtn> searchSalesRtn(String text) {
        ArrayList<SalesRtn> SalesRtnList = new ArrayList<SalesRtn>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesrtn where (rtnNoteNo like '" + text + "%' or Customer like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesRtn obj = new SalesRtn();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setInvoiceNo(rs.getInt("InvoiceNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));

                SalesRtnList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SalesRtnList;
    }
    public int getLastRTNID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(rtnNoteNo) as maxid from salesrtn";
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
     public ArrayList<SalesRtn> searchGRNByFilter(String customer,String fDate,String tDate) {
        ArrayList<SalesRtn> POList = new ArrayList<SalesRtn>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from salesrtn where Customer like '" + customer + "%'";

        }else{
        qry = "Select * from salesrtn where (Customer like '" + customer + "%' and (date between  '" + fDate + "' and'" + tDate + "') )";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesRtn obj = new SalesRtn();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setInvoiceNo(rs.getInt("InvoiceNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
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
