public class BankAccountRefactoredTests {
    public static void main(String[] args) {
        runAllTests();
        System.out.println("Success!");
    }

    private static void runAllTests() {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
    }

    private static void test_creation() {

        BankAccountRefactored a = standardTestAccount();
        assertBankAccount(a, 100.0f, 0.0f, 31);
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }

    private static void test_deposit(){
        BankAccountRefactored a = standardTestAccount();
        a.deposit(50f, 61);
        assertBankAccount(a,150f,0.3f,61);
    }

    private static void test_withdraw(){
        BankAccountRefactored a = standardTestAccount();
        a.withdraw(50f, 61);
        assertBankAccount(a,50f,0.3f,61);
    }

    private static void test_credit_interest() {
        BankAccountRefactored a = standardTestAccount();
        a.deposit(50f, 61);
        a.credit_interest();
        assertBankAccount(a,150.3f,0.0f,61);
    }

    private static BankAccountRefactored standardTestAccount() {
        return new BankAccountRefactored(100.0f, 31, 0.0001f);
    }

    private static void assertBankAccount(BankAccountRefactored a, float expectedBalance, float expectedInterestEarned, int expectedDayLastOp) {
        assert Math.abs(a.balance - expectedBalance) < 0.001 : "Incorrect balance!";
        assert Math.abs(a.interestEarned - expectedInterestEarned) < 0.001 : "Incorrect interest!";
        assert a.dayLastOp == expectedDayLastOp : "Incorrect day last operation!";
    }
}
