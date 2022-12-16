package model;

public class Detail_Transaction {

    int id_detail_transaction, id_transaction, id_item, quantity;
    float subtotal;

    String cItem, cCategory, cDescription;
    float cPrice, cSubtotal;
    int cQuantity;

    int cartIdTransaction, cartIdItem, cartQuantity;
    float cartItemPrice, cartSubtotal;
    String cartItemTitle, cartCategory;

    public Detail_Transaction(int id_detail_transaction, int id_transaction, int id_item, int quantity, float subtotal) {
        this.id_detail_transaction = id_detail_transaction;
        this.id_transaction = id_transaction;
        this.id_item = id_item;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Detail_Transaction(String cItem, String cCategory, String cDescription, float cPrice, float cSubtotal, int cQuantity) {
        this.cItem = cItem;
        this.cCategory = cCategory;
        this.cDescription = cDescription;
        this.cPrice = cPrice;
        this.cSubtotal = cSubtotal;
        this.cQuantity = cQuantity;
    }

    public Detail_Transaction(int cartIdTransaction, int cartIdItem, int cartQuantity, float cartItemPrice, float cartSubtotal, String cartItemTitle, String cartCategory) {
        this.cartIdTransaction = cartIdTransaction;
        this.cartIdItem = cartIdItem;
        this.cartQuantity = cartQuantity;
        this.cartItemPrice = cartItemPrice;
        this.cartSubtotal = cartSubtotal;
        this.cartItemTitle = cartItemTitle;
        this.cartCategory = cartCategory;
    }

    public int getCartIdTransaction() {
        return cartIdTransaction;
    }

    public void setCartIdTransaction(int cartIdTransaction) {
        this.cartIdTransaction = cartIdTransaction;
    }

    public int getCartIdItem() {
        return cartIdItem;
    }

    public void setCartIdItem(int cartIdItem) {
        this.cartIdItem = cartIdItem;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public float getCartSubtotal() {
        return cartSubtotal;
    }

    public void setCartSubtotal(float cartSubtotal) {
        this.cartSubtotal = cartSubtotal;
    }

    public String getCartItemTitle() {
        return cartItemTitle;
    }

    public void setCartItemTitle(String cartItemTitle) {
        this.cartItemTitle = cartItemTitle;
    }

    public String getCartCategory() {
        return cartCategory;
    }

    public void setCartCategory(String cartCategory) {
        this.cartCategory = cartCategory;
    }

    public int getId_detail_transaction() {
        return id_detail_transaction;
    }

    public void setId_detail_transaction(int id_detail_transaction) {
        this.id_detail_transaction = id_detail_transaction;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getcItem() {
        return cItem;
    }

    public void setcItem(String cItem) {
        this.cItem = cItem;
    }

    public String getcCategory() {
        return cCategory;
    }

    public void setcCategory(String cCategory) {
        this.cCategory = cCategory;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public float getcPrice() {
        return cPrice;
    }

    public void setcPrice(float cPrice) {
        this.cPrice = cPrice;
    }

    public float getcSubtotal() {
        return cSubtotal;
    }

    public void setcSubtotal(float cSubtotal) {
        this.cSubtotal = cSubtotal;
    }

    public int getcQuantity() {
        return cQuantity;
    }

    public void setcQuantity(int cQuantity) {
        this.cQuantity = cQuantity;
    }

    public float getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(float cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }
    
}
