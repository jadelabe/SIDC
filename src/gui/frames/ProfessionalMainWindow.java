package gui.frames;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import database.classes.Profesional_Sanitario;
import database.operations.SearchData;
import gui.tabs.*;

import java.awt.CardLayout;

public class ProfessionalMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userID;
	private Profesional_Sanitario currentUser;

	/**
	 * Create the application.
	 * 
	 * @param id
	 */
	public ProfessionalMainWindow(int id) {
		userID = id;
		ArrayList<String[]> userInfo = SearchData.search("Profesional_Sanitario", "ID", Integer.toString(userID));
		currentUser = new Profesional_Sanitario(userInfo);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("SI Dieta en Casa");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_54613918936339");
/*
		CuentaUsuarioTab tabCuenta = new CuentaUsuarioTab<Profesional_Sanitario>(currentUser);
		tabbedPane.addTab("Mi Cuenta", null, tabCuenta, null);
		tabCuenta.setVisible(true);*/

		GestionCuentasTab tabCuentas = new GestionCuentasTab(currentUser);
		tabbedPane.add("Gestion de Usuarios", tabCuentas);
		tabCuentas.setVisible(true);

		GestionHistorialesTab tabHistoriales = new GestionHistorialesTab(currentUser);
		tabbedPane.add("Historiales", tabHistoriales);
		tabHistoriales.setVisible(true);

		GestionConsultaTab tabConsulta = new GestionConsultaTab(currentUser);
		tabbedPane.add("Consulta", tabConsulta);
		tabConsulta.setVisible(true);
		setVisible(true);
	}
}
