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
public class SORegistry extends SalesOrder{
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
    public boolean addSORegistry(SORegistry obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into soregistry (RefCode, PoNo, PID, PDescription,Qty) values('" + obj.getRefCode()+ "','" + obj.getPoNo()+ "','" + obj.getPID()+ "','" + obj.getPDescription()+ "','" + obj.getQty()+ "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public boolean addSORegistryBulk(ArrayList<SORegistry> list) {
        boolean result = false;
        for (int count = 0; list.size() > count; count++) {
            result = addSORegistry(list.get(count));
        }
        return result;
    }

    public ArrayList<SORegistry> loadSORegistrybyPono(int poNo) {
        ArrayList<SORegistry> SORegistryList = new ArrayList<SORegistry>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from soregistry where RefCode='" + poNo + "'";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                SORegistry obj = new SORegistry();
                obj.setRefCode(rs.getInt("RefCode"));
                obj.setPoNo(rs.getString("PoNo"));
                obj.setPID(rs.getInt("PID"));
                obj.setPDescription(rs.getString("PDescription"));
                obj.setQty(rs.getInt("Qty"));

                SORegistryList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While Products Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return SORegistryList;
    }
}
