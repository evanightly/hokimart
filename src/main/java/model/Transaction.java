package model;

public class Transaction {

    int id_transaction;
    String employee_name;
    String customer_name;
    String transaction_date;
    float total;

    public Transaction(int id_transaction, String customer_name, String transaction_date, float total) {
        this.id_transaction = id_transaction;
        this.customer_name = customer_name;
        this.transaction_date = transaction_date;
        this.total = total;
    }

    public Transaction(int id_transaction, String employee_name, String customer_name, String transaction_date, float total) {
        this.id_transaction = id_transaction;
        this.customer_name = customer_name;
        this.transaction_date = transaction_date;
        this.employee_name = employee_name;
        this.total = total;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
