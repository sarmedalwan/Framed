package Bank;

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
        assert a.dayLastOp==31 : "Incorrect day!";
        assert a.interestRate==0.0001f : "Incorrect interest rate!";
        // Add tests for the remaining fields of BankAccount
        //
        // .... your code should go here ....
        //
    }

    public void deposit(float amount, int dayDeposited){
        //
        // .... your code should go here ....
        // Ensure interests are correctly dealt with
        //
       int daysInterest = dayDeposited - this.dayLastOp;
       float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
       this.interestEarned += interestSinceLastOp;
       this.balance += amount;
       this.dayLastOp = dayDeposited;
    }

    private static void test_deposit(){
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.deposit(50f, 61);
//        System.out.println(a.balance);
        assert a.balance==150f;
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f;
        assert a.dayLastOp == 61;
    }

    public void withdraw(float amount, int dayWithdrawn){
        //
        // .... your code should go here ....
        // Ensure interests are correctly dealt with
        //
        int daysInterest = dayWithdrawn - this.dayLastOp;
        float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
        this.interestEarned += interestSinceLastOp;
        this.balance -= amount;
        this.dayLastOp = dayWithdrawn;
    }

    private static void test_withdraw(){
        //
        // .... your code should go here ....
        //
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.withdraw(50f, 61);
        assert a.balance==50f;
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f;
        assert a.dayLastOp == 61;
    }

    public void credit_interest() {
        //
        // .... your code should go here ....
        // Ensure interests are correctly dealt with
        //
        balance += interestEarned;
        interestEarned = 0.0f;
    }

    private static void test_credit_interest() {
        //
        // .... your code should go here ....
        //
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.deposit(50f, 61);
        a.credit_interest();
        assert a.balance>150.2999f && a.balance<150.30001f;
        assert a.interestEarned==0.0f;
    }

    public static void main(String[] args) {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }
}

