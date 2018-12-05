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
public class GrnRegistry extends Grn {

    private int PID;
    private float BPrice;
    private float SPrice;
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

    public String getPDescription() {
        return PDescription;
    }

    public void setPDescription(String PDescription) {
        this.PDescription = PDescription;
    }

    public boolean addGrnRegistry(GrnRegistry obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into GrnRegistry (GRNno,Batch,PID,PDescription,BPrice,SPrice, Qty, Amount) values('" + obj.getGRNno() + "','" + obj.getBatch() + "','" + obj.getPID() + "','" + obj.getPDescription() + "','" + obj.getBPrice() + "','" + obj.getSPrice() + "','" + obj.getQty() + "','" + obj.getAmount() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean addGrnRegistryBulk(ArrayList<GrnRegistry> list) {
        boolean result = false;
        for (int count = 0; list.size() > count; count++) {
            result = addGrnRegistry(list.get(count));
        }
        return result;
    }

    public ArrayList<GrnRegistry> loadGrnRegistrybyGRNno(int grnNo) {
        ArrayList<GrnRegistry> GrnRegistryList = new ArrayList<GrnRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from GrnRegistry where GRNno='" + grnNo + "'";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                GrnRegistry obj = new GrnRegistry();
                obj.setGRNno(rs.getInt("GRNno"));
                obj.setBatch(rs.getString("Batch"));
                obj.setPID(rs.getInt("PID"));
                obj.setPDescription(rs.getString("PDescription"));
                obj.setBPrice(rs.getFloat("BPrice"));
                obj.setSPrice(rs.getFloat("SPrice"));
                obj.setQty(rs.getInt("Qty"));
                obj.setTotal(rs.getFloat("Amount"));

                GrnRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return GrnRegistryList;
    }
    public ArrayList<GrnRegistry> loadGrnRegistrybyFilter(String product,String fDate,String tDate) {
        ArrayList<GrnRegistry> GrnRegistryList = new ArrayList<GrnRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry=null;
        if(fDate==null |tDate==null){
        qry = "Select * from GrnRegistry r,Grn i where r.PDescription='" + product + "'and r.GRNno=i.GRNno";

        }else{
        qry = "Select * from GrnRegistry r,Grn i where (r.PDescription='" + product + "' and i.GrnDate between  '" + fDate + "' and'" + tDate + "' and r.GRNno=i.GRNno) ";
        }
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                GrnRegistry obj = new GrnRegistry();
                obj.setGRNno(rs.getInt("GRNno"));
                obj.setBatch(rs.getString("Batch"));
                obj.setPID(rs.getInt("PID"));
                obj.setGrnDate(rs.getString("GrnDate"));
                obj.setPDescription(rs.getString("PDescription"));
                obj.setBPrice(rs.getFloat("BPrice"));
                obj.setSPrice(rs.getFloat("SPrice"));
                obj.setQty(rs.getInt("Qty"));
                obj.setAmount(rs.getFloat("Amount"));

                GrnRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return GrnRegistryList;
    }

}
