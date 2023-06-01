package GUI_App;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



@SuppressWarnings("serial")
public class MainApp extends JFrame implements ActionListener {

	JLabel sessionLabel = new JLabel("Session");
        JLabel label = new JLabel();
	JButton garageMan = new JButton("Vehicule") ;
	JButton clientMan = new JButton("Clients") ;
	JButton exit  = new JButton("Log off") ;
	JButton rapport  = new JButton("Rapport") ;
	JButton rent = new JButton("Location") ;
	JButton retour  = new JButton("Retour") ; 
	JPanel panel = new JPanel();
	MainApp(String userID){
		
	
		label.setFont(new Font("Tahoma", 1, 36)); // NOI18N
                label.setForeground(new Color(0, 0, 255));
                label.setText("Gestionnaire");
		panel.setVisible(false);
		panel.setSize(300,400);
		this.setTitle("session :" + userID);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.setVisible(true);
		this.add(panel);
		garageMan.setVisible(true);
		garageMan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                garageManActionPerformed(evt);
            }
        });
		clientMan.setVisible(true);
		clientMan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	clientManActionPerformed(evt);
            }
        });

		exit.setVisible(true);
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	logoffActionPerformed(evt);
            }
        });
            
		rapport.setVisible(true);
		rapport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	//rapportActionPerformed(evt);
            }
        });
            
		rent.setVisible(true);
		rent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	locationActionPerformed(evt);
            }
        });
            
		retour.setVisible(true);
		retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	retourActionPerformed(evt);
            }
        });
            
		panel.add(sessionLabel);
		panel.add(garageMan);
		panel.add(clientMan);
		panel.add(rent);
		panel.add(retour);
		panel.add(rapport);
		panel.add(exit);
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label)
                        .addGap(121, 121, 121))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(garageMan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clientMan, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rent, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(retour, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(131, 131, 131))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label)
                .addGap(35, 35, 35)
                .addComponent(garageMan, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clientMan, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rent, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retour, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
	}
	private void garageManActionPerformed(ActionEvent evt) {
        Vehicule add = new Vehicule();       
        add.setVisible(true);   
    }

    private void clientManActionPerformed(ActionEvent evt) {
        Client add = new Client();
        add.setVisible(true);
    }
    
    private void locationActionPerformed(ActionEvent evt) {
        Location add = new Location();       
        add.setVisible(true);
    }
    private void retourActionPerformed(ActionEvent evt) {
        
         Retour add = new Retour();       
     
        add.setVisible(true);
        
    }
    
    /*
     * private void RapportActionPerformed(ActionEvent evt) {
    }
    
    */

    @SuppressWarnings({ "deprecation", "unchecked" })
	private void logoffActionPerformed(ActionEvent evt) {
    	IDandPasswords idandPasswords = new IDandPasswords();
    	LoginPage lo = new LoginPage();       
        this.hide();
        lo.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {		
	}
}