import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountRefactoredTest {

    public static final double DELTA = 0.001;
    private BankAccountRefactored a;

    // to avoid manually creating BankAccount instances in each test
    // create them in @Before method
    @Before
    public void setUp() {
        a = new BankAccountRefactored(100.0f, 31, 0.0001f);
    }

    @Test
    public void creation(){
        assertBankAccount(100.0f, 0.0f, 31);
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }

    @Test
    public void deposit() {
        a.deposit(50f, 61);
        assertBankAccount(150f,0.3f,61);
    }

    @Test
    public void withdraw() {
        a.withdraw(50f, 61);
        assertBankAccount(50f,0.3f,61);
    }

    @Test
    public void credit_interest() {
        a.deposit(50f, 61);
        a.credit_interest();
        assertBankAccount(150.3f,0.0f,61);
    }

    private void assertBankAccount(float expectedBalance, float expectedInterestEarned, int expectedDayLastOp) {
        assertEquals(expectedBalance, a.balance, DELTA);
        assertEquals(expectedInterestEarned, a.interestEarned, DELTA);
        assertEquals(expectedDayLastOp, a.dayLastOp);
    }
}