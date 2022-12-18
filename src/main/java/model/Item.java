package model;

public class Item {

    int id_item, id_category, in_stock, in_transaction;
    String title, description, category;
    float price;

    public Item(int id_item, int id_category, String title, String description, float price, int in_stock) {
        this.id_item = id_item;
        this.id_category = id_category;
        this.in_stock = in_stock;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Item(int id_item, int id_category, String title, String description, float price, int in_stock, String category) { // Transaction Table
        this(id_item, id_category, title, description, price, in_stock);
        this.category = category;
    }

    public Item(int id_item, int id_category, String title, String description, float price, int in_stock, String category, int in_transaction) { // Item Table
        this(id_item, id_category, title, description, price, in_stock, category);
        this.in_transaction = in_transaction;
    }

    public Item searchItem(String title) {
        return this;
    }

    public boolean isAvailable() {
        return in_stock > 0;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(int in_stock) {
        this.in_stock = in_stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIn_transaction() {
        return in_transaction;
    }

    public void setIn_transaction(int in_transaction) {
        this.in_transaction = in_transaction;
    }

}
