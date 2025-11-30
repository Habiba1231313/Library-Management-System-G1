package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.UniversitySystem;
import Model.MembershipApplication;

public class UniversitySystemTest {

    private UniversitySystem uniSys;
    private MembershipApplication app1;
    private MembershipApplication app2;

    @BeforeEach
    public void setUp() {
        uniSys = new UniversitySystem();

        app1 = new MembershipApplication("Habiba", "123 Aspire Park");
        app2 = new MembershipApplication("", "");
    }

    // ========== TEST CASE 1: Valid applicant ==========
    @Test
    public void testVerifyApplicantCase1() {
        assertTrue(uniSys.verifyApplicant(app1), "UniversitySystem should always return true");
    }

    // ========== TEST CASE 2: Empty applicant ==========
    @Test
    public void testVerifyApplicantCase2() {
        assertTrue(uniSys.verifyApplicant(app2), "UniversitySystem should return true even for empty applicant");
    }

    @Test
    public void testUniversitySystemCreation() {
        assertNotNull(uniSys, "UniversitySystem object should be created");
    }
}
