package BankAccountRefactoredTesting;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountRefactoredTest {

    private BankAccountRefactored a;
    private LocalDate date = new LocalDate().withYear(2018).withMonthOfYear(1).withDayOfMonth(1);

    @Before
    public void setUp() {
        a = standardTestAccount();
    }

    @Test
    public void creation(){
        assertBankAccount(100.0f, 0.0f, date);
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }

    @Test
    public void deposit() {
        date = date.withYear(2018).withMonthOfYear(1).withDayOfMonth(31);
        a.deposit(50f, date);
        assertBankAccount(150f,0.3f, date);
    }

    @Test
    public void withdraw() {
        date = date.withYear(2018).withMonthOfYear(1).withDayOfMonth(31);
        a.withdraw(50f, date);
        assertBankAccount(50f,0.3f,date);
    }

    @Test
    public void credit_interest() {
        date = date.withYear(2018).withMonthOfYear(1).withDayOfMonth(31);
        a.deposit(50f, date);
        a.credit_interest();
        assertBankAccount(150.3f,0.0f,date);
        //a.balance+=a.interestEarned;
        //a.interestEarned = 0.0f;
    }

    private static BankAccountRefactored standardTestAccount() {
        LocalDate date = new LocalDate();
        date = date.withYear(2018).withMonthOfYear(1).withDayOfMonth(1);
        return new BankAccountRefactored(100.0f, date, 0.0001f);
    }

    private void assertBankAccount(float expectedBalance, float expectedInterestEarned, LocalDate expectedDayLastOp) {
        assertEquals(expectedBalance, a.balance, 0.001);
        assertEquals(expectedInterestEarned, a.interestEarned, 0.001);
        assertEquals(expectedDayLastOp, a.dayLastOp);
    }
}