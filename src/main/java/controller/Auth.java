package controller;

import db.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cashier;
import model.Manager;

public class Auth {

    private static Connection db = Connect.getConnection();

    public static boolean login(String username, String password) throws SQLException {
        Statement st = db.createStatement();
        ResultSet rs;
        st = db.createStatement();
        String sql = String.format("SELECT * FROM employee e JOIN cashier m ON e.id_employee = m.id_employee WHERE username = '%s' AND password = '%s'", username, password);
        st.execute(sql);
        rs = st.getResultSet();
        return true;
    }
    
//    public static String getAll(Connection db) throws SQLException {
//        st = db.createStatement();
//        String sql = "SELECT * FROM employee";
//        List<Cashier> c = new ArrayList<>();
//        st.execute(sql);
//        rs = st.getResultSet();
//        while (rs.next()) {
//            c.add(new Cashier(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getInt("transaction_handled")));
//        }
//        return '';
//    }
}
