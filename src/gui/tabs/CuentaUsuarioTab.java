package gui.tabs;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import database.classes.Paciente;
import gui.dialogs.ModificarDatosDialog;
import gui.dialogs.ModificarPassDialog;
import gui.dialogs.ModificarUsuarioDialog;
import gui.frames.HelpWindow;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CuentaUsuarioTab extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Paciente currentUser;
	
	/**
	 * Create the frame.
	 * @param currentUser 
	 */
	/*public CuentaUsuarioTab(Profesional_Sanitario user) {
		Profesional_Sanitario currentUser = user;
		inicialice(currentUser);
	}*/
	public CuentaUsuarioTab(Paciente user) {
		currentUser = user;
		inicialice();
	}

	private void inicialice() {
		// TODO Auto-generated method stub
		setFrameIcon(null);
		setSize(700, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{31, 136, 89, 179, 0};
		gridBagLayout.rowHeights = new int[]{30, 15, 15, 15, 15, 25, 17, 15, 15, 15, 15, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Nombre:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		getContentPane().add(lblName, gbc_lblName);
		
		JButton btnChangeData = new JButton("Modificar Datos");
		btnChangeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatosDialog.createAndShowDialog(currentUser.getEmail());
				actualizarInfoPaciente();
			}

			private void actualizarInfoPaciente() {
				// TODO Auto-generated method stub
				
			}
		});
		GridBagConstraints gbc_btnChangeData = new GridBagConstraints();
		gbc_btnChangeData.anchor = GridBagConstraints.NORTH;
		gbc_btnChangeData.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChangeData.insets = new Insets(0, 0, 5, 0);
		gbc_btnChangeData.gridheight = 2;
		gbc_btnChangeData.gridx = 3;
		gbc_btnChangeData.gridy = 1;
		getContentPane().add(btnChangeData, gbc_btnChangeData);
		
		
		JLabel lblShowName = new JLabel(currentUser.getNombre());
		GridBagConstraints gbc_lblShowName = new GridBagConstraints();
		gbc_lblShowName.anchor = GridBagConstraints.NORTH;
		gbc_lblShowName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowName.gridx = 1;
		gbc_lblShowName.gridy = 2;
		getContentPane().add(lblShowName, gbc_lblShowName);
		
		JLabel lblLastName = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 3;
		getContentPane().add(lblLastName, gbc_lblLastName);
		
		JLabel lblHhowLastName = new JLabel(currentUser.getApellidos());
		GridBagConstraints gbc_lblHhowLastName = new GridBagConstraints();
		gbc_lblHhowLastName.anchor = GridBagConstraints.NORTH;
		gbc_lblHhowLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblHhowLastName.gridx = 1;
		gbc_lblHhowLastName.gridy = 4;
		getContentPane().add(lblHhowLastName, gbc_lblHhowLastName);
		
		JLabel lblEmail = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		JLabel lblMail = new JLabel(currentUser.getEmail());
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.SOUTH;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 6;
		getContentPane().add(lblMail, gbc_lblMail);
		
		JButton btnChangeUser = new JButton("Cambiar Usuario");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarUsuarioDialog.createAndShowDialog();
			}
		});
		GridBagConstraints gbc_btnChangeUser = new GridBagConstraints();
		gbc_btnChangeUser.anchor = GridBagConstraints.NORTH;
		gbc_btnChangeUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChangeUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnChangeUser.gridx = 3;
		gbc_btnChangeUser.gridy = 5;
		getContentPane().add(btnChangeUser, gbc_btnChangeUser);
		
		JButton btnChangePassword = new JButton("Cambiar Contraseña");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarPassDialog.createAndShowDialog(currentUser.getEmail());
			}
		});
		GridBagConstraints gbc_btnChangePassword = new GridBagConstraints();
		gbc_btnChangePassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnChangePassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnChangePassword.gridheight = 2;
		gbc_btnChangePassword.gridx = 3;
		gbc_btnChangePassword.gridy = 6;
		getContentPane().add(btnChangePassword, gbc_btnChangePassword);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 7;
		getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		JLabel lblPhone = new JLabel(Integer.toUnsignedString(currentUser.getTelefono()));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.NORTH;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 8;
		getContentPane().add(lblPhone, gbc_lblPhone);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 9;
		getContentPane().add(lblDireccion, gbc_lblDireccion);
		
		JLabel lblAddress = new JLabel(currentUser.getDireccion());
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.NORTH;
		gbc_lblAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 10;
		getContentPane().add(lblAddress, gbc_lblAddress);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntmAyuda = new JMenu("Ayuda");
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		/*JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginWindow login = new LoginWindow();
				login.setVisible(true);
				
			}
		});
		mnSalir.add(mntmCerrarSesion);*/
		
		JSeparator separator = new JSeparator();
		mnSalir.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(mntmSalir, "Cerrando aplicacion.¿Esta seguro?", "Salir",
						JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
		mnSalir.add(mntmSalir);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(mntmAyuda);
		
		JMenuItem mntmManualUsuario = new JMenuItem("Ayuda de Usuario");
		mntmManualUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URL url = ClassLoader.getSystemResource("CuentaPacienteHelp.html");
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
