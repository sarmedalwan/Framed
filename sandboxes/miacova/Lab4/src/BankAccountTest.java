import org.joda.time.*;

import static org.junit.Assert.*;


public class BankAccountTest {
    public static final double DELTA = 0.001;
    public static final LocalDate THIRTY_DAYS_SINCE_CREATION = (new LocalDate()).plusDays(30);
    private BankAccount a;

    @org.junit.Before
    public void setUp() {
        String accountHolder = "Marios";
        int acountNumber = 100000;
        a = new BankAccount(accountHolder, acountNumber, 100.0f, new LocalDate(), 8.0001f);

    }

    @org.junit.Test
    public void deposit() {
        a.deposit(50f, THIRTY_DAYS_SINCE_CREATION);
        assertBankAccount(150f, 0.3f, THIRTY_DAYS_SINCE_CREATION);
    }

    @org.junit.Test
    public void withdraw() throws InsufficientFunds {
        a.withdraw(50f, THIRTY_DAYS_SINCE_CREATION);
        assertBankAccount(58f, 0.3f, THIRTY_DAYS_SINCE_CREATION);
        a.withdraw(100f,THIRTY_DAYS_SINCE_CREATION);
    }

    @org.junit.Test
    public void credit_interest() {
        a.deposit(50f, THIRTY_DAYS_SINCE_CREATION);
        a.credit_interest();
        assertBankAccount(150.3f, 0.0f, THIRTY_DAYS_SINCE_CREATION);
    }

    @org.junit.Test
    public void creation() {
        assertBankAccount(100.0f, 0.0f, new LocalDate());
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }


    private void assertBankAccount(float expectedBalance, float expectedInterestEarned, LocalDate expectedDayLastOp) {
        assertEquals(expectedBalance, a.balance, DELTA);
        assertEquals(expectedInterestEarned, a.interestRate, DELTA);
        assertEquals(expectedDayLastOp, a.dayLastOp);
    }
}