package model;

public class Cashier extends Employee implements ICashier {

    int transaction_handled;
    public Cashier() {
    }

    public Cashier(String name, String username, String password, int age, float salary, int years_experienced, int transaction_handled) {
        super(name, username, password, age, salary, years_experienced);
        this.transaction_handled = transaction_handled;
    }

    public Cashier(int id_employee, String name, String username, String password, int age, float salary, int years_experienced, int transaction_handled) {
        super(id_employee, name, username, password, age, salary, years_experienced);
        this.transaction_handled = transaction_handled;
    }

//    @Override
//    public boolean login(Connection db, String username, String password) {
//        try {
//            st = db.createStatement();
//            String sql = String.format("SELECT COUNT(*) FROM employee e JOIN cashier m ON e.id_employee = m.id_employee WHERE username = '%s' AND password = '%s'", username, password);
//            if (st.execute(sql)) {
//                rs = st.getResultSet();
//                return rs.next() && rs.getInt(1) > 0;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
   
    public int getTransaction_handled() {
        return transaction_handled;
    }

    public void setTransaction_handled(int transaction_handled) {
        this.transaction_handled = transaction_handled;
    }

    @Override
    public boolean isAdult() {
        return super.age > 18;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nSalary: %f\nExperience: %d years\nTransaction Handled: %d times", name, age, salary, years_experienced, transaction_handled);
    }

}
