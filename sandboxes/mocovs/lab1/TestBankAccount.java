public class TestBankAccount
{
    public static void main(String[] args) {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }

    private static void test_creation() {
        BankAccount a = createDefaultAccount();
        assert_all(a,100.0f, -0.0000001f,0.0000001f, 31, 0.0001f);

    }

    private static BankAccount createDefaultAccount() {
        return new BankAccount(100.0f,31,0.0001f);
    }

    private static void test_deposit(){
        BankAccount a = createDefaultAccount();
        a.deposit(50f, 61);
        assert_all(a,150f,0.299999f,0.3000001f,61, 0.0001f);
    }

    private static void test_credit_interest() {

        BankAccount a = createDefaultAccount();
        a.deposit(50f, 61);
        a.withdraw(50f, 71);
        float earnedInterest = a.interestEarned;
        a.creditInterest();
        
        assert_all(a,100f + earnedInterest,-0.0000001f,0.0000001f,71, 0.0001f);

    }

    private static void test_withdraw(){
        BankAccount a = createDefaultAccount();
        a.withdraw(50f, 61);
        assert_all(a,50,0.299999f,0.3000001f,61, 0.0001f);
    }

    private static void assert_all(BankAccount a, float balance, float interestEarnedLower, float interestEarnedUpper, int dayLastOp, float interestRate){
        assert a.balance==balance;
        assert a.interestEarned>interestEarnedLower && a.interestEarned<interestEarnedUpper;
        assert a.dayLastOp==dayLastOp;
        assert a.interestRate == interestRate;
    }

}
