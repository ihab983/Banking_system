public class BasicAccount extends BaseAccount {
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        super(accountNumber);
        this.withdrawalLimit = Math.max(0, withdrawalLimit); // Ensuring withdrawal limit is non-negative
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) return 0;

        double allowedWithdrawal = Math.min(withdrawalLimit, balance);
        double actualWithdrawal = Math.min(amount, allowedWithdrawal);
        balance -= actualWithdrawal;
        return actualWithdrawal;
    }
}