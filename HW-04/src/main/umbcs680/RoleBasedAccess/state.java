package umbcs680.RoleBasedAccess;

import java.nio.file.AccessDeniedException;

public interface state{
	public void getGuestPage() throws AccessDeniedException;
	public void getPremiumPage() throws AccessDeniedException;
	public void getAdminPage() throws AccessDeniedException;
	public  void premiumSubscribe(float amount) throws AccessDeniedException;
	public void premiumSubscribeExpired();
	public void AdminLogin(String username, String password) throws AccessDeniedException;
	public void Adminlogout();
}