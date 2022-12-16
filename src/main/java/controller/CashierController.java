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

    public static ArrayList<Cashier> get() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT * FROM employee e JOIN cashier c ON e.id_employee = c.id_employee";
        ArrayList<Cashier> c = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next())  {
            c.add(new Cashier(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getInt("transaction_handled")));
        }
        return c;
    }
}
