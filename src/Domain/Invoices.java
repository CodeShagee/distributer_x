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
public class Invoices {

    private int InvoNo;
    private String PoNo;
    private String type;
    private int creditPreiod;
    private String Customer;
    private String Date;
    private float Net;
    private float Discount;
    private float Total;
    private int Status;

    public int getInvoNo() {
        return InvoNo;
    }

    public void setInvoNo(int InvoNo) {
        this.InvoNo = InvoNo;
    }

    public String getPoNo() {
        return PoNo;
    }

    public void setPoNo(String PoNo) {
        this.PoNo = PoNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCreditPreiod() {
        return creditPreiod;
    }

    public void setCreditPreiod(int creditPreiod) {
        this.creditPreiod = creditPreiod;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public boolean addInvoices(Invoices obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into invoice (PoNo,type,creditPreiod,Customer,Date,Net,Discount,Total,Status) values('" + obj.getPoNo() + "','" + obj.getType() + "','" + obj.getCreditPreiod() + "','" + obj.getCustomer() + "','" + obj.getDate() + "','" + obj.getNet() + "','" + obj.getDiscount() + "','" + obj.getTotal() + "','" + obj.getStatus() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public ArrayList<Invoices> loadInvoices() {
        ArrayList<Invoices> InvoicesList = new ArrayList<Invoices>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Invoice";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Invoices obj = new Invoices();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setType(rs.getString("type"));
                obj.setCreditPreiod(rs.getInt("creditPreiod"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                obj.setStatus(rs.getInt("Status"));

                InvoicesList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return InvoicesList;
    }

    public Invoices viewAInvoices(int id) {
        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Invoice where InvoNo='" + id + "'";
        Invoices obj = new Invoices();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {

                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setType(rs.getString("type"));
                obj.setCreditPreiod(rs.getInt("creditPreiod"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                obj.setStatus(rs.getInt("Status"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :" + ex.getMessage());
        }
        return obj;
    }

    public ArrayList<Invoices> searchInvoices(String text) {
        ArrayList<Invoices> InvoicesList = new ArrayList<Invoices>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from Invoice where (InvoNo like '" + text + "%' or Customer like '" + text + "%')";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Invoices obj = new Invoices();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setType(rs.getString("type"));
                obj.setCreditPreiod(rs.getInt("creditPreiod"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                obj.setStatus(rs.getInt("Status"));

                InvoicesList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return InvoicesList;
    }

    public int getLastGRNID() {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(InvoNo) as maxid from Invoice";
        int id = 0;
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            if (rs.next()) {
                id = rs.getInt("maxid");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Product Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<Invoices> searchGRNByFilter(String customer, String fDate, String tDate) {
        ArrayList<Invoices> POList = new ArrayList<Invoices>();
        DBConnection objDBcon = new DBConnection();
        String qry = null;
        if (fDate == null | tDate == null) {
            qry = "Select * from Invoice where Customer like '" + customer + "%'";
        } else {
            qry = "Select * from Invoice where (Customer like '" + customer + "%' and (date between  '" + fDate + "' and'" + tDate + "') )";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
            while (rs.next()) {
                Invoices obj = new Invoices();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setType(rs.getString("type"));
                obj.setCreditPreiod(rs.getInt("creditPreiod"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                obj.setStatus(rs.getInt("Status"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }

    public ArrayList<Invoices> searchInvoiceByDate(String fDate, String tDate) {
        ArrayList<Invoices> POList = new ArrayList<Invoices>();

        DBConnection objDBcon = new DBConnection();
        String qry = null;
        if (fDate == null | tDate == null) {
            qry = "Select * from Invoice ";

        } else {
            qry = "Select * from Invoice where (date between  '" + fDate + "' and'" + tDate + "') ";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Invoices obj = new Invoices();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setType(rs.getString("type"));
                obj.setCreditPreiod(rs.getInt("creditPreiod"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                obj.setStatus(rs.getInt("Status"));

                POList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return POList;
    }

    public ArrayList<Invoices> searchCreditInvoiceByDate(String fDate, String tDate) {
        ArrayList<Invoices> POList = new ArrayList<Invoices>();

        DBConnection objDBcon = new DBConnection();
        String qry = null;
        if (fDate == null | tDate == null) {
            qry = "Select * from Invoice where type='Credit'";

        } else {
            qry = "Select * from Invoice where (type='Credit' and date between  '" + fDate + "' and'" + tDate + "') ";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                Invoices obj = new Invoices();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setType(rs.getString("type"));
                obj.setCreditPreiod(rs.getInt("creditPreiod"));
                obj.setCustomer(rs.getString("Customer"));
                obj.setDate(rs.getString("Date"));
                obj.setNet(rs.getFloat("Net"));
                obj.setDiscount(rs.getFloat("Discount"));
                obj.setTotal(rs.getFloat("Total"));
                obj.setStatus(rs.getInt("Status"));

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
