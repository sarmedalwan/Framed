/*
// Remember: compile with javac BankAccount.java and run with java -ea BankAccount
public class BankAccountRefactored {
    public float balance;
    public float interestEarned;
    public float interestRate;
    int dayLastOp;

    public BankAccountRefactored(float initialBalance, int dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
    }

    private static void test_creation() {
        BankAccountRefactored a = new BankAccountRefactored(100.0f, 31, 0.0001f);
        // Add tests for the remaining fields of BankAccount
        assert a.balance == 100.0f : "Incorrect balance!";
        assert a.dayLastOp == 31 : "Incorrect Day!";
        assert a.interestRate == 0.0001f : "Incorrect Rate";
    }

    public void deposit(float amount, int dayDeposited) {
        int days = dayDeposited - dayLastOp;
        float intPerEachDay = balance * interestRate;
        interestEarned = intPerEachDay * days;
        dayLastOp = dayDeposited;
        balance += amount;


    }

    private static void test_deposit() {
        BankAccountRefactored a = new BankAccountRefactored(100.0f, 31, 0.0001f);
        a.deposit(50f, 61);
        assert a.balance == 150f;
        assert a.interestEarned > 0.299999f && a.interestEarned < 0.3000001f;
        assert a.dayLastOp == 61;
    }

    public void withdraw(float amount, int dayWithdrawn) {
        int dayInter = dayWithdrawn - dayLastOp;
        float interestSinceLastOp = balance * dayInter * interestRate;
        interestEarned += interestSinceLastOp;
        balance -= amount;
        dayLastOp = dayWithdrawn;
    }

    private static void test_withdraw() {
        BankAccountRefactored bankAccount = new BankAccountRefactored(100.0f, 31, 0.001f);
        bankAccount.withdraw(50f, 61);
        assert bankAccount.balance == 150f;
        assert bankAccount.interestEarned > 0.299999f && bankAccount.interestEarned < 0.3000001f;
        assert bankAccount.dayLastOp == 61;

    }

    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }

    private static void test_credit_interest() {
       BankAccountRefactored bankAccount = new BankAccountRefactored(100.0f, 31, 0.001f);
       bankAccount.deposit(50f, 61);
       bankAccount.credit_interest();
       assert  bankAccount.balance == 100.3f;
       assert  bankAccount.interestEarned == 0.0f;
    }

    public static void main(String[] args) {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }
}
*/
