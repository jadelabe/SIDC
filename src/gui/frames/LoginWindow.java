package gui.frames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.Database;

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
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String user = txtUsuario.getText();
					String pass = new String(passwordField.getPassword());
					String hash = "";
					ArrayList<String[]> info;
					try {
						info = Database.gatherInfo("SELECT * FROM Login");

						for (String[] i : info) {
							if (i[0].equals(user)) {
								hash = i[1];
								if (security.Encryption.checkPassword(hash, pass)) {
									System.out.println(hash);
									System.out.println(pass);
									if (i[2] != null) {
										// Profesional Sanitario
										setVisible(false);
										new ProfessionalMainWindow(Integer.parseInt(i[2]));
									} else {
										// Paciente
										setVisible(false);
										new PacienteMainWindow(Integer.parseInt(i[2]));
									}
								} else {
									JOptionPane.showMessageDialog(passwordField, "Usuario o contraseña incorrectos",
											"Error al Iniciar Sesión", JOptionPane.ERROR_MESSAGE);
								}
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = txtUsuario.getText();
				String pass = new String(passwordField.getPassword());
				String hash = "";
				ArrayList<String[]> info;
				try {
					info = Database.gatherInfo("SELECT * FROM Login");

					for (String[] i : info) {
						if (i[0].equals(user)) {
							hash = i[1];
							if (security.Encryption.checkPassword(hash, pass)) {
								System.out.println(hash);
								System.out.println(pass);
								if (i[2] != null) {
									// Profesional Sanitario
									setVisible(false);
									new ProfessionalMainWindow(Integer.parseInt(i[2]));
								} else {
									// Paciente
									setVisible(false);
									new PacienteMainWindow(Integer.parseInt(i[2]));
								}
							} else {
								JOptionPane.showMessageDialog(btnAceptar, "Usuario o contraseña incorrectos",
										"Error al Iniciar Sesión", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
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
