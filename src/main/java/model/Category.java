package model;

public class Category {

    int id_category, in_item;
    String title;

    public Category(int id_category, String title) {
        this.id_category = id_category;
        this.title = title;
    }

    public Category(int id_category, String title, int in_item) { // category table
        this(id_category, title);
        this.in_item = in_item;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getIn_item() {
        return in_item;
    }

    public void setIn_item(int in_item) {
        this.in_item = in_item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
