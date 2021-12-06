package GUI_App;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

/**
*
* @author Hassen Hamdi
*/


@SuppressWarnings("serial")
public class Location extends JFrame {
	private JButton Annuler;
    private JLabel ccin;
    private JLabel cnom;
    @SuppressWarnings("rawtypes")
	private JComboBox combox;
    private JLabel datedeb;
    private JDateChooser datedebc;
    private JLabel datefin;
    private JDateChooser datefinc;
    private JLabel displabel;
    private JLabel dispo;
    private JPanel jPanel1;
    private JLabel matricule;
    private JLabel montant;
    private JButton ok;
    private JTextField tcin;
    private JTextField tmontant;
    private JTextField tnom;
    private String URL= "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";


    public Location() {
        initComponents();

        LoadCategory();
        datedebc.setDateFormatString("yyyy/MM/dd");
        datefinc.setDateFormatString("yyyy/MM/dd");
    }
    Connection connect;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    ResultSet rs;
    ResultSet rs1;
    @SuppressWarnings("unchecked")
	public void LoadCategory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect= DriverManager.getConnection(URL, "root", "");
            ps = connect.prepareStatement("SELECT * FROM voitures");
            rs = ps.executeQuery();
            combox.removeAllItems();
            while (rs.next()) {
                combox.addItem(rs.getString(1)+" "+rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("rawtypes")
	private void initComponents() {

        jPanel1 = new JPanel();
        combox = new JComboBox();
        matricule = new JLabel();
        ccin = new JLabel();
        tcin = new JTextField();
        cnom = new JLabel();
        tnom = new JTextField();
        datedeb = new JLabel();
        datefin = new JLabel();
        ok = new JButton();
        Annuler = new JButton();
        montant = new JLabel();
        tmontant = new JTextField();
        displabel = new JLabel();
        datedebc = new JDateChooser();
        datefinc = new JDateChooser();
        dispo = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Location", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 14))); // NOI18N

        combox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboxActionPerformed(evt);
            }
        });

        matricule.setText("Nom");

        ccin.setText("CIN Client");

        tcin.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                tcinKeyPressed(evt);
            }
        });

        cnom.setText("Nom du Client");


        datedeb.setText("Date de depart");

        datefin.setText("Date du écheance");

        ok.setText("ok");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okActionPerformed(evt);
            }
        });


        Annuler.setText("Annuler");
        Annuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        montant.setText("montant de location");

        displabel.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        displabel.setText("Disponible");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ok, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Annuler, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(matricule, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(tcin, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(montant, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cnom))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tnom, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datedebc, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tmontant, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datefinc, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(combox, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                            .addComponent(ccin)
                            .addComponent(datedeb)
                            .addComponent(datefin))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(displabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dispo, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(datedebc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dispo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(matricule)
                                    .addComponent(combox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displabel))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(ccin)
                                            .addComponent(tcin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(cnom)
                                            .addComponent(tnom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(montant)
                                    .addComponent(tmontant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(datedeb)))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(datefin, GroupLayout.Alignment.TRAILING)
                    .addComponent(datefinc, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ok, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Annuler, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void okActionPerformed(ActionEvent evt) {                                   
        try {

            String mat = combox.getSelectedItem().toString().substring(0, 9);
            String cin = tcin.getText();
            Long montant = Long.parseLong(tmontant.getText());
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String dated = Date_Format.format(datedebc.getDate());
            SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
            String datef = Date_Format1.format(datefinc.getDate());
            LocalDate deb = LocalDate.parse(dated);
        	LocalDate fin = LocalDate.parse(datef);
        	Long nj = ChronoUnit.DAYS.between(deb, fin);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect= DriverManager.getConnection(URL, "root", "");
            ps = connect.prepareStatement("insert into location  (matricule,cin,montant,datedeb,datefin)values(?,?,?,?,?)");
            Long o = montant * nj ;
            String mon_tal = o.toString(); 
            ps.setString(1, mat);
            ps.setString(2, cin);
            ps.setString(3, mon_tal);
            ps.setString(4, dated);
            ps.setString(5, datef);
            ps.executeUpdate();

            ps1 = connect.prepareStatement("update voitures set disponibilite = 'No' where  matricule = ?  ");
            ps1.setString(1, mat);
            ps1.executeUpdate();

            JOptionPane.showMessageDialog(this, "Enregistrer avec success ");
            this.dispose();
            Location window = new Location();
            window.setVisible(true);
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }


    }                                  
                                    

    private void tcinKeyPressed(KeyEvent evt) {                                
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {

                System.out.println("hi");
                String cin = tcin.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                connect= DriverManager.getConnection(URL, "root", "");
                ps = connect.prepareStatement("select * from client where CIN = ? ");
                ps.setString(1, cin);
                rs = ps.executeQuery();

                if (rs.next() == false) {

                    JOptionPane.showMessageDialog(null, "Client non trouvée");
                } else {
                    String productname = rs.getString("nom");

                    tnom.setText(productname.trim());

                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                               

    private void comboxActionPerformed(ActionEvent evt) {                                       
        try {
            String mat = combox.getSelectedItem().toString().substring(0,9);

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect= DriverManager.getConnection(URL , "root", "");
            ps2 = connect.prepareStatement("select * from voitures where Matricule = ? ");
            ps2.setString(1, mat);
            rs1 = ps2.executeQuery();

            if (rs1.next() == false) 
            {
                JOptionPane.showMessageDialog(null, "Voiture non trouvée");
            } 
            else {            
                String d = rs1.getString("disponibilite");
                dispo.setFont(new Font("Tahoma",Font.ITALIC,20));
                dispo.setText(d.trim());
                if (d.equals("Yes") )
                {   
                    tcin.setEnabled(true);
                    tnom.setEnabled(true);
                    tmontant.setEnabled(true);
                    datedebc.setEnabled(true);
                    datefinc.setEnabled(true);
                } 
                else 
                {           
                    tcin.setEnabled(false);
                    tnom.setEnabled(false);
                    datedebc.setEnabled(false);
                    datefinc.setEnabled(false);
                     tmontant.setEnabled(false);
                }

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }


    }                                      
    private void AnnulerActionPerformed(ActionEvent evt) {                                        
         setVisible(false);
        dispose();
    }                                       
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Location().setVisible(true);
            }
        });
    }

}

