package GUI_App;


import java.awt.event.*;
import javax.swing.*;


public class AddUser implements ActionListener {
	JPanel panel = new JPanel();
	JLabel username =new JLabel("Username");
	JLabel password= new JLabel("Password");
	JLabel confirm= new JLabel("Confirm");
	JTextField name = new JTextField();
	JPasswordField pwd = new JPasswordField();
	JPasswordField pwdc = new JPasswordField();
	JButton addbutton = new JButton();
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
