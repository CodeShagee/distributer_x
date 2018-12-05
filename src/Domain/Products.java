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
public class Products {
    private int PID;
    private String Description;
    private String catname;
    private String VendorName;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }
    
      public boolean addProduct(Products obj)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Product (Description,catname,VendorName) values('"+obj.getDescription()+"','"+obj.getCatname()+"','"+obj.getVendorName()+"')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean updateProduct(Products obj)
    {
       DBConnection objDBcon = new DBConnection();
        String qry = "update Product set Description='"+obj.getDescription()+"',catname='"+obj.getCatname()+"',VendorName ='"+obj.getVendorName()+"' where PID='"+obj.getPID()+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean deleteProduct(int id)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "delete from Product where PID='"+id+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public int getLastBID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(PID) as maxid from Product";
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
     public ArrayList<Products> loadProducts()
    {
        ArrayList<Products> ProductsList = new ArrayList<Products>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Product";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Products obj = new Products();
               obj.setPID(rs.getInt("PID"));
               obj.setDescription(rs.getString("Description"));
               obj.setCatname(rs.getString("catname"));
               obj.setVendorName(rs.getString("VendorName"));
               

               ProductsList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Products Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return ProductsList; 
    }
     public Products viewAProducts(int id)
    {
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Product where PID='"+id+"'";
         Products obj = new Products();
         try {
             ResultSet rs = objDBcon.excuteReturnQry(qry);
             while(rs.next())
             {
                 
            
               obj.setPID(rs.getInt("PID"));
               obj.setDescription(rs.getString("Description"));
               obj.setCatname(rs.getString("catname"));
               obj.setVendorName(rs.getString("VendorName"));
             }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :"+ex.getMessage());
        }
        return obj;
    }
     public ArrayList<Products> searchProducts(String text)
    {
        ArrayList<Products> ProductsList = new ArrayList<Products>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Product where (PID like '"+text+"%' or Description like '"+text+"%')";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Products obj = new Products();
              obj.setPID(rs.getInt("PID"));
               obj.setDescription(rs.getString("Description"));
               obj.setCatname(rs.getString("catname"));
               obj.setVendorName(rs.getString("VendorName"));

               ProductsList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Products Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return ProductsList; 
    }
      public ArrayList<Products> loadProductsByVendor(String text,String Vendor)
    {
        ArrayList<Products> ProductsList = new ArrayList<Products>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from Product where VendorName='"+Vendor+"'and Description like '"+text+"%'";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              Products obj = new Products();
              obj.setPID(rs.getInt("PID"));
               obj.setDescription(rs.getString("Description"));
               obj.setCatname(rs.getString("catname"));
               obj.setVendorName(rs.getString("VendorName"));

               ProductsList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While Products Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return ProductsList; 
    }
}
