import Model.Account;

public class CurrentAccount extends Account {
    int minimumBalance = 1000;
    @Override
    public int debit(double amount) {
        // return value :
        //  1 -> debit operation performed successfully
        // -1 -> insufficient balance
        // -2 -> minimum balance requirement insufficient

        // 1. check if customer have sufficient balance left
        if (balance < amount) {
            // insufficient balance
            return -1;
        }

        if ((balance - amount) < minimumBalance) {
            // minimum balance requirement insufficient
            return -2;
        }
        balance -= amount;
        return 1;
    }

    @Override
    public int credit(double amount) {
        // this method will credit account with specified amount
        // 1 -> operation performed successfully
        balance += amount;
        return 1;
    }
}
