package GUI_App;
import java.awt.*;
import java.awt.event.*;
import java.beans.JavaBean;
import java.sql.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener{
	
	JButton newuser = new JButton("Add user");
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel authentificationLabel = new JLabel("Authentification");
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
	LoginPage(){
		authentificationLabel.setBounds(137,50,200,35);
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		authentificationLabel.setFont(new Font(null,Font.BOLD,21)); 
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		newuser.setBounds(75,200,100,25);
		newuser.setFocusable(false);
		newuser.addActionListener(this);
		
		loginButton.setBounds(175,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(275,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		this.add(authentificationLabel);
		this.add(userIDLabel);
		this.add(userPasswordLabel);
		this.add(messageLabel);
		this.add(userIDField);
		this.add(userPasswordField);
		this.add(newuser);
		this.add(loginButton);
		this.add(resetButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,420);
                this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Authentification");
                userIDField.addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent evt){
                    userIDFieldKeyPressed(evt);
                }
                });
		try {
                    int CC;
                    String URL= "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(URL,"root","");
                    pst = con.prepareStatement("SELECT * FROM Utilisateur");
                    ResultSet Rs = pst.executeQuery();
            
   
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();

            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    logininfo.put(Rs.getString("Utilisateur"),Rs.getString("password"));
                }
                
            }
        } catch (Exception e) {
        }
	}
        public void login(){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Success", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    
                    this.dispose();
                    MainApp app = new MainApp(userID);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Verify password", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "VERIFY USERNAME", "USER NOT FOUND", JOptionPane.ERROR_MESSAGE);

			}
        }
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()==loginButton) {
			login();
		}
		if(e.getSource()==newuser) {
			AddUser newacc =new AddUser();
		}
	}
        private void userIDFieldKeyPressed(KeyEvent evt){
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                login();
            }
        }
}