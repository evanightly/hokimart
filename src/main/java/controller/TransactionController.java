package controller;

import db.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Transaction;

public class TransactionController {

    public static boolean add(int id_transaction, int id_employee, String customer_name, float total) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        String sql = String.format("INSERT INTO transaction (id_transaction, id_employee, customer_name, total) VALUES(%d, %d, '%s', %f)", id_transaction, id_employee, customer_name, total);
        st.executeUpdate(sql);
        return true;
    }

    public static ArrayList<Transaction> get() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT t.*, e.name FROM transaction t JOIN employee e ON t.id_employee = e.id_employee";
        ArrayList<Transaction> transactions = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            transactions.add(new Transaction(rs.getInt("id_transaction"), rs.getString("name"), rs.getString("customer_name"), rs.getString("transaction_date"), rs.getFloat("total")));
        }
        return transactions;
    }

    public static int getLastTransactionId() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT id_transaction FROM transaction ORDER BY id_transaction DESC LIMIT 1";
        st.execute(sql);
        rs = st.getResultSet();
        rs.next();
        return rs.getInt("id_transaction");
    }
}
