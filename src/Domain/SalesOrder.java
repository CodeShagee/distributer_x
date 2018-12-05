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
public class SalesOrder {
    private int RefCode;
    private String PoNo;
    private String Customer;
    private String Date;
    private int Status;

    public int getRefCode() {
        return RefCode;
    }

    public void setRefCode(int RefCode) {
        this.RefCode = RefCode;
    }

    public String getPoNo() {
        return PoNo;
    }

    public void setPoNo(String PoNo) {
        this.PoNo = PoNo;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    public boolean addSalesOrder(SalesOrder obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into salesorder (PoNo, Customer, Date, Status) values('" + obj.getPoNo()+ "','" + obj.getCustomer()+ "','" + obj.getDate()+ "','" + obj.getStatus()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean updateSalesOrder(SalesOrder obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "update salesorder set status='" + obj.getStatus()+ "' where RefCode ='" + obj.getRefCode()+ "' ";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public ArrayList<SalesOrder> loadSalesOrder() {
        ArrayList<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesorder";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesOrder obj = new SalesOrder();
                obj.setRefCode(rs.getInt("RefCode"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));
                
               

                SalesOrderList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SalesOrderList;
    }

    public SalesOrder viewASalesOrder(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesorder where RefCode='" + id + "'";
        SalesOrder obj = new SalesOrder();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setRefCode(rs.getInt("RefCode"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in salesorder Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<SalesOrder> searchSalesOrder(String text) {
        ArrayList<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesorder where (RefCode like '" + text + "%' or Customer like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesOrder obj = new SalesOrder();
                obj.setRefCode(rs.getInt("RefCode"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));

                SalesOrderList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SalesOrderList;
    }
    public ArrayList<SalesOrder> searchSalesOrderByFilter(String Customer,String fDate,String tDate) {
        ArrayList<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from salesorder where Customer like '" + Customer + "%'";

        }else{
        qry = "Select * from salesorder where (Customer like '" + Customer + "%' and (date between  '" + fDate + "' and'" + tDate + "') )";
        }
       
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesOrder obj = new SalesOrder();
                obj.setRefCode(rs.getInt("RefCode"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("date"));
                obj.setStatus(rs.getInt("status"));

                SalesOrderList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SalesOrderList;
    }
    public int getLastID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(RefCode) as maxid from salesorder";
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
