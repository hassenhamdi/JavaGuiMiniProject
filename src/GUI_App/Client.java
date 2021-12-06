package GUI_App;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Hassen Hamdi
 */
@SuppressWarnings("serial")
public class Client extends JFrame {
	private JLabel address;
    private JButton ajouter;
    private JButton annuler;
    private JLabel cin;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JLabel mobile;
    private JLabel name;
    private JTextField ncin;
    private JTextField nom;
    private JTextField txtaddresse;
    private JTextField txtmobile;

    public Client() {
        initComponents();
        table_update();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
  
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        name = new JLabel();
        cin = new JLabel();
        address = new JLabel();
        mobile = new JLabel();
        nom = new JTextField();
        ncin = new JTextField();
        txtmobile = new JTextField();
        ajouter = new JButton();
        annuler = new JButton();
        txtaddresse = new JTextField();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Gestionnaire des clients"));

        name.setText("Nom");

        cin.setText("CIN N°");

        address.setText("Addresse");

        mobile.setText("Mobile");

        nom.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                nomKeyPressed(evt);
            }
        });

        ncin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ncinActionPerformed(evt);
            }
        });

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        annuler.setText("Annuler");
        annuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        txtaddresse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtaddresseActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(cin)
                            .addComponent(address)
                            .addComponent(mobile))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(nom, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtmobile, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                        .addComponent(txtaddresse))
                                    .addComponent(ncin, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ajouter, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(annuler, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ncin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cin))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaddresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(address))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouter, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(annuler, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "Nom", "Addresse", "Mobile"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     @SuppressWarnings({ "rawtypes", "unchecked" })
	private void table_update() {
        int CC;
        try {
            String URL= "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,"root","");
            pst = con.prepareStatement("SELECT * FROM client");
            ResultSet Rs = pst.executeQuery();
            
   
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("CIN"));
                    v2.add(Rs.getString("nom"));
                    v2.add(Rs.getString("addresse"));
                     v2.add(Rs.getString("mobile"));
                }

                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }  
    
    
    
    
    private void ajouterActionPerformed(ActionEvent evt) {
        
           try {   
            String ccin =ncin.getText();
            String cnom =nom.getText();
            String caddresse =txtaddresse.getText();  
            String cmobile =txtmobile.getText();  
       
            String URL= "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,"root","");
            pst = con.prepareStatement("insert into client (cin,nom,addresse,mobile)values(?,?,?,?)");
            pst.setString(1,ccin);
            pst.setString(2,cnom);
            pst.setString(3,caddresse); 
            pst.setString(4,cmobile); 
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Sucsessfully Saved");
            
             ncin.setText("");
             txtaddresse.setText("");
             txtmobile.setText("");
          table_update();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    private void nomKeyPressed(KeyEvent evt) {
        
    }

    private void annulerActionPerformed(ActionEvent evt) {
         setVisible(false);
        dispose();
    }

    private void ncinActionPerformed(ActionEvent evt) {
    }

    private void txtaddresseActionPerformed(ActionEvent evt) {
    }
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    
}
