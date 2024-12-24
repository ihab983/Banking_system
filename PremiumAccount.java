public class PremiumAccount extends BaseAccount {

    public PremiumAccount(int accountNumber) {
        super(accountNumber); // Utilize the constructor of BaseAccount
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) return 0; // Return 0 for non-positive withdrawal amounts

        double actualWithdrawal = Math.min(amount, balance); // Can withdraw up to the balance
        balance -= actualWithdrawal;
        return actualWithdrawal;
    }
}
