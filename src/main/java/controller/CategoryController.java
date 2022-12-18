package controller;

import db.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Category;

public class CategoryController {

    public static boolean add(String title) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        String sql = String.format("INSERT INTO category (title) VALUES ('%s')", title);
        st.executeUpdate(sql);
        return true;
    }

    public static ArrayList<Category> get() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT c.*, COUNT(i.id_category) in_item FROM category c LEFT JOIN item i ON c.id_category = i.id_category GROUP BY c.id_category";
        ArrayList<Category> items = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            items.add(new Category(rs.getInt("id_category"), rs.getString("title"), rs.getInt("in_item")));
        }
        return items;
    }

    public static boolean delete(int id_category) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        String sql = "DELETE FROM category WHERE id_category = " + id_category;
        st.executeUpdate(sql);
        return true;
    }

}
