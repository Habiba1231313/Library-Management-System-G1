package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.FinanceSys;

public class FinanceSysTest {
    
    private FinanceSys financeCase;
    
    @BeforeEach
    public void setUp() {
        financeCase = new FinanceSys();
    }
    
    
    @Test
    public void testTransferDepositCase1() {
        assertTrue(financeCase.transferDeposit(100), "Transfer should return true");
    }
    
    
    @Test
    public void testFinanceSysCreation() {
        assertNotNull(financeCase, "FinanceSys object should be created");
    }
}