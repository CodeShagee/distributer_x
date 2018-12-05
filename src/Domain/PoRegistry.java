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
public class PoRegistry extends PO{
    private int PID;
    private String PDescription;
    private int Qty;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPDescription() {
        return PDescription;
    }

    public void setPDescription(String PDescription) {
        this.PDescription = PDescription;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }
    public boolean addPoRegistry(PoRegistry obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into PoRegistry (POno,PID,PDescription,Qty) values('" + obj.getPOno()+ "','" + obj.getPID()+ "','" + obj.getPDescription()+ "','" + obj.getQty()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean addPoRegistryBulk(ArrayList<PoRegistry> list) {
        boolean result = false;
        for (int count = 0; list.size() > count; count++) {
            result = addPoRegistry(list.get(count));
        }
        return result;
    }

    public ArrayList<PoRegistry> loadPoRegistrybyPono(int poNo) {
        ArrayList<PoRegistry> PoRegistryList = new ArrayList<PoRegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from PoRegistry where POno='" + poNo + "'";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                PoRegistry obj = new PoRegistry();
                obj.setPOno(rs.getInt("POno"));
                obj.setPID(rs.getInt("PID"));
                obj.setPDescription(rs.getString("PDescription"));
                obj.setQty(rs.getInt("Qty"));

                PoRegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return PoRegistryList;
    }
}
