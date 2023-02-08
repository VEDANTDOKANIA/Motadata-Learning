package Model;

public abstract class Account {
    // class which extends account will have to override debit and credit method.
    // showBalance method only display balance hence no need of overriding it.

    protected double balance;
    protected int account_no;
    Customer customer;
    Bank bank;

    public abstract int debit(double amount);
    public abstract int credit(double amount);
    public double showBalance() {
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}