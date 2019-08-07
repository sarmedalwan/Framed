package Lab6;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    public static final double DELTA = 0.0001;
    private Bank b;

    @Before
    public void setUp() throws Exception {
        b = new Bank();
        b.createAccount("Riccardo",100.0f,0.0001f);
        b.createAccount("Davide",200.0f,0.0001f);
    }

    @Test
    public void testCreation() {
        assertEquals(2,b.currentAccounts.size());
        assertEquals(new LocalDate(),b.today);
    }

    @Test
    public void testCreateAccount(){
        assertEquals("Riccardo",b.get("Riccardo").holder);
        assertEquals("Davide",b.get("Davide").holder);
        assertEquals(200,b.get("Davide").balance, DELTA);
    }

    @Test
    public void testDeposit() {
        advance30days();
        b.deposit("Davide",50f);
        assertEquals(250f,b.get("Davide").balance,DELTA);
        assertEquals(0.6f,b.get("Davide").interestEarned,DELTA);
    }

    @Test(expected = InsufficientFunds.class)
    public void testWithdraw() throws InsufficientFunds {
        advance30days();
        b.withdraw("Davide", 50f);
        assertEquals(150f,b.get("Davide").balance,DELTA);
        assertEquals(0.6f,b.get("Davide").interestEarned,DELTA);
        b.withdraw("Davide", 2000f);
    }

    @Test
    public void testCreditInterest(){
        advance30days();
        b.creditInterest();
        assertEquals(100.3f,b.get("Riccardo").balance,DELTA);
        assertEquals(0f,b.get("Riccardo").interestEarned,DELTA);
        assertEquals(b.today.toString(),b.get("Riccardo").dayLastOp.toString());
    }

    private void advance30days() {
        for (int i = 0; i < 30; i++)
            b.nextDay();
    }

}