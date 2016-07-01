package gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.operations.Login;

import javax.swing.JPasswordField;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the
	 */
	private void initialize() {
		setTitle("SI Dieta en Casa");
		setSize(400, 275);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		txtUsuario = new JTextField();
		txtUsuario.setText(null);
		txtUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblContrasea = new JLabel("Contraseña:");

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if( arg0.getKeyCode() == KeyEvent.VK_ENTER){
					String user = txtUsuario.getText();
					String pass = new String(passwordField.getPassword());

					int id[] = null;
					try {
						id = Login.checkLogin(user, pass);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (id[1] == 1) { // Profesional
						setVisible(false);
						new ProfessionalMainWindow(id[0]);
					} else if (id[1] == 2) {
						setVisible(false);
						new PacienteMainWindow(id[0]);
					} else {
						JOptionPane.showMessageDialog(passwordField, "Usuario o contraseña incorrectos",
								"Error al Iniciar Sesión", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = txtUsuario.getText();
				String pass = new String(passwordField.getPassword());

				int id[] = null;
				try {
					id = Login.checkLogin(user, pass);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (id[1] == 1) { // Profesional
					setVisible(false);
					new ProfessionalMainWindow(id[0]);
				} else if (id[1] == 2) {
					setVisible(false);
					new PacienteMainWindow(id[0]);
				} else {
					JOptionPane.showMessageDialog(btnAceptar, "Usuario o contraseña incorrectos",
							"Error al Iniciar Sesión", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(btnCancelar, "Cerrando aplicacion.¿Esta seguro?", "Salir",
						JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
					System.exit(0);

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(140).addComponent(lblUsuario,
						GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(140).addComponent(txtUsuario,
						GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(140).addComponent(lblContrasea,
						GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(140).addComponent(passwordField,
						GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(90)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(lblUsuario).addGap(5)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(11).addComponent(lblContrasea).addGap(5)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(11).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnAceptar)
								.addComponent(btnCancelar))));
		getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mntmAyuda = new JMenu("Ayuda");
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(mntmAyuda);

		JMenuItem mntmManualUsuario = new JMenuItem("Ayuda de Usuario");
		mntmManualUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URL url = ClassLoader.getSystemResource("LoginHelp.html");
				// URL loginHelp =
				// ClassLoader.getSystemResource("LoginHelp.html");
				/*
				 * if (Desktop.isDesktopSupported()) { URI uri = null; try { uri
				 * = loginHelp.toURI(); } catch (URISyntaxException e1) { //
				 * TODO Auto-generated catch block e1.printStackTrace(); } try {
				 * Desktop.getDesktop().browse(uri); } catch (IOException e1) {
				 * // TODO Auto-generated catch block e1.printStackTrace(); } }
				 */
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
