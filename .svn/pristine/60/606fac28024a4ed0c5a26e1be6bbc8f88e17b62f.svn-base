// Remember: compile with javac BankAccount.java and run with java -ea BankAccount
package lab4;
public class BankAccount {
    float balance, interestEarned, interestRate;
    int dayLastOp;

    public BankAccount(float initialBalance, int dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
    }

    private static void test_creation() {
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        assert a.balance==100.0f : "Incorrect balance!";
        assert a.dayLastOp == 31 : "Incorrect day of last operation!";
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }

    public void deposit(float amount, int dayDeposited){
        int daysInterest = dayDeposited - this.dayLastOp;
        float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
        this.interestEarned += interestSinceLastOp;

        this.balance += amount;
        this.dayLastOp = dayDeposited;
    }

    private static void test_deposit(){
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.deposit(50f, 61);
        assert a.balance==150f : "Deposit: Incorrect balance";
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f : "Deposit: Incorrect interest earned";
        assert a.dayLastOp == 61 : "Deposit: Incorrect days since last op";
    }

    public void withdraw(float amount, int dayWithdrawn){
        int daysInterest = dayWithdrawn - this.dayLastOp;
        float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
        this.interestEarned += interestSinceLastOp;

        this.balance -= amount;
        this.dayLastOp = dayWithdrawn;
    }

    private static void test_withdraw(){
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.withdraw(50f, 61);
        assert a.balance==50f : "Withdraw: Incorrect balance";
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f : "Withdraw: Incorrect interest earned";
        assert a.dayLastOp == 61 : "Withdraw: Incorrect days since last op";
    }

    public void credit_interest() {
        this.balance += this.interestEarned;
        this.interestEarned = 0;
    }

    private static void test_credit_interest() {
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.deposit(50f, 61);
        a.credit_interest();
        assert a.balance > 150.299f && a.balance < 150.301 : "Credit Interest: Incorrect balance.";
        assert a.interestEarned == 0 : "Credit Interest: Incorrect interest earned.";
    }

    public static void main(String[] args) {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }
}
