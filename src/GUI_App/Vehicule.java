package GUI_App;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;


/**
 *
 * @author Hassen Hamdi
 */

@SuppressWarnings("serial")
public class Vehicule extends JFrame {

	PreparedStatement insert;
	Connection con;
	private String URL = "jdbc:mysql://127.0.0.1:3306/projetjava?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
	private JButton add;
	private JButton all;
	private JButton cancel;
	private JComboBox<String> cbxdisp;
	private JButton delete;
	private JButton disp;
	private JButton edit;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JLabel lcol;
	private JLabel ldis;
	private JLabel lmod;
	private JLabel matlab;
	private JTextField matxt;
	private JPanel panel;
	private JTable tab;
	private JTextField tcol;
	private JTextField tmarq;
	private JTextField tmod;

	public Vehicule() {
		initComponents();
		tab_update();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		panel = new JPanel();
		matlab = new JLabel();
		matxt = new JTextField();
		jLabel2 = new JLabel();
		tmarq = new JTextField();
		ldis = new JLabel();
		tmod = new JTextField();
		add = new JButton();
		lmod = new JLabel();
		cbxdisp = new JComboBox<>();
		cancel = new JButton();
		edit = new JButton();
		delete = new JButton();
		lcol = new JLabel();
		tcol = new JTextField();
		jScrollPane1 = new JScrollPane();
		tab = new JTable();
		disp = new JButton();
		all = new JButton();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		panel.setBorder(BorderFactory.createTitledBorder(null, "Gestionnaire des voitures",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				new Font("Tahoma", 1, 14)));

		matlab.setFont(new Font("Tahoma", 1, 18));
		matlab.setText("Matricule");

		matxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				matxtActionPerformed(evt);
			}
		});

		jLabel2.setFont(new Font("Tahoma", 1, 18));
		jLabel2.setText("Marque");

		ldis.setFont(new Font("Tahoma", 1, 18));
		ldis.setText("Disponibilité");

		add.setFont(new Font("Tahoma", 1, 14));
		add.setText("Ajout");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addActionPerformed(evt);
			}
		});

		lmod.setFont(new Font("Tahoma", 1, 18));
		lmod.setText("Modele");

		cbxdisp.setFont(new Font("Tahoma", 1, 14));
		cbxdisp.setModel(new DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
		cbxdisp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cbxdispActionPerformed(evt);
			}
		});

		cancel.setText("Annuler");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelActionPerformed(evt);
			}
		});

		edit.setText("Modifier");
		edit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				editMouseClicked(evt);
			}
		});
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				editActionPerformed(evt);
			}
		});

		delete.setText("Supprimer");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});

		lcol.setFont(new Font("Tahoma", 1, 18));
		lcol.setText("Couleur");

		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelLayout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(edit, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(add, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 106,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(cancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(delete, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(panelLayout.createSequentialGroup().addGap(25, 25, 25)
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panelLayout.createSequentialGroup().addComponent(ldis)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(cbxdisp, GroupLayout.PREFERRED_SIZE, 146,
												GroupLayout.PREFERRED_SIZE)
										.addGap(0, 34, Short.MAX_VALUE))
								.addGroup(panelLayout.createSequentialGroup()
										.addGroup(panelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(matlab)
												.addComponent(jLabel2).addComponent(lmod).addComponent(lcol))
										.addGap(39, 39, 39)
										.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(matxt).addComponent(tcol)
												.addComponent(tmod, GroupLayout.Alignment.TRAILING)
												.addComponent(tmarq, GroupLayout.Alignment.TRAILING))
										.addGap(26, 26, 26)))));
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(panelLayout
						.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(matlab).addComponent(matxt,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tmarq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2))
				.addGap(18, 18, 18)
				.addGroup(
						panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lmod).addComponent(
								tmod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(25, 25, 25)
				.addGroup(
						panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lcol).addComponent(
								tcol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(ldis))
						.addComponent(cbxdisp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(27, 27, 27)
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(edit, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));

		tab.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Matricule", "Marque", "Modele", "Couleur", "Disponibilté" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };

			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		tab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tabMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tab);

		disp.setText("Disponible");
		disp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				dispMouseClicked(evt);
			}
		});
		disp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispActionPerformed(evt);
			}
		});

		all.setText("Afficher tout");
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				allActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(disp, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addGap(36, 36, 36)
										.addComponent(all, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addGap(89, 89, 89)))));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(disp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addComponent(all, GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panel.getAccessibleContext().setAccessibleName("Registre des voitures");

		pack();
		setLocationRelativeTo(null);
	}

	private void addActionPerformed(ActionEvent evt) {

		try {
			String mat = matxt.getText();

			String marque = tmarq.getText();
			String modele = tmod.getText();
			String col = tcol.getText();
			String disp = cbxdisp.getSelectedItem().toString();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "");
			insert = con.prepareStatement("insert into voitures (matricule,marque,modele,Couleur,disponibilite)values(?,?,?,?,?)");
			insert.setString(1, mat);
			insert.setString(2, marque);
			insert.setString(3, modele);
			insert.setString(4, col);
			insert.setString(5, disp);

			insert.executeUpdate();
			JOptionPane.showMessageDialog(this, "La voiture a été enregistrée avec succéss");

			tmarq.setText("");
			tmod.setText("");
			tab_update();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void cancelActionPerformed(ActionEvent evt) {

		setVisible(false);
		dispose();
	}

	private void editActionPerformed(ActionEvent evt) {
		DefaultTableModel model = (DefaultTableModel) tab.getModel();
		int selectedIndex = tab.getSelectedRow();
		try {
			String matricule = model.getValueAt(selectedIndex, 0).toString();
			String marque = tmarq.getText();
			String modele = tmod.getText();
			String color = tcol.getText();
			String status = cbxdisp.getSelectedItem().toString();

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "");
			insert = con.prepareStatement("update Voitures set marque= ?,modele= ?,Couleur= ?,disponibilite =? where matricule = ?");
			insert.setString(1, marque);
			insert.setString(2, modele);
			insert.setString(4, status);
			insert.setString(3, color);
			insert.setString(5, matricule);
			insert.executeUpdate();
			JOptionPane.showMessageDialog(this, "Le registre a été mis à jour");

			edit.setEnabled(false);
			add.setEnabled(true);

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void editMouseClicked(MouseEvent evt) {
	

		String matricule = matxt.getText();

		String marque = tmarq.getText();
		String modele = tmod.getText();
		String color = tcol.getText();
		String disp = cbxdisp.getSelectedItem().toString();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "");
			insert = con.prepareStatement(
					"update voitures set marque= ?,modele= ?,Couleur = ?,disponibilite=?  where matricule= ?");

			insert.setString(1, marque);
			insert.setString(2, modele);
			insert.setString(3, color);
			insert.setString(4, disp);
			insert.setString(5,matricule);
			insert.executeUpdate();
			JOptionPane.showMessageDialog(this, "Le registre a été mis à jour");

			edit.setEnabled(false);
			add.setEnabled(true);
			tab_update();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void tabMouseClicked(MouseEvent evt) {
		DefaultTableModel d1 = (DefaultTableModel) tab.getModel();
		int selectIndex = tab.getSelectedRow();
		matxt.setText(d1.getValueAt(selectIndex, 0).toString());
		tmarq.setText(d1.getValueAt(selectIndex, 1).toString());
		tmod.setText(d1.getValueAt(selectIndex, 2).toString());
		tcol.setText(d1.getValueAt(selectIndex, 3).toString());
		cbxdisp.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
		edit.setEnabled(true);
	}
	private void deleteActionPerformed(ActionEvent evt) {
		DefaultTableModel model = (DefaultTableModel) tab.getModel();
		int selectedIndex = tab.getSelectedRow();
		try {

			String mat = model.getValueAt(selectedIndex, 0).toString();
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record", "Warning",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(URL, "root", "");
				insert = con.prepareStatement("delete from voitures where matricule = ?");
				insert.setString(1, mat);
				insert.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Delete");
				edit.setEnabled(false);
				tab_update();
			}
			add.setEnabled(true);
			edit.setEnabled(false);

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Vehicule.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void cbxdispActionPerformed(ActionEvent evt) {
		tab_update();
	}
	private void allActionPerformed(ActionEvent evt) {
		tab_update();
	}
	private void dispMouseClicked(MouseEvent evt) {
		tab_disp();

	}

	private void dispActionPerformed(ActionEvent evt) {
		tab_disp();
	}

	private void matxtActionPerformed(ActionEvent evt) {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void tab_update() {
		int CC;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "");
			insert = con.prepareStatement("SELECT * FROM voitures");
			ResultSet Rs = insert.executeQuery();

			ResultSetMetaData RSMD = Rs.getMetaData();
			CC = RSMD.getColumnCount();
			DefaultTableModel DFT = (DefaultTableModel) tab.getModel();
			DFT.setRowCount(0);

			while (Rs.next()) {
				Vector<String> v2 = new Vector();
				for (int ii = 0; ii < CC; ii++) {
					v2.add(Rs.getString("Matricule"));
					v2.add(Rs.getString("Marque"));
					v2.add(Rs.getString("modele"));
					v2.add(Rs.getString("Couleur"));
					v2.add(Rs.getString("Disponibilite"));
				}
				DFT.addRow(v2);
			}
		} catch (Exception e) {
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void tab_disp() {
		int CC;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "");
			insert = con.prepareStatement("SELECT * FROM voitures where disponibilite = 'Yes'");
			ResultSet Rs = insert.executeQuery();
			ResultSetMetaData RSMD = Rs.getMetaData();
			CC = RSMD.getColumnCount();
			DefaultTableModel DFT = (DefaultTableModel) tab.getModel();
			DFT.setRowCount(0);
			while (Rs.next()) {
				Vector v2 = new Vector();
				for (int ii = 0; ii < CC; ii++) {
					v2.add(Rs.getString("Matricule"));
					v2.add(Rs.getString("Marque"));
					v2.add(Rs.getString("modele"));
					v2.add(Rs.getString("Couleur"));
					v2.add(Rs.getString("Disponibilite"));
				}
				DFT.addRow(v2);
			}
		} catch (Exception e) {
		}
	}
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Vehicule().setVisible(true);
			}
		});
	}

}
