package defining_classes.bank_account;

public class BankAccount {
//    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = 0.02;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

//    public BankAccount(int id, double balance) {
//        this.id = id;
//        this.balance = balance;
//    }

    public BankAccount() {
        this.id = bankAccountCount++;
        this.balance = 0;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public static void setInterestRate(double newInterestRate) {
        BankAccount.interestRate = newInterestRate;
    }

    public double getInterest(int years) {
        double currentAmount = this.balance;
        return years * currentAmount * this.interestRate;
    }
}
