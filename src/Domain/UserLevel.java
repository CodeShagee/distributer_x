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
public class UserLevel {

    private int lvlID;
    private String lvlName;
    private int product;
    private int batch;
    private int category;
    private int stock;
    private int customer;
    private int vendor;
    private int invoice;
    private int po;
    private int so;
    private int PurchaseRtn;
    private int saleRtn;
    private int GRN;
    private int user;
    private int UsarLvl;
    private int reports;

    public int getLvlID() {
        return lvlID;
    }

    public void setLvlID(int lvlID) {
        this.lvlID = lvlID;
    }

    public String getLvlName() {
        return lvlName;
    }

    public void setLvlName(String lvlName) {
        this.lvlName = lvlName;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getVendor() {
        return vendor;
    }

    public void setVendor(int vendor) {
        this.vendor = vendor;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getPurchaseRtn() {
        return PurchaseRtn;
    }

    public void setPurchaseRtn(int PurchaseRtn) {
        this.PurchaseRtn = PurchaseRtn;
    }

    public int getSaleRtn() {
        return saleRtn;
    }

    public void setSaleRtn(int saleRtn) {
        this.saleRtn = saleRtn;
    }

    public int getGRN() {
        return GRN;
    }

    public void setGRN(int GRN) {
        this.GRN = GRN;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getUsarLvl() {
        return UsarLvl;
    }

    public void setUsarLvl(int UsarLvl) {
        this.UsarLvl = UsarLvl;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }

    public boolean addUserLevel(UserLevel obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "insert into userlevel (lvlName,product,batch,category,stock,customer,vendor,invoice,po,so,PurchaseRtn,saleRtn,GRN,user,UsarLvl,reports) values('" + obj.getLvlName() + "','" + obj.getProduct() + "','" + obj.getBatch() + "','" + obj.getCategory() + "','" + obj.getStock() + "','" + obj.getCustomer() + "','" + obj.getVendor() + "','" + obj.getInvoice() + "','" + obj.getPo() + "','" + obj.getSo() + "','" + obj.getPurchaseRtn() + "','" + obj.getSaleRtn() + "','" + obj.getGRN() + "','" + obj.getUser() + "','" + obj.getUsarLvl() + "','" + obj.getReports() + "')";//,'" + obj.getBPrice()+ "','" + obj.getPDescription() + "','" + obj.getBPrice() + "','" + obj.getQty() + "','" + obj.getAmount() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }
    public boolean updateUserLevel(UserLevel obj) {
        DBConnection objDBcon = new DBConnection();
        String qry = "update userlevel set lvlName='"+obj.getLvlName()+"',product ='" + obj.getProduct() + "',batch='" + obj.getBatch() + "',category='" + obj.getCategory() + "',stock='" + obj.getStock() + "',customer='" + obj.getCustomer() + "',vendor='" + obj.getVendor() + "',invoice='" + obj.getInvoice() + "',po='" + obj.getPo() + "',so='" + obj.getSo() + "',PurchaseRtn='" + obj.getPurchaseRtn() + "',saleRtn='" + obj.getSaleRtn() + "',GRN='" + obj.getGRN() + "',user='" + obj.getUser() + "',UsarLvl='" + obj.getUsarLvl() + "',reports='" + obj.getReports() + "' where lvlID='"+obj.getLvlID()+"'";//,'" + obj.getBPrice()+ "','" + obj.getPDescription() + "','" + obj.getBPrice() + "','" + obj.getQty() + "','" + obj.getAmount() + "')";
        boolean flag = objDBcon.excuteNonReturnQry(qry);
        return flag;
    }

    public ArrayList<UserLevel> loadUserLevel() {
        ArrayList<UserLevel> UserLevelList = new ArrayList<UserLevel>();

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from userlevel";
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                UserLevel obj = new UserLevel();
                obj.setLvlID(rs.getInt("lvlID"));
                obj.setLvlName(rs.getString("lvlName"));
                obj.setProduct(rs.getInt("product"));
                obj.setBatch(rs.getInt("batch"));
                obj.setCategory(rs.getInt("category"));
                obj.setStock(rs.getInt("stock"));
                obj.setCustomer(rs.getInt("customer"));
                obj.setVendor(rs.getInt("vendor"));
                obj.setInvoice(rs.getInt("invoice"));
                obj.setPo(rs.getInt("po"));
                obj.setSo(rs.getInt("so"));
                obj.setPurchaseRtn(rs.getInt("PurchaseRtn"));
                obj.setSaleRtn(rs.getInt("saleRtn"));
                obj.setGRN(rs.getInt("GRN"));
                obj.setUser(rs.getInt("user"));
                obj.setUsarLvl(rs.getInt("UsarLvl"));
                obj.setReports(rs.getInt("reports"));

                UserLevelList.add(obj);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return UserLevelList;
    }
    public int getLastUserLvlID()
    {
        DBConnection objDBcon = new DBConnection();
        String qry = "select MAX(lvlID) as maxid from userlevel";
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
             JOptionPane.showMessageDialog(null, "Error While  Loading :"+ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        return id;
    }
    public UserLevel viewUserLevel(int id) {
        

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from userlevel where lvlID = '"+id+"'";
        UserLevel obj = new UserLevel();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                
                obj.setLvlID(rs.getInt("lvlID"));
                obj.setLvlName(rs.getString("lvlName"));
                obj.setProduct(rs.getInt("product"));
                obj.setBatch(rs.getInt("batch"));
                obj.setCategory(rs.getInt("category"));
                obj.setStock(rs.getInt("stock"));
                obj.setCustomer(rs.getInt("customer"));
                obj.setVendor(rs.getInt("vendor"));
                obj.setInvoice(rs.getInt("invoice"));
                obj.setPo(rs.getInt("po"));
                obj.setSo(rs.getInt("so"));
                obj.setPurchaseRtn(rs.getInt("PurchaseRtn"));
                obj.setSaleRtn(rs.getInt("saleRtn"));
                obj.setGRN(rs.getInt("GRN"));
                obj.setUser(rs.getInt("user"));
                obj.setUsarLvl(rs.getInt("UsarLvl"));
                obj.setReports(rs.getInt("reports"));

                
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return obj;
    }
    public UserLevel getUserLevel(String name) {
        

        DBConnection objDBcon = new DBConnection();
        String qry = "Select * from userlevel where lvlName = '"+name+"'";
        UserLevel obj = new UserLevel();
        try {
            ResultSet rs = objDBcon.excuteReturnQry(qry);

            while (rs.next()) {
                
                obj.setLvlID(rs.getInt("lvlID"));
                obj.setLvlName(rs.getString("lvlName"));
                obj.setProduct(rs.getInt("product"));
                obj.setBatch(rs.getInt("batch"));
                obj.setCategory(rs.getInt("category"));
                obj.setStock(rs.getInt("stock"));
                obj.setCustomer(rs.getInt("customer"));
                obj.setVendor(rs.getInt("vendor"));
                obj.setInvoice(rs.getInt("invoice"));
                obj.setPo(rs.getInt("po"));
                obj.setSo(rs.getInt("so"));
                obj.setPurchaseRtn(rs.getInt("PurchaseRtn"));
                obj.setSaleRtn(rs.getInt("saleRtn"));
                obj.setGRN(rs.getInt("GRN"));
                obj.setUser(rs.getInt("user"));
                obj.setUsarLvl(rs.getInt("UsarLvl"));
                obj.setReports(rs.getInt("reports"));

                
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error While  Loading :" + ex.getMessage());
            // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return obj;
    }

}
