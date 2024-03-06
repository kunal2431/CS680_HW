package umbcs680.RoleBasedAccess;

import java.nio.file.AccessDeniedException;
import java.util.Objects;

class Guest implements state{

	private static Guest instance = null;
	private Guest(){

	}

	public static Guest getInstance(){
		try{
			return Objects.requireNonNull(instance);
		}
		catch(NullPointerException ex){
			instance = new Guest();
			return instance;
		}
	}
	@Override
	public void getGuestPage() throws AccessDeniedException{
		// GuestPage()
	}

	@Override
	public void getPremiumPage() throws AccessDeniedException{
		throw new AccessDeniedException("Premium Page access Denied");
	}

	@Override
	public void getAdminPage() throws AccessDeniedException{
		throw new AccessDeniedException("Admin Page access Denied");
	}

}

class PremiumUser implements state{

	private static PremiumUser instance = null;
	private PremiumUser(){

	}

	public static PremiumUser getInstance(){
		try{
			return Objects.requireNonNull(instance);
		}
		catch(NullPointerException ex){
			instance = new PremiumUser();
			return instance;
		}
	}
	@Override
	public void getGuestPage() throws AccessDeniedException{
		// GuestPage();
	}

	@Override
	public void getPremiumPage() throws AccessDeniedException{
		// PremiumPage()
	}

	@Override
	public void getAdminPage() throws AccessDeniedException{
		throw new AccessDeniedException("Admin Page access Denied");
	}

}

class Admin implements state{

	private static Admin instance = null;
	private Admin(){

	}

	public static Admin getInstance(){
		try{
			return Objects.requireNonNull(instance);
		}
		catch(NullPointerException ex){
			instance = new Admin();
			return instance;
		}
	}
	@Override
	public void getGuestPage() throws AccessDeniedException{
		// GuestPage()
	}

	@Override
	public void getPremiumPage() throws AccessDeniedException{
		// PremiumPage()
	}

	@Override
	public void getAdminPage() throws AccessDeniedException{
		// AdminPage()
	}

}

public class RoleBasedAccess {

	private state user;

	private String username, password;

	private RoleBasedAccess(String username, String password, state user){
			this.username = username;
			this.password = password;
			this.user = user;
	}

	public static RoleBasedAccess createGuestInstance(String username, String password){
			return new RoleBasedAccess(username, password, Guest.getInstance());
	}
	public static RoleBasedAccess createPremiumUserInstance(String username, String password){
			return new RoleBasedAccess(username, password, PremiumUser.getInstance());
	}
	public static RoleBasedAccess createAdminInstance(String username, String password){
			return new RoleBasedAccess(username, password, Admin.getInstance());
	}

	public void getGuestPage() throws AccessDeniedException{
		user.getGuestPage();
	}

	public void getPremiumPage() throws AccessDeniedException{
		user.getPremiumPage();
	}

	public void getAdminPage() throws AccessDeniedException{
		user.getAdminPage();
	}


	public void changeUser(state changeUser){
		this.user = changeUser;
	}

}
