/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CategoryController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Cashier;
import model.Category;
import view.components.Popup;

/**
 *
 * @author Evan Henderson
 */
public class Categories extends javax.swing.JFrame {

    static Cashier loggedEmployee;

    static final String[] headers = {
        "ID Category", "Title", "In Items"
    };

    static DefaultTableModel model = new DefaultTableModel(headers, 0);

    static ArrayList<Category> sourceData;

    static void resetData() {
        try {
            sourceData = CategoryController.get();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for (Category category : sourceData) {
                String[] rowData = {
                    Integer.toString(category.getId_category()),
                    category.getTitle(),
                    Integer.toString(category.getIn_item())};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form Categories
     */
    public Categories() {
        try {
            initComponents();
            sourceData = CategoryController.get();
            if (!sourceData.isEmpty()) {
                categoryTable.setModel(model);
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (Category category : sourceData) {
                    String[] rowData = {
                        Integer.toString(category.getId_category()),
                        category.getTitle(),
                        Integer.toString(category.getIn_item())};
                    model.addRow(rowData);
                }
            }

            categoryTable.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == 10) {
                        try {
                            int selectedRow = categoryTable.getSelectedRow();
                            int id_category = Integer.parseInt(categoryTable.getModel().getValueAt(selectedRow, 0).toString());
                            String title = categoryTable.getModel().getValueAt(selectedRow, 1).toString();
                            CategoryController.update(id_category, title);
                        } catch (SQLException ex) {
                            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Categories(Cashier employee) {
        this();
        loggedEmployee = employee;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        newCategory = new javax.swing.JButton();
        deleteCategory = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        transactionTable = new javax.swing.JMenuItem();
        itemTable = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categories");

        jScrollPane1.setViewportView(categoryTable);

        newCategory.setText("New Category");
        newCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCategoryActionPerformed(evt);
            }
        });

        deleteCategory.setText("Delete Category");
        deleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        transactionTable.setText("Transaction Table");
        transactionTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionTableActionPerformed(evt);
            }
        });
        jMenu1.add(transactionTable);

        itemTable.setText("Item Table");
        itemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTableActionPerformed(evt);
            }
        });
        jMenu1.add(itemTable);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newCategory)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCategory)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCategory)
                    .addComponent(deleteCategory))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void itemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTableActionPerformed
        this.dispose();
        Items itemTable = new Items(loggedEmployee);
        itemTable.setVisible(true);
    }//GEN-LAST:event_itemTableActionPerformed

    private void transactionTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionTableActionPerformed
        try {
            this.dispose();
            Transactions transactionTable = new Transactions(loggedEmployee);
            transactionTable.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_transactionTableActionPerformed

    private void newCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCategoryActionPerformed
        CategoryAdd ca = new CategoryAdd(this, true);
        ca.setVisible(true);
        categoryTable.setModel(model);
        resetData();
    }//GEN-LAST:event_newCategoryActionPerformed

    private void deleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryActionPerformed
        int selectedRow = categoryTable.getSelectedRow();
        Category selectedItem = sourceData.get(selectedRow);
        if (selectedItem.getIn_item() > 0) {
            Popup p = new Popup("Integrity Constraint Warning", "This category has interconnected item");
            p.setVisible(true);
        } else {
            try {
                CategoryController.delete(selectedItem.getId_category());
                resetData();
            } catch (SQLException ex) {
                Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton deleteCategory;
    private javax.swing.JMenuItem itemTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JButton newCategory;
    private javax.swing.JMenuItem transactionTable;
    // End of variables declaration//GEN-END:variables
}
