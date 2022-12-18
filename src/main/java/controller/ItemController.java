package controller;

import db.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Item;

public class ItemController {

    public static ArrayList<Item> get() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT i.*, c.title category FROM item i JOIN category c ON i.id_category = c.id_category";
        ArrayList<Item> items = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            items.add(new Item(rs.getInt("id_item"), rs.getInt("id_category"), rs.getString("title"), rs.getString("description"), rs.getFloat("price"), rs.getInt("in_stock"), rs.getString("category")));
        }
        return items;
    }

    public static ArrayList<Item> getWithConstraint() throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        ResultSet rs;
        String sql = "SELECT i.*, c.title,  c.title category, COUNT(dt.id_detail_transaction) in_transaction FROM item i JOIN category c ON i.id_category = c.id_category LEFT JOIN detail_transaction dt ON i.id_item = dt.id_item GROUP BY i.id_item";
        ArrayList<Item> items = new ArrayList<>();
        st.execute(sql);
        rs = st.getResultSet();
        while (rs.next()) {
            items.add(new Item(rs.getInt("id_item"), rs.getInt("id_category"), rs.getString("title"), rs.getString("description"), rs.getFloat("price"), rs.getInt("in_stock"), rs.getString("category"), rs.getInt("in_transaction")));
        }
        return items;
    }

    public static boolean delete(int id_item) throws SQLException {
        Connection db = Connect.getConnection();
        Statement st = db.createStatement();
        String sql = "DELETE FROM item WHERE id_item = " + id_item;
        st.executeUpdate(sql);
        return true;
    }
}
