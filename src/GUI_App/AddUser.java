package GUI_App;


import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.util.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;


public class AddUser implements ActionListener {
	JPanel panel = new JPanel();
	JLabel username =new JLabel("Username");
	JLabel password= new JLabel("Password");
	JLabel confirm= new JLabel("Confirm");
	JTextField name = new JTextField();
	JPasswordField pwd = new JPasswordField();
	JPasswordField pwdc = new JPasswordField();
	JButton addbutton = new JButton();
	Connection con;
    PreparedStatement insertPst;
    PreparedStatement selectPst;
    ResultSet rs;
	AddUser(){
		panel.setVisible(true);
		panel.setSize(600,400);
		username.setVisible(true);
		password.setVisible(true);
		confirm.setVisible(true);

		name.setVisible(true);
		pwd.setVisible(true);
		pwdc.setVisible(true);
		
		addbutton.setVisible(true);
		addbutton.setText("Create");
		addbutton.setFocusable(false);
		addbutton.addActionListener(this);
		panel.add(username);
		panel.add(name);
		panel.add(password);
		panel.add(pwd);
		panel.add(confirm);
		panel.add(pwdc);
		panel.add(addbutton);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		int result = JOptionPane.showConfirmDialog(
			    null, panel, "new user", JOptionPane.OK_CANCEL_OPTION);
	}
        
        @SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addbutton){
                    String utilisateur ;
                    utilisateur = name.getText();
                    String pwd_Input = String.valueOf(pwd.getPassword());
                    String pwdc_Input = String.valueOf(pwdc.getPassword());
                    if(name.getText().isBlank()){
                        JOptionPane.showMessageDialog(null, "Nom utilisateur est vide", "Nom utilisateur non valide",JOptionPane.ERROR_MESSAGE); 
                    }
                    else if(pwd_Input.isBlank()|| pwdc_Input.isBlank()){
                        JOptionPane.showMessageDialog(null, "Inserer la mot de passes","mot de passe vide",JOptionPane.WARNING_MESSAGE);
                    }
                    else if(!pwd_Input.equals(pwdc_Input)){
                        JOptionPane.showMessageDialog(null, "Inserer des mots de passes identiques","mots de passe non identiques" ,JOptionPane.ERROR_MESSAGE );
                    }
                    else if(pwd_Input.equals(pwdc_Input) && !utilisateur.isBlank()){
                    	if (utilisateur.equals(pwd_Input)) {
                            JOptionPane.showMessageDialog(null, "Insèrer de mot de passe différente du nom utilisateur","mot de passe vulnérable" ,JOptionPane.ERROR_MESSAGE );
						}
                        try {
                        String URL= "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection(URL,"root","");
                        selectPst = con.prepareStatement("select * from utilisateur");
                        rs = selectPst.executeQuery();
                        boolean isFound = false; // alternative variable name, noInsertConditionIsFound ;
                        while (rs.next()) {
							if (rs.getString(1).equals(utilisateur)){
								JOptionPane.showMessageDialog(null, "Sasir un nom utilisateur différent","Existant Username", JOptionPane.WARNING_MESSAGE);
								isFound = true ;
								break;
							}
						}
                        
                        insertPst = con.prepareStatement("insert into Utilisateur (utilisateur,password)values(?,?)");
                        insertPst.setString(1,utilisateur);
                        insertPst.setString(2,pwd_Input);
                        if(!isFound) {
                        	insertPst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Sucsessfully Saved","Utilisateur Ajouté ",JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        name.setText("");
                        pwd.setText("");
                        pwdc.setText("");            
                        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                    }
                }
                    
                    
                            
	 }
	
	

	
}
