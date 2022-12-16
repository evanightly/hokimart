package model;

public class Manager extends Employee implements IManager {

    String roleTitle;

    public Manager() {
    }

    public Manager(int id_employee, String name, String username, String password, int age, float salary, int years_experienced, String roleTitle) {
        super(id_employee, name, username, password, age, salary, years_experienced);
        this.roleTitle = roleTitle;
    }

    @Override
    public boolean isExperienced() {
        return super.years_experienced > 20;
    }

    public void registerEmployee(Employee cashier) {

    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
    
    public Manager getManager() {
        return this;
//        return String.format("Name: %s\nUsername: %s\nPassword: %d\nAge: %d", name, username, password, age);
    }

}
