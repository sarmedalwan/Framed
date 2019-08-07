import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount a;

    @Before
    public void setup()
    {
        a = standardTestAccount();
    }

    @Test
    public void TestCreation()
    {
        assertBankAccount(a,100.f,0.0f, new LocalDate().plusDays(31));
        assertEquals(0.0,a.interestEarned, 0.0);
    }

    @Test
    public void deposit() {
        a.deposit(50f, new LocalDate().plusDays(61));
        assertBankAccount(a,150f,0.3f, new LocalDate().plusDays(61));
    }

    @Test
    public void withdraw() {
        a.withdraw(50f, new LocalDate().plusDays(61));
        assertBankAccount(a,50f,0.3f,new LocalDate().plusDays(61));
    }

    @Test
    public void credit_interest() {
        a.deposit(50f, new LocalDate().plusDays(61));
        a.credit_interest();
        assertBankAccount(a,150.3f,0.0f,new LocalDate().plusDays(61));
    }


    public static BankAccount standardTestAccount() {
        return new BankAccount(100.0f, new LocalDate().plusDays(31), 0.0001f, "Matej Ocovsky", 123456789);
    }

    private static void assertBankAccount(BankAccount a, float expectedBalance, float expectedInterestEarned, LocalDate expectedDayLastOp) {
        assertEquals(expectedBalance, a.balance, 0.001);
        assertEquals(expectedInterestEarned, a.interestEarned, 0.001);
        assertEquals(expectedDayLastOp, a.dayLastOp);
    }
}