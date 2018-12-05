/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.PO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shiyanrox
 */
public class ViewIssuedPOtoVendor extends javax.swing.JFrame {

    /**
     * Creates new form ViewIssuedPOtoVendor
     */
    public ViewIssuedPOtoVendor() {
        initComponents();
        this.loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPOVfind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPOVVFind = new javax.swing.JButton();
        dcFrom = new com.toedter.calendar.JDateChooser();
        dcTo = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPOVV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DistributerX: Purchasing Order to Vendor View");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("View Issued PO to Vendors"));

        jLabel1.setText("Name");

        jLabel2.setText("From");

        jLabel3.setText("To");

        btnPOVVFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/FontAwesome_f002(0)_24.png"))); // NOI18N
        btnPOVVFind.setText("Find");
        btnPOVVFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPOVVFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPOVfind, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcTo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPOVVFind)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPOVfind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addComponent(jLabel3))
                    .addComponent(dcTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnPOVVFind)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblPOVV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "PO No", "Vendor Name", "Issued date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPOVV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPOVVMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPOVV);
        if (tblPOVV.getColumnModel().getColumnCount() > 0) {
            tblPOVV.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPOVVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPOVVMouseReleased
        DefaultTableModel dtm = (DefaultTableModel) tblPOVV.getModel();
        int Status;
        if(Boolean.parseBoolean(dtm.getValueAt(tblPOVV.getSelectedRow(), 4).toString())){Status=1;}
        else
        {
            Status=0;
        }
        PO obj=new PO();
        obj.setPOno(Integer.parseInt(dtm.getValueAt(tblPOVV.getSelectedRow(), 1).toString()));
        obj.setStatus(Status);
        boolean result = new PO().updatePO(obj);
        if (result) {
            if (Status==1) {
            JOptionPane.showMessageDialog(rootPane, "PO Activated Successfully", "Oparation Complete", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "PO Canceled Successfully", "Oparation Incomplete", JOptionPane.INFORMATION_MESSAGE);
        }        } else {
            JOptionPane.showMessageDialog(rootPane, "Error in Oparation", "Oparation Incomplete", JOptionPane.ERROR);
        }
                
    }//GEN-LAST:event_tblPOVVMouseReleased

    private void btnPOVVFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPOVVFindActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fDate=null;
        String tDate=null;
        Date FromDate = dcFrom.getDate();
        Date ToDate = dcTo.getDate();
        if (FromDate != null & ToDate != null) {
            int comp = FromDate.compareTo(ToDate);
            if (comp <= 0) {
                fDate = df.format(FromDate);
                tDate = df.format(ToDate);
            } else {
                JOptionPane.showMessageDialog(rootPane, "From Date is Higher than To Date!", "Oops", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (FromDate != null) {
            fDate = df.format(FromDate);
        } else if (ToDate != null) {
            tDate = df.format(ToDate);
        }
        
        this.findPOByFilter(txtPOVfind.getText(), fDate, tDate);
    }//GEN-LAST:event_btnPOVVFindActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedPOtoVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedPOtoVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedPOtoVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedPOtoVendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIssuedPOtoVendor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPOVVFind;
    private com.toedter.calendar.JDateChooser dcFrom;
    private com.toedter.calendar.JDateChooser dcTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPOVV;
    private javax.swing.JTextField txtPOVfind;
    // End of variables declaration//GEN-END:variables
private void loadTable() {
        PO POobj = new PO();
        ArrayList<PO> POList = POobj.loadPO();
        if (POList.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Sorry ! No PO Found.");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tblPOVV.getModel();
            dtm.setRowCount(0);
            int count = 0;
            while (POList.size() > count) {
                Vector v = new Vector();
                PO po = new PO();
                po = POList.get(count);
                v.add(count + 1);
                v.add(po.getPOno());
                v.add(po.getVender());
                v.add(po.getDate());
                if(po.getStatus()==1) {v.add(true);} else {v.add(false);}
                

                dtm.addRow(v);
                count++;

            }
        }

    }
private void findPOByFilter(String vendor,String fDate,String tDate) {
        PO POobj = new PO();
        ArrayList<PO> POList = POobj.searchPOByFilter(vendor, fDate, tDate);
        if (POList.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Sorry ! No PO Found.");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tblPOVV.getModel();
            dtm.setRowCount(0);
            int count = 0;
            while (POList.size() > count) {
                Vector v = new Vector();
                PO po = new PO();
                po = POList.get(count);
                v.add(count + 1);
                v.add(po.getPOno());
                v.add(po.getVender());
                v.add(po.getDate());
                if(po.getStatus()==1) {v.add(true);} else {v.add(false);}
                

                dtm.addRow(v);
                count++;

            }
        }

    }
}
