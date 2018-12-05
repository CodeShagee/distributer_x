/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Shiyanrox
 */
public class test {
    public static void main(String[] args) {
        test ob = new test();
        try {
            ob.genRep();
        } catch (DocumentException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void genRep() throws DocumentException, FileNotFoundException{
    Customer obj = new Customer();
    ArrayList<Customer> custList= obj.loadCustomer();
    custRep();
    
   /* Document doc = new Document();
        PdfPTable pt = new PdfPTable(6);
    PdfWriter.getInstance(doc,new FileOutputStream("test.pdf"));
    
    doc.open();
    doc.add(new Paragraph("Customer Details"));
    for(int i=0;custList.size()>i;i++)
    {
        Customer lobj = custList.get(i);
        pt.addCell((i+1)+"");
        pt.addCell(lobj.getC_id()+"");
        pt.addCell(lobj.getC_name());
        pt.addCell(lobj.getC_address());
        pt.addCell(lobj.getC_contactP());
        pt.addCell(lobj.getC_phone());
        pt.completeRow();
    }
    doc.add(pt);
    doc.close();
           */
    
    
    }
    private boolean custRep()
{
    boolean flag=false;
    try {
        Customer lobj = new Customer();
//           JRTableModelDataSource ds = new JRTableModelDataSource(null);
        List<Map<String,Object>> dataSource = new ArrayList<Map<String,Object>>();
            String rs = "src\\Domain\\newReport.jrxml";
            for(Customer obj:lobj.loadCustomer()){
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("C_id", obj.getC_id());
            param.put("C_name", obj.getC_name());
            param.put("C_address", obj.getC_address());
            param.put("C_contactP", obj.getC_contactP());
            param.put("C_phone", obj.getC_phone());
            dataSource.add(param);
            }
            JRDataSource ds =new JRBeanCollectionDataSource(dataSource);
            
            JasperReport jr = JasperCompileManager.compileReport(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, ds);
            JasperViewer jv = new JasperViewer(jp);
//            jv.setVisible(true);
           
            flag =true;
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return flag;
}
    
}
