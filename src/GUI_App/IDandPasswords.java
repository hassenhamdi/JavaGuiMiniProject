package GUI_App;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("admin","adminpwd");
	}
        IDandPasswords(String username,String password){
        }
	
	@SuppressWarnings("rawtypes")
	public HashMap getLoginInfo(){
		return logininfo;
	}
}

