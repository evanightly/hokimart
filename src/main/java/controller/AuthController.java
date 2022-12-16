package controller;

import db.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cashier;
import model.Employee;
import model.Manager;

public class AuthController {

    private static Connection db;
    private static Statement st;
    private static ResultSet rs;

    public static Employee login(String username, String password) throws SQLException {
        Employee employee = null;
        db = Connect.getConnection();
        st = db.createStatement();
        String sql = String.format("SELECT * FROM employee e JOIN manager m ON e.id_employee = m.id_employee WHERE username = '%s' AND password = '%s'", username, password);
        st.execute(sql);
        System.out.println("Manager");
        rs = st.getResultSet();
        if (rs.next()) {
//            int id_employee, String name, String username, String password, int age, float salary, int years_experienced, String roleTitle
            employee = new Manager(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getString("role_title"));
        } else {
            sql = String.format("SELECT * FROM employee e JOIN cashier c ON e.id_employee = c.id_employee WHERE username = '%s' AND password = '%s'", username, password);
            st.execute(sql);
            System.out.println("Cashier");
            rs = st.getResultSet();
            if (rs.next()) {
                employee = new Cashier(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getInt("transaction_handled"));
            }
        }
        return employee;
//        String sql = String.format("SELECT * FROM employee e JOIN cashier c ON e.id_employee = c.id_employee WHERE username = '%s' AND password = '%s'", username, password);
//        if (st.execute(sql)) {
//            System.out.println("Cashier");
//            rs = st.getResultSet();
//            while (rs.next()) {
//                return new Cashier(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getInt("transaction_handled"));
//            }
//        } else {
//            sql = String.format("SELECT * FROM employee e JOIN manager m ON e.id_employee = m.id_employee WHERE username = '%s' AND password = '%s'", username, password);
//            st.execute(sql);
//            System.out.println("Manager");
//            rs = st.getResultSet();
//            while (rs.next()) {
//                return new Manager(rs.getInt("id_employee"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("age"), rs.getFloat("salary"), rs.getInt("years_experienced"), rs.getString("role_title"));
//            }
//        }
    }
}
