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
public class SalesRtnRegistry extends SalesRtn {
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
    public boolean addSalesRtnRegistry(SalesRtnRegistry obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into salesrtnregistry (rtnNoteNo,PID,Batch,Description,SPrice,Qty,Amount) values('" + obj.getRtnNoteNo()+ "','" + obj.getPID()+ "','" + obj.getBatch() + "','" + obj.getDescription() + "','" + obj.getSPrice() + "','" + obj.getQty() + "','" + obj.getAmount() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean addSalesRtnRegistryBulk(ArrayList<SalesRtnRegistry> list) {
        boolean result = false;
        for (int count = 0; list.size() > count; count++) {
            result = addSalesRtnRegistry(list.get(count));
        }
        return result;
    }

    public ArrayList<SalesRtnRegistry> loadSalesRtnRegistrybyInvono(int invoNo) {
        ArrayList<SalesRtnRegistry> SalesRtnRegistryList = new ArrayList<SalesRtnRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from salesrtnregistry where rtnNoteNo='" + invoNo + "'";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SalesRtnRegistry obj = new SalesRtnRegistry();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setPID(rs.getInt("PID"));
                obj.setBatch(rs.getString("Batch"));
                obj.setDescription(rs.getString("PDescription"));
                obj.setSPrice(rs.getFloat("SPrice"));
                obj.setQty(rs.getInt("Qty"));
                obj.setTotal(rs.getFloat("Amount"));

                SalesRtnRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SalesRtnRegistryList;
    }
    
}
