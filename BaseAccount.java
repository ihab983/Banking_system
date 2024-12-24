public abstract class BaseAccount implements IAccount {
    protected int accountNumber;
    protected double balance;

    public BaseAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Initialize balance to 0
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}