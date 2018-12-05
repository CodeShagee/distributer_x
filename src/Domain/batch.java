/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAL.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Shiyanrox
 */
public class batch {
    private int BID;
    private String Bname;
    private String Bdate;

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public String getBdate() {
        return Bdate;
    }

    public void setBdate(String Bdate) {
        this.Bdate = Bdate;
    }
      public boolean addBatch(batch obj)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into Batch (Bname,Bdate) values('"+obj.getBname()+"','"+obj.getBdate()+"')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean updateBatch(batch obj)
    {
       DBConnection objDBcon = new DBConnection();
        String qry = "update Batch set Bname='"+obj.getBname()+"',Bdate='"+obj.getBdate()+"' where BID='"+obj.getBID()+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean deleteBatch(int bid)
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "delete from Batch where BID='"+bid+"'";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public int getLastBID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(BID) as maxid from Batch";
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
             JOptionPane.showMessageDialog(null, "Error While Batch Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        return id;
    }
     public ArrayList<batch> loadbatch()
    {
        ArrayList<batch> batchList = new ArrayList<batch>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from batch";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              batch obj = new batch();
               obj.setBID(rs.getInt("BID"));
               obj.setBname(rs.getString("Bname"));
               obj.setBdate(rs.getString("Bdate"));
               

               batchList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While batch Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return batchList; 
    }
     public batch viewAbatch(int id)
    {
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from batch where BID='"+id+"'";
         batch obj = new batch();
         try {
             ResultSet rs = objDBcon.excuteReturnQry(qry);
             while(rs.next())
             {
                 
            
               obj.setBID(rs.getInt("BID"));
               obj.setBname(rs.getString("Bname"));
               obj.setBdate(rs.getString("Bdate"));
             }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Book Finding :"+ex.getMessage());
        }
        return obj;
    }
     public ArrayList<batch> searchbatch(String text)
    {
        ArrayList<batch> batchList = new ArrayList<batch>();
        
         DBConnection objDBcon = new DBConnection();
         String qry = "Select * from batch where (BID like '"+text+"%' or Bname like '"+text+"%')";
         try
         {
            ResultSet rs = objDBcon.excuteReturnQry(qry);
             
            while(rs.next())
            {
              batch obj = new batch();
                obj.setBID(rs.getInt("BID"));
               obj.setBname(rs.getString("Bname"));
               obj.setBdate(rs.getString("Bdate"));

               batchList.add(obj);                                                  
            }
            
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Error While batch Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         
       return batchList; 
    }
     
}
