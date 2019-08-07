package Lab4;


public class BankAccountTest {

    public static void main(String[] args) {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }
    private static BankAccount createDefaultAccount() {
        return new BankAccount(100.0f,31,0.0001f);
    }

    private static void test_creation() {
        BankAccount a = createDefaultAccount();
        assertBankAccount(a,100.0f, -0.0000001f,0.0000001f, 31, 0.0001f);
        // Add tests for the remaining fields of BankAccount
        //
        // .... your code should go here ....
        //
    }

    private static void test_deposit(){
        BankAccount a = createDefaultAccount();
        a.deposit(50f, 61);
        assertBankAccount(a,100.0f, -0.0000001f,0.0000001f, 31, 0.0001f);
    }
    private static void test_withdraw(){
        //
        // .... your code should go here ....
        //
        BankAccount a = createDefaultAccount();
        a.withdraw(50f, 61);
        assertBankAccount(a,100.0f, -0.0000001f,0.0000001f, 31, 0.0001f);
    }
    private static void test_credit_interest() {
        //
        // .... your code should go here ....
        //
        BankAccount a = createDefaultAccount();
        a.deposit(50, 61);
        a.credit_interest();
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f : "Incorrect interest";
        assert a.balance == 150.299999f : "Incorrect balance";
    }
    private static void assertBankAccount(BankAccount a, float v, float v1, float v2, int i, float v3) {
        assert a.balance==100.0f : "Incorrect balance!";
        assert a.dayLastOp == 31 : "Incorrect day!";
        assert a.interestRate == 0.0001f: "Incorrect interest rate";
    }

}
