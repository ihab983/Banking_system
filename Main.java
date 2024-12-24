import java.util.List;
public class Main {

    public static void main(String[] args) {
        // Creating a bank instance
        Bank bank = new Bank();

        // Creating and opening a Standard Account
        StandardAccount standardAccount = new StandardAccount(123, -100.0);
        bank.openAccount(standardAccount);
        standardAccount.deposit(500);

        // Creating and opening a Basic Account
        BasicAccount basicAccount = new BasicAccount(456, 200.0);
        bank.openAccount(basicAccount);
        basicAccount.deposit(300);

        // Creating and opening a Premium Account
        PremiumAccount premiumAccount = new PremiumAccount(789);
        bank.openAccount(premiumAccount);
        premiumAccount.deposit(700);

        // Performing transactions
        performTransaction(standardAccount, 200, "Standard");
        performTransaction(basicAccount, 250, "Basic");
        performTransaction(premiumAccount, 800, "Premium");

        // Closing accounts with positive balance
        bank.closeAccount(123); // Should succeed
        bank.closeAccount(456); // Should succeed
        bank.closeAccount(789); // Should fail due to insufficient funds after withdrawal

        // Displaying all accounts in the bank
        System.out.println("All Accounts in the Bank:");
        for (IAccount account : bank.getAllAccounts()) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getCurrentBalance());
        }
    }

    private static void performTransaction(IAccount account, double amount, String accountType) {
        double withdrawnAmount = account.withdraw(amount);
        if (withdrawnAmount > 0) {
            System.out.println(accountType + " Account Withdrawn: " + withdrawnAmount);
        } else {
            System.out.println(accountType + " Account Withdrawal failed.");
        }
        System.out.println(accountType + " Account Current Balance: " + account.getCurrentBalance());
    }
}