import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
    }

    @Test
    public void testCreation(){
        assertEquals(bank.getNumAccounts(),0);
    }

    @Test
    public void addAccount(){
        bank.addAccount(BankAccountTest.standardTestAccount());
        assertEquals(bank.getNumAccounts(),1);
    }

    @Test
    public void testDeposit() {
        bank.addAccount(BankAccountTest.standardTestAccount());
        bank.depositToAccount(123456789, 100f, new LocalDate().plusDays(31));

        BankAccount acc = bank.findAccount(123456789);
        assertEquals(200f, acc.balance, 0.0f);
    }

}