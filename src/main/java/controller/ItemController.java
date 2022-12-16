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
}
