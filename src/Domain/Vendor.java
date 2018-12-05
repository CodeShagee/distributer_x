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
public class Vendor {
    private int V_id;
    private String V_name;
    private String V_address;
    private String V_contactP;
    private String V_phone;

    public int getV_id() {
        return V_id;
    }

    public void setV_id(int V_id) {
        this.V_id = V_id;
    }

    public String getV_name() {
        return V_name;
    }

    public void setV_name(String V_name) {
        this.V_name = V_name;
    }

    public String getV_address() {
        return V_address;
    }

    public void setV_address(String V_address) {
        this.V_address = V_address;
    }

    public String getV_contactP() {
        return V_contactP;
    }

    public void setV_contactP(String V_contactP) {
        this.V_contactP = V_contactP;
    }

    public String getV_phone() {
        return V_phone;
    }

    public void setV_phone(String V_phone) {
        this.V_phone = V_phone;
    }
    
     public boolean addVendor(Vendor obj)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Vendor (V_name,V_address,V_contactP, V_phone) values('"+obj.getV_name()+"','"+obj.getV_address()+"','"+obj.getV_contactP()+"','"+obj.getV_phone()+"')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean updateVendor(Vendor obj)
    {
       DBConnection objDBcon = new DBConnection();
        String qry = "update Vendor set V_name='"+obj.getV_name()+"',V_address='"+obj.getV_address()+"',V_contactP='"+obj.getV_contactP()+"',V_phone='"+obj.getV_phone()+"' where V_ID='"+obj.getV_id()+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean deleteVendor(int vid)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "delete from Vendor where V_ID='"+vid+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public int getLastVID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(V_ID) as maxid from Vendor";
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
             JOptionPane.showMessageDialog(null, "Error While Vendor Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        return id;
    }
      public ArrayList<Vendor> loadVendor()
    {
        ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Vendor";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Vendor obj = new Vendor();
               obj.setV_id(rs.getInt("V_ID"));
               obj.setV_name(rs.getString("V_name"));
               obj.setV_address(rs.getString("V_address"));
               obj.setV_contactP(rs.getString("V_contactP"));
               obj.setV_phone(rs.getString("V_phone"));

               vendorList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Vendor Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return vendorList; 
    }
     public Vendor viewAVendor(int id)
    {
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Vendor where V_ID='"+id+"'";
         Vendor obj = new Vendor();
         try {
             ResultSet rs = objDBcon.excuteReturnQry(qry);
             while(rs.next())
             {
                 
              obj.setV_id(rs.getInt("V_ID"));
               obj.setV_name(rs.getString("V_name"));
               obj.setV_address(rs.getString("V_address"));
               obj.setV_contactP(rs.getString("V_contactP"));
               obj.setV_phone(rs.getString("V_phone"));
             }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :"+ex.getMessage());
        }
        return obj;
    }
      public ArrayList<Vendor> searchVendor(String text)
    {
        ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Vendor where (V_ID like '"+text+"%' or V_name like '"+text+"%')";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Vendor obj = new Vendor();
               obj.setV_id(rs.getInt("V_ID"));
               obj.setV_name(rs.getString("V_name"));
               obj.setV_address(rs.getString("V_address"));
               obj.setV_contactP(rs.getString("V_contactP"));
               obj.setV_phone(rs.getString("V_phone"));

               vendorList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Vendor Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return vendorList; 
    }
}
