package gui.tabs;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTable;

import database.classes.Profesional_Sanitario;
import database.operations.SearchData;
import gui.dialogs.ActualizarHistorialDialog;
import gui.frames.HelpWindow;

import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionHistorialesTab extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the frame.
	 * 
	 * @param currentUser
	 */
	public GestionHistorialesTab(Profesional_Sanitario currentUser) {
		setFrameIcon(null);
		setSize(700, 550);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 117, 180, 145, 165, 0 };
		gridBagLayout.rowHeights = new int[] { 396, 25, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		DefaultTableModel tableModel = null;
		String col[] = { "Nombre", "Apellidos", "Fecha", "Talla", "Peso",
				"Cintura", "Cadera", "Pecho", "ESCAP", "BICEP", "TRICEP",
				"ABDOM", "IMC", "IGC" };
		tableModel = new DefaultTableModel(col, 0); // The 0 argument is number
													// rows.
		tableModel.addRow(col);

		JTable table = new JTable(tableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		getContentPane().add(table, gbc_table);
		ArrayList<String[]> historiales = SearchData.search("Historial");
		fillTable(historiales, tableModel);
		/*
		 * JButton btnFiltrar = new JButton("Filtrar");
		 * btnFiltrar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { FiltrarHistoDialog dialog = new
		 * FiltrarHistoDialog(); filtro = new String[2]; filtro =
		 * dialog.createAndShowDialog(filtro); } });
		 */

		/*
		 * GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		 * gbc_btnFiltrar.anchor = GridBagConstraints.NORTH; gbc_btnFiltrar.fill
		 * = GridBagConstraints.HORIZONTAL; gbc_btnFiltrar.insets = new
		 * Insets(0, 0, 0, 5); gbc_btnFiltrar.gridx = 0; gbc_btnFiltrar.gridy =
		 * 1; getContentPane().add(btnFiltrar, gbc_btnFiltrar);
		 */

		JButton btnActualizarHistorial = new JButton("Actualizar Historial");
		btnActualizarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarHistorialDialog.createAndShowDialog();
			}
		});
		GridBagConstraints gbc_btnActualizarHistorial = new GridBagConstraints();
		gbc_btnActualizarHistorial.anchor = GridBagConstraints.NORTH;
		gbc_btnActualizarHistorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnActualizarHistorial.insets = new Insets(0, 0, 0, 5);
		gbc_btnActualizarHistorial.gridx = 1;
		gbc_btnActualizarHistorial.gridy = 1;
		getContentPane()
				.add(btnActualizarHistorial, gbc_btnActualizarHistorial);
/*
		JButton btnGenerarGrfica = new JButton("Generar Gráfica");
		btnGenerarGrfica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnGenerarGrfica = new GridBagConstraints();
		gbc_btnGenerarGrfica.anchor = GridBagConstraints.NORTH;
		gbc_btnGenerarGrfica.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGenerarGrfica.gridx = 3;
		gbc_btnGenerarGrfica.gridy = 1;
		getContentPane().add(btnGenerarGrfica, gbc_btnGenerarGrfica);*/

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
				URL url = ClassLoader
						.getSystemResource("GestionHistorialesHelp.html");
				new HelpWindow("Ayuda", url);
			}
		});
		mntmAyuda.add(mntmManualUsuario);

		JMenuItem mntmInformacinVersion = new JMenuItem("Información Version");
		mntmInformacinVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								mntmInformacinVersion,
								"Sistema de Informacion para Dieta en Casa "
										+ "\nVersion alpha 0.1\n"
										+ "\nContacto"
										+ "\n Jose Angel Tejedor - jtejea00@estudiante.unileon.es"
										+ "\n Javier de Lama - jlamab00@estudiante.unileon.es",
								"Información del Sistema",
								JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mntmAyuda.add(mntmInformacinVersion);
	}

	private void fillTable(ArrayList<String[]> historiales,
			DefaultTableModel table) {
		// TODO Auto-generated method stub
		ArrayList<Integer> id = new ArrayList<Integer>();
		for (int i = 0; i < historiales.size(); i++) {
			
			if(!id.contains(Integer.parseInt(historiales.get(i)[2]))){
			id.add(Integer.parseInt(historiales.get(i)[2]));
			
			ArrayList<String[]> userAntrop = SearchData.search(
					"Antropometricas", "Paciente_ID", historiales.get(i)[2]);
			
			for (int j = 0; j < userAntrop.size(); j++) {
				String nombre = historiales.get(i)[0];
				String apellido = historiales.get(i)[1];
				String fecha = userAntrop.get(j)[0];
				String talla = userAntrop.get(j)[1];
				String peso = userAntrop.get(j)[2];
				String cintura = userAntrop.get(j)[3];
				String cadera = userAntrop.get(j)[4];
				String pecho = userAntrop.get(j)[5];
				String p_esc = userAntrop.get(j)[6];
				String p_bic = userAntrop.get(j)[7];
				String p_tri = userAntrop.get(j)[8];
				String p_abd = userAntrop.get(j)[9];
				String imc = userAntrop.get(j)[10];
				String igc = userAntrop.get(j)[11];
				
				Object[] data = {nombre, apellido, fecha, talla, peso, cintura, cadera, pecho, p_esc,
						p_bic, p_tri, p_abd, imc, igc};
				
				table.addRow(data);
			}
			}
		}
	}
}
