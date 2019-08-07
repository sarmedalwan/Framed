package bank;

import org.junit.*;
import org.joda.time.LocalDate;

import static org.junit.Assert.*;

public class BankAccountTest {

    public static final double DELTA = 0.001;
    public static final LocalDate THIRTY_DAYS_SINCE_CREATION = (new LocalDate()).plusDays(30);
    private BankAccountRefactored a;

    @Before
    public void setUp()  {
        String accountHolder = "Andrew";
        int accountNumber = 100000;
        a = new BankAccountRefactored(accountHolder, accountNumber,100.0f, new LocalDate(), 0.0001f);
    }

    @Test
    public void testCreation(){
        assertBankAccount(100.0f, 0.0f, new LocalDate());
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }


    @Test
    public void testDeposit() {
        a.deposit(50f, THIRTY_DAYS_SINCE_CREATION);
        assertBankAccount(150f,0.3f, THIRTY_DAYS_SINCE_CREATION);

    }
    @Test (expected = InsufficientFunds.class)
    public void testWithdraw() throws InsufficientFunds {
        a.withdraw(50f, THIRTY_DAYS_SINCE_CREATION);
        assertBankAccount(50f,0.3f,THIRTY_DAYS_SINCE_CREATION);
        a.withdraw(100f, THIRTY_DAYS_SINCE_CREATION); // should throw an exception
    }
    @Test
    public void testCredit_interest() {
        a.deposit(50f, THIRTY_DAYS_SINCE_CREATION);
        a.credit_interest();
        assertBankAccount(150.3f,0.0f,THIRTY_DAYS_SINCE_CREATION);

    }

    private void assertBankAccount(float expectedBalance, float expectedInterestEarned, LocalDate expectedDayLastOp) {
        assertEquals(expectedBalance,a.balance,DELTA);
        assertEquals(expectedInterestEarned, a.interestEarned, DELTA);
        assertEquals(expectedDayLastOp,a.dayLastOp);
    }
}