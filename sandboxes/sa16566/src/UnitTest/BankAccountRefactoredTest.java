package UnitTest;

/*import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
*/
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class BankAccountRefactoredTest {

    private BankAccountRefactored a;

    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BankAccountRefactored.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private static BankAccountRefactored standardTestAccount() {
        return new BankAccountRefactored(100.0f, 31, 0.0001f);
    }

    private void assertBankAccount(float expectedBalance, float expectedInterestEarned, int expectedDayLastOp) {
         assertEquals(expectedBalance, a.balance, 0.001);
         assertEquals(expectedInterestEarned, a.interestEarned, 0.001);
         assertEquals(expectedDayLastOp, a.dayLastOp);
    }

    @Before
    public void SetUp(){
        a = standardTestAccount();
    }

    @Test
    public void testDeposit() {
        a.deposit(50f, 61);
        assertBankAccount(150f,0.3f,61);
    }

    @Test
    public void testWithdraw() {
        a.withdraw(50f, 61);
        assertBankAccount(50f,0.3f,61);
    }

    @Test
    public void testCredit_interest() {
        a.deposit(50f, 61);
        a.credit_interest();
        assertBankAccount(150.3f,0.0f,61);
    }
}
