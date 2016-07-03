package gui.frames;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import database.classes.Paciente;
import database.operations.SearchData;
import gui.tabs.CitasPacienteTab;
import gui.tabs.CuentaUsuarioTab;
import gui.tabs.HistorialPacienteTab;

import java.awt.CardLayout;

public class PacienteMainWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userID;
	private Paciente currentUser;

	/**
	 * Create the application.
	 * @param id 
	 */
	public PacienteMainWindow(int id) {
		this.userID = id;
		ArrayList<String[]> userInfo = SearchData.search("Paciente", "ID", Integer.toString(userID));
		currentUser = new Paciente(userInfo);
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setTitle("SI Dieta en Casa");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_54504331417099");
		
		CuentaUsuarioTab tabCuenta = new CuentaUsuarioTab(currentUser);
		tabbedPane.addTab("Mi Cuenta", null, tabCuenta, null);
		tabCuenta.setVisible(true);
		
		HistorialPacienteTab tabHistorial = new HistorialPacienteTab(currentUser);
		tabbedPane.addTab("Mi Historial", null, tabHistorial, null);
		tabHistorial.setVisible(true);
		
		CitasPacienteTab tabCitas = new CitasPacienteTab();
		tabbedPane.addTab("Mis Citas", null, tabCitas, null);
		tabCitas.setVisible(true);
		
		setVisible(true);
	}

}
