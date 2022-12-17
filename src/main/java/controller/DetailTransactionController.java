package controller;

import db.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Detail_Transaction;

public class DetailTransactionController {
//    SELECT i.title item, c.title category, i.description, i.price, dt.quantity, dt.subtotal FROM transaction t JOIN detail_transaction dt ON t.id_transaction = dt.id_transaction JOIN item i ON dt.id_item = i.id_item JOIN category c ON i.id_category = c.id_category WHERE t.id_transaction = 1;

    public static boolean add(int id_transaction, int id_item, int quantity, float subtotal) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        System.out.println(id_transaction);
        System.out.println(id_item);
        System.out.println(quantity);
        System.out.println(subtotal);
        String sql = String.format("INSERT INTO detail_transaction (id_transaction, id_item, quantity, subtotal) VALUES(%d, %d, %d, %f)", id_transaction, id_item, quantity, subtotal);
        st.executeUpdate(sql);
        return true;
    }

    public static ArrayList<Detail_Transaction> get(int id_transaction) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT i.title item, c.title category, i.description, i.price, dt.quantity, dt.subtotal  FROM transaction t JOIN detail_transaction dt ON t.id_transaction = dt.id_transaction JOIN item i ON dt.id_item = i.id_item JOIN category c ON i.id_category = c.id_category  WHERE t.id_transaction = " + id_transaction;
        ArrayList<Detail_Transaction> detailTransactions = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            detailTransactions.add(new Detail_Transaction(rs.getString("item"), rs.getString("category"), rs.getString("description"), rs.getFloat("price"), rs.getFloat("subtotal"), rs.getInt("quantity")));
        }
        return detailTransactions;
    }
    
    public static boolean delete(int id_detail_transaction) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        String sql = "DELETE FROM detail_transaction WHERE id_detail_transaction = " + id_detail_transaction;
        st.executeUpdate(sql);
        return true;
    }

    
}
