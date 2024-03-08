package umbcs680.RoleBasedAccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import java.nio.file.AccessDeniedException;
import static org.junit.jupiter.api.Assertions.*;

public class RoleBasedAccessTest{

    @Test
    //Test Case 1: Functional Test: Verify Guest user functionality
    public void verifyGuestRole(){
        RoleBasedAccess cut = RoleBasedAccess.createGuestInstance("Guest", "password");
        try{
            cut.getGuestPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Guest Page access Denied", ex.getMessage());
        }
        try{
            cut.getPremiumPage();
            fail("Premium Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertEquals("Premium Page access Denied", ex.getMessage());
        }
        try{
            cut.getAdminPage();
            fail("Admin Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertTrue(ex instanceof AccessDeniedException);
            assertEquals("Admin Page access Denied", ex.getMessage());
        }
        try{
            cut.premiumSubscribe(300);
            fail("Premium amount is less");
        }
        catch (AccessDeniedException ex) {
            assertTrue(ex instanceof AccessDeniedException);
            assertEquals("Premium amount is less", ex.getMessage());
        }
        try{
            cut.premiumSubscribe(500);
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Premium amount is less", ex.getMessage());
        }
        cut.premiumSubscribeExpired();
        try{
            cut.AdminLogin("wrongUN", "wrongPWD");
        }
        catch (AccessDeniedException ex) {
            assertTrue(ex instanceof AccessDeniedException);
            assertEquals("Credentials are wrong", ex.getMessage());
        }
        try{
            cut.AdminLogin("Admin", "pwd");
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Credentials are wrong", ex.getMessage());
        }
        cut.Adminlogout();
    }

    @Test
    //Test Case 2: Functional Test: Verify PremiumUser access
    public void verifyPremiumUserRole(){
        RoleBasedAccess cut = RoleBasedAccess.createPremiumUserInstance("Premium", "pwd");
        try{
            cut.getGuestPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Guest Page access Denied", ex.getMessage());
        }
        try{
            cut.getPremiumPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Premium Page access Denied", ex.getMessage());
        }
        try{
            cut.getAdminPage();
            fail("Admin Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertEquals("Admin Page access Denied", ex.getMessage());
        }
        cut.premiumSubscribeExpired();
        try{
            cut.getPremiumPage();
            fail("Premium Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertEquals("Premium Page access Denied", ex.getMessage());
        }
    }

    @Test
    //Test Case 3: Functional Test: Verify Admin user access
    public void verifyAdminRole() throws AccessDeniedException {
        RoleBasedAccess cut = RoleBasedAccess.createAdminInstance("Admin", "pwd");
        try{
            cut.getGuestPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Guest Page access Denied", ex.getMessage());
        }
        try{
            cut.getPremiumPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Premium Page access Denied", ex.getMessage());
        }
        try{
            cut.getAdminPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Admin Page access Denied", ex.getMessage());
        }
        cut.Adminlogout();
        try{
            cut.getAdminPage();
            fail("Admin Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertEquals("Admin Page access Denied", ex.getMessage());
        }
    }

    @Test
    //Test Case 4: Functional Test: Verify changeUser()
    public void verifyStateTransitions() throws AccessDeniedException {
        RoleBasedAccess cut = RoleBasedAccess.createAdminInstance("Admin", "pwd");
        try{
            cut.getGuestPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Guest Page access Denied", ex.getMessage());
        }
        try{
            cut.getPremiumPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Premium Page access Denied", ex.getMessage());
        }
        try{
            cut.getAdminPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Admin Page access Denied", ex.getMessage());
        }
        cut.Adminlogout();
        try{
            cut.getGuestPage();
        }
        catch (AccessDeniedException ex) {
            assertNotEquals("Guest Page access Denied", ex.getMessage());
        }
        try{
            cut.getPremiumPage();
            fail("Premium Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertEquals("Premium Page access Denied", ex.getMessage());
        }
        try{
            cut.getAdminPage();
            fail("Admin Page access Denied");
        }
        catch (AccessDeniedException ex) {
            assertEquals("Admin Page access Denied", ex.getMessage());
        }
    }

    @Test
    //Test Case 5: Structural Test: Verify Singleton implementation
    public void verifySingleton() throws AccessDeniedException {
        Guest cut = Guest.getInstance();
        Guest cut1 = Guest.getInstance();
        assertTrue(cut instanceof Guest);
        assertTrue(cut1 instanceof Guest);
        assertSame(cut, cut1);
        PremiumUser cut2 = PremiumUser.getInstance();
        PremiumUser cut3 = PremiumUser.getInstance();
        assertSame(cut2, cut3);
        Admin cut4 = Admin.getInstance("Admin", "pwd");
        Admin cut5 = Admin.getInstance("Admin", "pwd");
        assertSame(cut4, cut5);
    }
}