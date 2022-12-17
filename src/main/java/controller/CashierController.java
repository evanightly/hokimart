package controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cashier;
import db.Connect;
import java.sql.ResultSet;
import java.sql.Statement;

public class CashierController {

    public static boolean add(int id_employee, String name, String username, String password, int age, float salary, int years_experienced) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        String sql = String.format("INSERT INTO employee (id_employee, name, username, password, age, salary, years_experienced) VALUES(%d, '%s', '%s', '%s', %d, %f, %d)", id_employee, name, username, password, age, salary, years_experienced);
        st.executeUpdate(sql);
        sql = String.format("INSERT INTO cashier (id_employee, transaction_handled) VALUES(%d, %d)", id_employee, 0);
        st.executeUpdate(sql);
        return true;
    }

    public static ArrayList<Cashier> get() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT *, COUNT(t.id_transaction) total_transaction_handled FROM employee e JOIN cashier c ON e.id_employee = c.id_employee LEFT JOIN transaction t ON c.id_employee = t.id_employee GROUP BY e.id_employee";
        ArrayList<Cashier> c = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            c.add(new Cashier(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getInt("total_transaction_handled")));
        }
        return c;
    }

    public static int getLastCashierId() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT id_employee FROM employee ORDER BY id_employee DESC LIMIT 1";
        st.execute(sql);
        rs = st.getResultSet();
        rs.next();
        return rs.getInt("id_employee");
    }

    public static boolean delete(int id_employee) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT * FROM employee e JOIN transaction t ON e.id_employee = t.id_employee WHERE e.id_employee = " + id_employee;
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            TransactionController.delete(rs.getInt("id_transaction"));
        }
        sql = "DELETE FROM cashier WHERE id_employee = " + id_employee;
        st.executeUpdate(sql);
        sql = "DELETE FROM employee WHERE id_employee = " + id_employee;
        st.executeUpdate(sql);
        return true;
    }
}
