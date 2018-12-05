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
public class Customer {
    private int C_id;
    private String C_name;
    private String C_address;
    private String C_contactP;
    private String C_phone;

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int C_id) {
        this.C_id = C_id;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String C_name) {
        this.C_name = C_name;
    }

    public String getC_address() {
        return C_address;
    }

    public void setC_address(String C_address) {
        this.C_address = C_address;
    }

    public String getC_contactP() {
        return C_contactP;
    }

    public void setC_contactP(String C_contactP) {
        this.C_contactP = C_contactP;
    }

    public String getC_phone() {
        return C_phone;
    }

    public void setC_phone(String C_phone) {
        this.C_phone = C_phone;
    }
         public boolean addCustomer(Customer obj)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Customer (C_name,C_addrees,C_contactP, C_phone) values('"+obj.getC_name()+"','"+obj.getC_address()+"','"+obj.getC_contactP()+"','"+obj.getC_phone()+"')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean updateCustomer(Customer obj)
    {
       DBConnection objDBcon = new DBConnection();
        String qry = "update Customer set C_name='"+obj.getC_name()+"',C_addrees='"+obj.getC_address()+"',C_contactP='"+obj.getC_contactP()+"',C_phone='"+obj.getC_phone()+"' where C_ID='"+obj.getC_id()+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean deleteCustomer(int cid)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "delete from Customer where C_ID='"+cid+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public int getLastCID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(C_ID) as maxid from Customer";
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
             JOptionPane.showMessageDialog(null, "Error While Customer Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        return id;
    }
      public ArrayList<Customer> loadCustomer()
    {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Customer";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Customer obj = new Customer();
               obj.setC_id(rs.getInt("C_ID"));
               obj.setC_name(rs.getString("C_name"));
               obj.setC_address(rs.getString("C_addrees"));
               obj.setC_contactP(rs.getString("C_contactP"));
               obj.setC_phone(rs.getString("C_phone"));

               customerList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Customer Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return customerList; 
    }
     public Customer viewACustomer(int id)
    {
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Customer where C_ID='"+id+"'";
         Customer obj = new Customer();
         try {
             ResultSet rs = objDBcon.excuteReturnQry(qry);
             while(rs.next())
             {
                 
              obj.setC_id(rs.getInt("C_ID"));
               obj.setC_name(rs.getString("C_name"));
               obj.setC_address(rs.getString("C_addrees"));
               obj.setC_contactP(rs.getString("C_contactP"));
               obj.setC_phone(rs.getString("C_phone"));
             }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :"+ex.getMessage());
        }
        return obj;
    }
      public ArrayList<Customer> searchCustomer(String text)
    {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Customer where (C_ID like '"+text+"%' or C_name like '"+text+"%')";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Customer obj = new Customer();
               obj.setC_id(rs.getInt("C_ID"));
               obj.setC_name(rs.getString("C_name"));
               obj.setC_address(rs.getString("C_addrees"));
               obj.setC_contactP(rs.getString("C_contactP"));
               obj.setC_phone(rs.getString("C_phone"));

               customerList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Customer Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return customerList; 
    }
}
