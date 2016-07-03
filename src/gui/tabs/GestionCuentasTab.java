package gui.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import database.Database;
import database.classes.Profesional_Sanitario;
import gui.dialogs.ModificarDatosDialog;
import gui.dialogs.ModificarPassDialog;
import gui.dialogs.ModificarUsuarioDialog;
import gui.dialogs.NuevoUsuarioDialog;
import gui.frames.HelpWindow;

import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionCuentasTab extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 * @param currentUser 
	 */
	@SuppressWarnings("rawtypes")
	public GestionCuentasTab(Profesional_Sanitario currentUser) {
		setFrameIcon(null);
		setSize(700, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 241, 0, 200, 179, 0, 0};
		gridBagLayout.rowHeights = new int[]{15, 15, 25, 25, 25, 96, 1, 49, 0, 25, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblShowProfesional = new JLabel(currentUser.getNombre() + " " + currentUser.getApellidos());
		GridBagConstraints gbc_lblShowProfesional = new GridBagConstraints();
		gbc_lblShowProfesional.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblShowProfesional.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowProfesional.gridx = 1;
		gbc_lblShowProfesional.gridy = 0;
		getContentPane().add(lblShowProfesional, gbc_lblShowProfesional);
		
		JLabel lblShowCorreo = new JLabel(currentUser.getEmail());
		GridBagConstraints gbc_lblShowCorreo = new GridBagConstraints();
		gbc_lblShowCorreo.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblShowCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowCorreo.gridx = 1;
		gbc_lblShowCorreo.gridy = 1;
		getContentPane().add(lblShowCorreo, gbc_lblShowCorreo);
		
		JButton btnChangeUser = new JButton("Cambiar Email");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuarioDialog.createAndShowDialog();
			}
		});
		GridBagConstraints gbc_btnChangeUser = new GridBagConstraints();
		gbc_btnChangeUser.anchor = GridBagConstraints.NORTH;
		gbc_btnChangeUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChangeUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnChangeUser.gridx = 1;
		gbc_btnChangeUser.gridy = 2;
		getContentPane().add(btnChangeUser, gbc_btnChangeUser);
		
		JButton btnChagePassword = new JButton("Cambiar Contraseña");
		btnChagePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarPassDialog.createAndShowDialog(currentUser.getEmail());
			}
		});
		GridBagConstraints gbc_btnChagePassword = new GridBagConstraints();
		gbc_btnChagePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChagePassword.anchor = GridBagConstraints.NORTH;
		gbc_btnChagePassword.insets = new Insets(0, 0, 5, 5);
		gbc_btnChagePassword.gridx = 1;
		gbc_btnChagePassword.gridy = 3;
		getContentPane().add(btnChagePassword, gbc_btnChagePassword);
		
		//JList listUsers = new JList(SearchData.search("Paciente").get(0));
		JList listUsers = new JList();
		GridBagConstraints gbc_listUsers = new GridBagConstraints();
		gbc_listUsers.gridwidth = 2;
		gbc_listUsers.gridheight = 8;
		gbc_listUsers.anchor = GridBagConstraints.NORTHWEST;
		gbc_listUsers.insets = new Insets(0, 0, 5, 5);
		gbc_listUsers.gridx = 3;
		gbc_listUsers.gridy = 1;
		getContentPane().add(listUsers, gbc_listUsers);
		
		JButton btnAddUser = new JButton("Añadir Usuario");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoUsuarioDialog.createAndShowDialog(currentUser.getID());
			}
		});
		
		JButton btnChangeData = new JButton("Modificar Datos");
		btnChangeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarDatosDialog.createAndShowDialog(currentUser.getEmail());
			}
		});
		
		JButton btnRestaurarBackup = new JButton("Restaurar");
		btnRestaurarBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showSaveDialog(null);
				File backup = chooser.getSelectedFile();
				Database.restore(backup.getAbsolutePath());
			}
		});
		GridBagConstraints gbc_btnRestaurarBackup = new GridBagConstraints();
		gbc_btnRestaurarBackup.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRestaurarBackup.insets = new Insets(0, 0, 5, 5);
		gbc_btnRestaurarBackup.gridx = 1;
		gbc_btnRestaurarBackup.gridy = 9;
		getContentPane().add(btnRestaurarBackup, gbc_btnRestaurarBackup);
		GridBagConstraints gbc_btnChangeData = new GridBagConstraints();
		gbc_btnChangeData.anchor = GridBagConstraints.NORTH;
		gbc_btnChangeData.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChangeData.insets = new Insets(0, 0, 5, 5);
		gbc_btnChangeData.gridx = 3;
		gbc_btnChangeData.gridy = 9;
		getContentPane().add(btnChangeData, gbc_btnChangeData);
		GridBagConstraints gbc_btnAddUser = new GridBagConstraints();
		gbc_btnAddUser.anchor = GridBagConstraints.NORTH;
		gbc_btnAddUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddUser.gridx = 4;
		gbc_btnAddUser.gridy = 9;
		getContentPane().add(btnAddUser, gbc_btnAddUser);
		
		JButton btnBackup = new JButton("Realizar Backup");
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showSaveDialog(null);
				File backup = chooser.getSelectedFile();
				Database.backup(backup.getAbsolutePath());
			}
		});
		GridBagConstraints gbc_btnBackup = new GridBagConstraints();
		gbc_btnBackup.anchor = GridBagConstraints.NORTH;
		gbc_btnBackup.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBackup.insets = new Insets(0, 0, 0, 5);
		gbc_btnBackup.gridx = 1;
		gbc_btnBackup.gridy = 10;
		getContentPane().add(btnBackup, gbc_btnBackup);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntmAyuda = new JMenu("Ayuda");
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSalir.add(mntmSalir);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(mntmAyuda);
		
		JMenuItem mntmManualUsuario = new JMenuItem("Ayuda de Usuario");
		mntmManualUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URL url = ClassLoader.getSystemResource("GestionCuentasHelp.html");
				new HelpWindow("Ayuda", url);
			}
		});
		mntmAyuda.add(mntmManualUsuario);
		
		JMenuItem mntmInformacinVersion = new JMenuItem("Información Version");
		mntmInformacinVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mntmInformacinVersion,
						"Sistema de Informacion para Dieta en Casa " + "\nVersion alpha 0.1\n" + "\nContacto"
								+ "\n Jose Angel Tejedor - jtejea00@estudiante.unileon.es"
								+ "\n Javier de Lama - jlamab00@estudiante.unileon.es",
						"Información del Sistema", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mntmAyuda.add(mntmInformacinVersion);
	}
}
