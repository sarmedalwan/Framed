public class Tests {
    static void test_creation() {
        BankAccount a = createAccount();
        assert a.balance==100.0f : "Incorrect balance!";
        assert a.dayLastOp==31: "Incorrect day of last operation!";
        assert a.interestEarned==0.0f : "Incorrect interest earned!";
        assert a.interestRate==0.0001f : "Incorrect interest rate!";
    }

    static void test_deposit(){
        BankAccount a = createAccount();
        a.deposit(50f, 61);
        assert a.balance==150f;
        assertions(a);
    }

    static void test_withdraw(){
        BankAccount a = createAccount();
        a.deposit(-50f, 61);
        assert a.balance==50f;
        assertions(a);
    }

    public static void assertions(BankAccount a){
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f;
        assert a.dayLastOp == 61;
    }

    static void test_credit_interest(){
        BankAccount a = createAccount();
        a.credit_interest();
        assert a.balance == a.balance+a.interestEarned;
    }

    static BankAccount createAccount(){
        return new BankAccount(100.0f,31,0.0001f);
    }
}
