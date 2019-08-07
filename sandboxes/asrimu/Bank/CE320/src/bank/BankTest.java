package bank;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private Bank b;

    @Before
    public void setUp() throws Exception
    {
        b = new Bank();

    }

    @Test
    public void testCreation()
    {
        assertEquals(1,b.currentAccounts.size());
    }
}
