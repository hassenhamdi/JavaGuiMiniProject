package GUI_App;
public class Main {

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords();
				
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

	}
}

