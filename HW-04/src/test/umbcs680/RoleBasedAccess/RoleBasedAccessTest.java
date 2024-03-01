package umbcs680.RoleBasedAccess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoleBasedAccessTest{

    @Test
    //Test Case 1: Functional Test: Verify Guest user access
    public void verifyGuestRole(){
        RoleBasedAccess cut = RoleBasedAccess.createGuestInstance("Guest", "password");
        assertEquals("Guest Page : Access Granted", cut.getGuestPage());
        assertEquals("Premium Page : Access Denied", cut.getPremiumPage());
        assertEquals("Admin Page : Access Denied", cut.getAdminPage());
        assertEquals("Logged out", cut.logout());
    }

    @Test
    //Test Case 2: Functional Test: Verify PremiumUser access
    public void verifyPremiumUserRole(){
        RoleBasedAccess cut = RoleBasedAccess.createPremiumUserInstance("Premium", "pwd");
        assertEquals("Guest Page : Access Granted", cut.getGuestPage());
        assertEquals("Premium Page : Access Granted", cut.getPremiumPage());
        assertEquals("Admin Page : Access Denied", cut.getAdminPage());
        assertEquals("Logged out", cut.logout());
    }

    @Test
    //Test Case 3: Functional Test: Verify Admin user access
    public void verifyAdminRole(){
        RoleBasedAccess cut = RoleBasedAccess.createAdminInstance("admin", "adminpwd");
        assertEquals("Guest Page : Access Granted", cut.getGuestPage());
        assertEquals("Premium Page : Access Granted", cut.getPremiumPage());
        assertEquals("Admin Page : Access Granted", cut.getAdminPage());
        assertEquals("Logged out", cut.logout());
    }

    @Test
    //Test Case 4: Functional Test: Verify changeUser()
    public void verifyChangeUserRole(){
        RoleBasedAccess cut = RoleBasedAccess.createAdminInstance("admin", "adminpwd");
        assertEquals("Guest Page : Access Granted", cut.getGuestPage());
        assertEquals("Premium Page : Access Granted", cut.getPremiumPage());
        assertEquals("Admin Page : Access Granted", cut.getAdminPage());
        cut.changeUser(Guest.getInstance());
        assertEquals("Guest Page : Access Granted", cut.getGuestPage());
        assertEquals("Premium Page : Access Denied", cut.getPremiumPage());
        assertEquals("Admin Page : Access Denied", cut.getAdminPage());
    }

    @Test
    //Test Case 5: Structural Test: Verify Singleton implementation
    public void verifySingleton(){
        Guest cut = Guest.getInstance();
        Guest cut1 = Guest.getInstance();
        assertTrue(cut instanceof Guest);
        assertTrue(cut1 instanceof Guest);
        assertSame(cut, cut1);
        PremiumUser cut2 = PremiumUser.getInstance();
        PremiumUser cut3 = PremiumUser.getInstance();
        assertSame(cut2, cut3);
        Admin cut4 = Admin.getInstance();
        Admin cut5 = Admin.getInstance();
        assertSame(cut4, cut5);
    }
}