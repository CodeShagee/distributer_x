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
public class InvoiceRegistry extends Invoices{
    private int PID;
    private String Batch;
    private String Description;
    private float SPrice;
    private int Qty;
    private float Amount;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getSPrice() {
        return SPrice;
    }

    public void setSPrice(float SPrice) {
        this.SPrice = SPrice;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }
    public boolean addInvoiceRegistry(InvoiceRegistry obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into invoregistry (InvoNo,PID,Batch,Description,SPrice,Qty,Amount) values('" + obj.getInvoNo()+ "','" + obj.getPID()+ "','" + obj.getBatch() + "','" + obj.getDescription() + "','" + obj.getSPrice() + "','" + obj.getQty() + "','" + obj.getAmount() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean addInvoiceRegistryBulk(ArrayList<InvoiceRegistry> list) {
        boolean result = false;
        for (int count = 0; list.size() > count; count++) {
            result = addInvoiceRegistry(list.get(count));
        }
        return result;
    }

    public ArrayList<InvoiceRegistry> loadInvoiceRegistrybyInvono(int invoNo) {
        ArrayList<InvoiceRegistry> InvoiceRegistryList = new ArrayList<InvoiceRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from invoregistry where InvoNo='" + invoNo + "'";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                InvoiceRegistry obj = new InvoiceRegistry();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPID(rs.getInt("PID"));
                obj.setBatch(rs.getString("Batch"));
                obj.setDescription(rs.getString("Description"));
                obj.setSPrice(rs.getFloat("SPrice"));
                obj.setQty(rs.getInt("Qty"));
                obj.setTotal(rs.getFloat("Amount"));

                InvoiceRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return InvoiceRegistryList;
    }
    public ArrayList<InvoiceRegistry> loadInvoiceRegistrybyfilter(String product,String fDate,String tDate) {
        ArrayList<InvoiceRegistry> InvoiceRegistryList = new ArrayList<InvoiceRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from invoregistry r,invoice i where r.Description='" + product + "'and r.InvoNo=i.InvoNo";

        }else{
        qry = "Select * from invoregistry r,invoice i where (r.Description='" + product + "' and i.date between  '" + fDate + "' and'" + tDate + "' and r.InvoNo=i.InvoNo) ";
        }
        
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                InvoiceRegistry obj = new InvoiceRegistry();
                obj.setInvoNo(rs.getInt("InvoNo"));
                obj.setPID(rs.getInt("PID"));
                obj.setDate(rs.getString("Date"));
                obj.setBatch(rs.getString("Batch"));
                obj.setDescription(rs.getString("Description"));
                obj.setSPrice(rs.getFloat("SPrice"));
                obj.setQty(rs.getInt("Qty"));
                obj.setAmount(rs.getFloat("Amount"));

                InvoiceRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return InvoiceRegistryList;
    }
}
