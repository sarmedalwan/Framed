package Lab6;

import org.junit.Before;
import org.junit.Test;
import org.joda.time.LocalDate;


public class BankAccountTest {
    public static final LocalDate THIRTY_DAYS_SINCE_CREATION = (new LocalDate()).plusDays(30);
    private BankAccount a;
    @Before
    public void setUp() {
        String accountHolder = "Riccardo";
        int accountNumber = 100000;
        a = new BankAccount(accountHolder, accountNumber, 100.0f, THIRTY_DAYS_SINCE_CREATION, 0.0001f);
    }
    @Test
    public void testCreation(){
        assertBankAccount( 100.0f, 0.0f, THIRTY_DAYS_SINCE_CREATION);
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }

    @Test
    public void deposit()  {
        a.deposit(50f, THIRTY_DAYS_SINCE_CREATION);
        assertBankAccount(150f,0.3f, THIRTY_DAYS_SINCE_CREATION);
    }

    @Test(expected = InsufficientFunds.class)
    public void withdraw() throws InsufficientFunds {
        a.withdraw(50f, THIRTY_DAYS_SINCE_CREATION);
        assertBankAccount(50f,0.3f, THIRTY_DAYS_SINCE_CREATION);
        a.withdraw(100f, THIRTY_DAYS_SINCE_CREATION);
    }

    @Test
    public void credit_interest()  {
        a.deposit(50f, THIRTY_DAYS_SINCE_CREATION);
        a.credit_interest();
        assertBankAccount(150.3f,0.0f, THIRTY_DAYS_SINCE_CREATION);
    }

    private void assertBankAccount(float expectedBalance, float expectedInterestEarned, LocalDate expectedDayLastOp) {
        assert Math.abs(a.balance - expectedBalance) < 0.001 : "Incorrect balance!";
        assert Math.abs(a.interestEarned - expectedInterestEarned) < 0.001 : "Incorrect interest!";
        assert a.dayLastOp == expectedDayLastOp : "Incorrect day last operation!";
    }
}