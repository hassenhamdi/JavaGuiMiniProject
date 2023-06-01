package GUI_App;

	/**
	 *
	 * @author Hassen Hamdi
	 */
	@SuppressWarnings("serial")
	public class Facturedial extends javax.swing.JDialog {

	    /**
	     * Creates new form Facturedial
	     */
	    public Facturedial(java.awt.Frame parent, boolean modal) {
	        super(parent, modal);
	        initComponents();
	        setLocationRelativeTo(null);
	    }

	    private void initComponents() {

	        jPanel3 = new javax.swing.JPanel();
	        nomclient1 = new javax.swing.JLabel();
	        Montant2 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        Montant3 = new javax.swing.JLabel();
	        clitxt1 = new javax.swing.JTextField();
	        paytxt1 = new javax.swing.JTextField();
	        periodtxt1 = new javax.swing.JTextField();
	        montxt1 = new javax.swing.JTextField();
	        amendtxt2 = new javax.swing.JTextField();
	        imprim1 = new javax.swing.JButton();
	        amendtxt3 = new javax.swing.JTextField();
	        jLabel6 = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jPanel3.setOpaque(false);

	        nomclient1.setText("Le client :");

	        Montant2.setText("Doit payer :");

	        jLabel4.setText("montant de location  : ");

	        jLabel5.setText("Amende :");

	        Montant3.setText("Periode de location :");

	        clitxt1.setEditable(false);

	        paytxt1.setEditable(false);

	        periodtxt1.setEditable(false);

	        montxt1.setEditable(false);

	        amendtxt2.setEditable(false);

	        imprim1.setText("Imprimer");
	        imprim1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                imprim1ActionPerformed(evt);
	            }
	        });

	        amendtxt3.setEditable(false);

	        jLabel6.setText("Total :");

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(imprim1)
	                .addGap(27, 27, 27))
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addGap(29, 29, 29)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addComponent(nomclient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(Montant2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(Montant3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
	                    .addComponent(jLabel4)
	                    .addComponent(jLabel5)
	                    .addComponent(jLabel6))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(amendtxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(amendtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(montxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(clitxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(paytxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(periodtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(208, Short.MAX_VALUE))
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addGap(41, 41, 41)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(nomclient1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(clitxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Montant2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(paytxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Montant3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(periodtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel4)
	                    .addComponent(montxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5)
	                    .addComponent(amendtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(amendtxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel6))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(imprim1)
	                .addGap(25, 25, 25))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }                     
       

	    private void imprim1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
	        // TODO add your handling code here:
	    }                                       

	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Facturedial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Facturedial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Facturedial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Facturedial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                Facturedial dialog = new Facturedial(new javax.swing.JFrame(), true);
	                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
	                    @Override
	                    public void windowClosing(java.awt.event.WindowEvent e) {
	                        System.exit(0);
	                    }
	                });
	                dialog.setVisible(true);
	            }
	        });
	    }
	    private javax.swing.JLabel Montant2;
	    private javax.swing.JLabel Montant3;
	    private javax.swing.JTextField amendtxt2;
	    private javax.swing.JTextField amendtxt3;
	    private javax.swing.JTextField clitxt1;
	    private javax.swing.JButton imprim1;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JPanel jPanel3;
	    private javax.swing.JTextField montxt1;
	    private javax.swing.JLabel nomclient1;
	    private javax.swing.JTextField paytxt1;
	    private javax.swing.JTextField periodtxt1;
	}
	
