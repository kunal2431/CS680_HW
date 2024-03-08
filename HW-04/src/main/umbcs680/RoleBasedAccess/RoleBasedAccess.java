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
		Pages p1 = new Pages();
		p1.GuestPage();
	}

	@Override
	public void getPremiumPage() throws AccessDeniedException{
		throw new AccessDeniedException("Premium Page access Denied");
	}

	@Override
	public void getAdminPage() throws AccessDeniedException{
		throw new AccessDeniedException("Admin Page access Denied");
	}

	@Override
	public void premiumSubscribe(float amount) throws AccessDeniedException{
		if(amount >= 500){
			RoleBasedAccess.changeUser(PremiumUser.getInstance());
		}
		else{
			throw new AccessDeniedException("Premium amount is less");
		}
	}

	public void premiumSubscribeExpired(){

	}

	@Override
	public void AdminLogin(String username, String password) throws AccessDeniedException{
		try {
			RoleBasedAccess.changeUser(Admin.getInstance(username, password));
		}
		catch (AccessDeniedException ex){
			System.out.println(ex.getMessage());
		}
	}

	public void Adminlogout(){

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
		Pages p1 = new Pages();
		p1.GuestPage();
	}

	@Override
	public void getPremiumPage() throws AccessDeniedException{
		Pages p2 = new Pages();
		p2.PremiumPage();
	}

	@Override
	public void getAdminPage() throws AccessDeniedException{
		throw new AccessDeniedException("Admin Page access Denied");
	}

	public void premiumSubscribe(float amount) throws AccessDeniedException{

	}
	@Override
	public void premiumSubscribeExpired(){
			RoleBasedAccess.changeUser(Guest.getInstance());
	}

	@Override
	public void AdminLogin(String username, String password) throws AccessDeniedException{
		try {
			RoleBasedAccess.changeUser(Admin.getInstance(username, password));
		}
		catch (AccessDeniedException ex){
			System.out.println(ex.getMessage());
		}
	}

	public void Adminlogout(){

	}

}

class Admin implements state{

	private static Admin instance = null;
	private Admin(){

	}

	public static Admin getInstance(String username, String password) throws AccessDeniedException {
		if (username == "Admin" && password == "pwd"){
			try{
				return Objects.requireNonNull(instance);
			}
			catch(NullPointerException ex){
				instance = new Admin();
				return instance;
			}
		}
		else{
			throw new AccessDeniedException("Credentials are wrong");
		}
	}
	@Override
	public void getGuestPage() throws AccessDeniedException{
		Pages p1 = new Pages();
		p1.GuestPage();
	}

	@Override
	public void getPremiumPage() throws AccessDeniedException{
		Pages p2 = new Pages();
		p2.PremiumPage();
	}

	@Override
	public void getAdminPage() throws AccessDeniedException{
		Pages p3 = new Pages();
		p3.AdminPage();
	}

	public void premiumSubscribe(float amount) throws AccessDeniedException{

	}
	public void premiumSubscribeExpired(){

	}

	public void AdminLogin(String username, String password) throws AccessDeniedException{

	}

	@Override
	public void Adminlogout(){
		RoleBasedAccess.changeUser(Guest.getInstance());
	}

}

public class RoleBasedAccess {

	private static state user;

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
	public static RoleBasedAccess createAdminInstance(String username, String password) throws AccessDeniedException {
			return new RoleBasedAccess(username, password, Admin.getInstance(username, password));
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

	public void premiumSubscribe(float amount) throws AccessDeniedException{
		user.premiumSubscribe(amount);
	}
	public void premiumSubscribeExpired(){
		user.premiumSubscribeExpired();
	}

	public void AdminLogin(String username, String password) throws AccessDeniedException{
		user.AdminLogin(username, password);
	}

	public void Adminlogout(){
		user.Adminlogout();
	}

	public static void changeUser(state changeUser){
		user = changeUser;
	}

}