import Model.Account;

public class SavingAccount extends Account {
    int maxTransactionLimit = 10000;
    public int debit(double amount) {
        // return value :
        //  1 -> debit operation performed successfully
        // -1 -> insufficient balance
        // -2 -> maxTransactionLimit crossed

        // 1. check if customer have sufficient balance left
        if (balance < amount) {
            // insufficient balance
            return -1;
        }
        // perform debit operation
        balance -= amount;
        return 1;
    }

    public int credit(double amount) {
        // this method will credit amount into account
        if (amount > maxTransactionLimit) {
            return -1;
        }
        balance += amount;
        return 1;
    }
}
