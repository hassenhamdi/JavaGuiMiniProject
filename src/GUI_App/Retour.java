package GUI_App;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hassen Hamdi
 */

@SuppressWarnings("serial")
public class Retour extends JFrame {
    private String URL= "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
    private JButton annuler;
    private JTextField ccin;
    private JLabel cinl;
    private JLabel datretlab;
    private JTextField datretxt;
    private JLabel feelab;
    private JTextField feetxt;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTextField matxt;
    private JButton ok;
    private JPanel panel;
    private JLabel retlab;
    private JLabel retourlab;
    private JTextField retxt;
    private JTable tab;
    Connection con ;
    PreparedStatement pst = null; 
    PreparedStatement pst2 = null; 
    PreparedStatement pst3 = null; 
    ResultSet rs;
    
    
    public Retour() {
        initComponents();
        table_update();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new JPanel();
        jLabel1 = new JLabel();
        matxt = new JTextField();
        cinl = new JLabel();
        ccin = new JTextField();
        datretxt = new JTextField();
        retxt = new JTextField();
        feetxt = new JTextField();
        datretlab = new JLabel();
        retlab = new JLabel();
        feelab = new JLabel();
        ok = new JButton();
        annuler = new JButton();
        retourlab = new JLabel();
        jScrollPane1 = new JScrollPane();
        tab = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        panel.setBorder(BorderFactory.createTitledBorder(null, "Retour", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 14)));
        jLabel1.setText("Matricule");
        matxt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                matxtMouseClicked(evt);
            }
        });
        matxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                matxtActionPerformed(evt);
            }
        });
        matxt.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                matxtKeyPressed(evt);
            }
        });

        cinl.setText("CIN");

        datretxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                datretxtActionPerformed(evt);
            }
        });
        datretlab.setText("Date retour");
        retlab.setText("jours en retard");
        feelab.setText("Amende");
        ok.setText("Ok");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        annuler.setText("Annuler");
        annuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(matxt, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(datretlab)
                                    .addComponent(cinl)
                                    .addComponent(retlab))
                                .addGap(30, 30, 30)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ccin)
                                        .addComponent(datretxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(retxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(feelab)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(feetxt, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(ok, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(annuler, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(matxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ccin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cinl, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(datretxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(datretlab))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(retxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(retlab))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(feetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(feelab))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ok, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(annuler, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        retourlab.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        tab.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "CIN", "Matricule", "Date retour", "retard", "Amende"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(retourlab)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(retourlab)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    private void matxtActionPerformed(ActionEvent evt) {                                                    
    }                                     
    private void matxtMouseClicked(MouseEvent evt) {                                   
    }                                  
     @SuppressWarnings({ "unchecked", "rawtypes" })
	private void table_update() {
        int CC;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,"root","");
            pst = con.prepareStatement("SELECT * FROM Retour");
             ResultSet Rs = pst.executeQuery();               
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) tab.getModel();
            DFT.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("matricule"));
                    v2.add(Rs.getString("CIN"));
                    v2.add(Rs.getString("date_retour"));
                    v2.add(Rs.getString("retard"));
                    v2.add(Rs.getString("amende"));
                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }  
    
    private void matxtKeyPressed(KeyEvent evt) {                                 
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {     
            try {                
                System.out.println("hi");
                String matxts =matxt.getText();                              
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL,"root","");
                pst = con.prepareStatement("select matricule,cin,datefin,DATEDIFF(NOW(),datefin) as retard from location where matricule = ? ");
                 pst.setString(1,matxts);
                rs = pst.executeQuery();  
                if(rs.next()==false)
                {                   
                    JOptionPane.showMessageDialog(null, "Voiture non trouvée");
                }
                else
                {
                   String newcin ;
                   String cin = rs.getString("CIN"); 
                   newcin =  cin.length()==7 ? "0" + cin : cin ;
                   ccin.setText(newcin.trim());
                   
                   String dateret = rs.getString("datefin");          
                   datretxt.setText(dateret.trim());
                   
                    String ret = rs.getString("retard");                      
                     
                  int retard = Integer.parseInt(ret);
                  
                  if(retard >0)
                  {
                       retxt.setText(ret);
                   
                       int amend = retard * 130 ;
                  
                       feetxt.setText(String.valueOf(amend));
                       JOptionPane.showMessageDialog(this, ret);

                   
                  }
                  else
                  {
                      retxt.setText("0");
                      feetxt.setText("0");                    
                  }                                 
                }                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                
    private void okActionPerformed(ActionEvent evt) {                                   
    	
          try {  
            String matxt1 = matxt.getText();
            String cin = ccin.getText();
            String datret = datretxt.getText();
            String retard = retxt.getText();
            String amend = feetxt.getText();            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,"root","");
            pst3 = con.prepareStatement("insert into Retour (matricule,CIN,date_retour,retard,amende)values(?,?,?,?,?)");
            pst3.setString(1,matxt1);
            pst3.setString(2,cin);
            pst3.setString(3,datret); 
            pst3.setString(4,retard); 
            pst3.setString(5,amend); 
            pst3.executeUpdate();            
            pst = con.prepareStatement("update Voitures set Disponibilite = 'Yes' where matricule = ?  ");
            pst.setString(1, matxt1);
            pst.executeUpdate();            
            pst2 = con.prepareStatement("Delete from Location where matricule = ?  ");
            pst2.setString(1, matxt1);
            pst2.executeUpdate();                        
            JOptionPane.showMessageDialog(this, "Mise à jour avec Success");
            table_update();
        } 
          catch (ClassNotFoundException ex)
          {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);            
        } 
          catch (SQLException ex) 
          {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);           
        }       
    }                                  
    private void annulerActionPerformed(ActionEvent evt) {                                        
         setVisible(false);
        dispose();
    }                                       
    private void datretxtActionPerformed(ActionEvent evt) {                                         
    }                                        
    public static void main(String args[]) {        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retour().setVisible(true);
            }
        });
    }
              
}
