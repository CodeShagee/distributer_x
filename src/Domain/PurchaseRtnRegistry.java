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
public class PurchaseRtnRegistry extends PurchaseRtn{
    private int PID;
    private float BPrice;
    private String Batch;
    private int Qty;
    private float Amount;
    private String PDescription;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public float getBPrice() {
        return BPrice;
    }

    public void setBPrice(float BPrice) {
        this.BPrice = BPrice;
    }

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

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    public String getPDescription() {
        return PDescription;
    }

    public void setPDescription(String PDescription) {
        this.PDescription = PDescription;
    }
    public boolean addPurchaseRtnRegistry(PurchaseRtnRegistry obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into purchasertnregistry (rtnNoteNo,PID,Batch,Description,BPrice,Qty,Amount) values('" + obj.getRtnNoteNo()+ "','" + obj.getPID()+ "','" + obj.getBPrice()+ "','" + obj.getPDescription() + "','" + obj.getBPrice() + "','" + obj.getQty() + "','" + obj.getAmount() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean addPurchaseRtnRegistryBulk(ArrayList<PurchaseRtnRegistry> list) {
        boolean result = false;
        for (int count = 0; list.size() > count; count++) {
            result = addPurchaseRtnRegistry(list.get(count));
        }
        return result;
    }

    public ArrayList<PurchaseRtnRegistry> loadPurchaseRtnRegistrybyGRNno(int grnNo) {
        ArrayList<PurchaseRtnRegistry> PurchaseRtnRegistryList = new ArrayList<PurchaseRtnRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from purchasertnregistry where rtnNoteNo='" + grnNo + "'";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PurchaseRtnRegistry obj = new PurchaseRtnRegistry();
                obj.setRtnNoteNo(rs.getInt("rtnNoteNo"));
                obj.setBatch(rs.getString("Batch"));
                obj.setPID(rs.getInt("PID"));
                obj.setPDescription(rs.getString("Description"));
                obj.setBPrice(rs.getFloat("BPrice"));
               
                obj.setQty(rs.getInt("Qty"));
                obj.setTotal(rs.getFloat("Amount"));

                PurchaseRtnRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return PurchaseRtnRegistryList;
    }
}
