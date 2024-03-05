package umbcs680.RoleBasedAccess;

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
	public String getGuestPage() {
        return "Guest Page : Access Granted";
	}

	@Override
	public String getPremiumPage() {
        return "Premium Page : Access Denied";
	}

	@Override
	public String getAdminPage() {
		return "Admin Page : Access Denied";
	}

	@Override
	public String logout() {
		instance=null;
		return "Logged out";
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
	public String getGuestPage() {
		return "Guest Page : Access Granted";
	}

	@Override
	public String getPremiumPage() {
		return "Premium Page : Access Granted";
	}

	@Override
	public String getAdminPage() {
		return "Admin Page : Access Denied";
	}

	@Override
	public String logout() {
		instance=null;
		return "Logged out";
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
	public String getGuestPage() {
		return "Guest Page : Access Granted";
	}

	@Override
	public String getPremiumPage() {
		return "Premium Page : Access Granted";
	}

	@Override
	public String getAdminPage() {
		return "Admin Page : Access Granted";
	}

	@Override
	public String logout() {
		instance=null;
		return "Logged out";
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

	public String getGuestPage() {
		return user.getGuestPage();
	}

	public String getPremiumPage() {
		return user.getPremiumPage();
	}

	public String getAdminPage() {
		return user.getAdminPage();
	}

	public String logout() {
		return user.logout();
	}

	public void changeUser(state changeUser){
		user.logout();
		this.user = changeUser;
	}


}
