public class StandardAccount extends BaseAccount {
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        super(accountNumber);
        this.creditLimit = creditLimit >= 0 ? 0 : creditLimit; // Ensuring credit limit is negative or zero
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) return 0;

        double maxWithdrawal = balance - creditLimit;
        double actualWithdrawal = Math.min(amount, maxWithdrawal);
        if (actualWithdrawal <= 0) return 0;

        balance -= actualWithdrawal;
        return actualWithdrawal;
    }
}