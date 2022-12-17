/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TransactionController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Cashier;
import model.Transaction;

/**
 *
 * @author Evan Henderson
 */
public class Transactions extends javax.swing.JFrame {

    static Cashier loggedEmployee;
    static final String[] headers = {"# Transaction", "Employee Name", "Customer Name", "Transaction Date", "Total"};
    static DefaultTableModel model = new DefaultTableModel(headers, 0);
    static ArrayList<Transaction> sourceData;

    /**
     * Creates new form Transaction
     *
     * @throws java.sql.SQLException
     */
    public Transactions() throws SQLException {
        initComponents();
        sourceData = TransactionController.get();
        if (sourceData.size() > 0) {
            transactionTable.setModel(model);
            System.out.println("Before Insert: " + sourceData.size());
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for (Transaction transaction : sourceData) {
                String[] rowData = {
                    Integer.toString(transaction.getId_transaction()),
                    transaction.getEmployee_name(),
                    transaction.getCustomer_name(),
                    transaction.getTransaction_date(),
                    Float.toString(transaction.getTotal())
                };
                model.addRow(rowData);
            }
        } 

    }

    public Transactions(Cashier cashier) throws SQLException {
        this();
        this.loggedEmployee = cashier;
        System.out.println(loggedEmployee.getName());
        System.out.println(loggedEmployee.getId_employee());
        this.loggedEmployeeName.setText("Employee: " + loggedEmployee.getName());
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
        transactionTable = new javax.swing.JTable();
        newTransaction = new javax.swing.JButton();
        loggedEmployeeName = new javax.swing.JLabel();
        deleteTransaction = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemTable = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transactions");

        transactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transactionTable);

        newTransaction.setText("New Transaction");
        newTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTransactionActionPerformed(evt);
            }
        });

        loggedEmployeeName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        loggedEmployeeName.setText("Employee : ");

        deleteTransaction.setText("Delete Selected Transaction");
        deleteTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTransactionActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        itemTable.setText("Item Table");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteTransaction)
                        .addGap(18, 18, 18)
                        .addComponent(newTransaction))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loggedEmployeeName)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedEmployeeName)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTransaction)
                    .addComponent(deleteTransaction))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void transactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTableMouseClicked
        try {
            int selectedRow = transactionTable.getSelectedRow();
            ArrayList<Transaction> sourceData = TransactionController.get();
            int selectedTransactionId = sourceData.get(selectedRow).getId_transaction();
            new TransactionDetail(selectedTransactionId);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_transactionTableMouseClicked

    private void newTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTransactionActionPerformed
        this.dispose();
        try {
            sourceData.clear();
            TransactionAdd ta = new TransactionAdd(loggedEmployee);
            ta.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newTransactionActionPerformed

    private void deleteTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTransactionActionPerformed
        int[] selectedRows = transactionTable.getSelectedRows();

        for (int selectedRow : selectedRows) {
            try {
                ArrayList<Transaction> sourceData = TransactionController.get();
                int selectedTransactionId = sourceData.get(selectedRow).getId_transaction();
                TransactionController.delete(selectedTransactionId);
                sourceData = TransactionController.get();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (Transaction transaction : sourceData) {
                    String[] rowData = {
                        Integer.toString(transaction.getId_transaction()),
                        transaction.getEmployee_name(),
                        transaction.getCustomer_name(),
                        transaction.getTransaction_date(),
                        Float.toString(transaction.getTotal())
                    };
                    model.addRow(rowData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteTransactionActionPerformed

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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Transactions().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteTransaction;
    private javax.swing.JMenuItem itemTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loggedEmployeeName;
    private javax.swing.JMenuItem logout;
    private javax.swing.JButton newTransaction;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
