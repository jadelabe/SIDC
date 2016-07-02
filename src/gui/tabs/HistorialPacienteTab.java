package gui.tabs;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import database.classes.Paciente;
import database.operations.SearchData;
import gui.frames.HelpWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class HistorialPacienteTab extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the frame.
	 * @param currentUser 
	 */
	public HistorialPacienteTab(Paciente currentUser) {
		setFrameIcon(null);
		setSize(800, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{624, 0};
		gridBagLayout.rowHeights = new int[]{366, 27, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		DefaultTableModel tableModel = null;   
		String col[] = {"Fecha","Talla","Peso", "Cintura", "Cadera", "Pecho"
				, "ESCAP", "BICEP", "TRICEP", "ABDOM", "IMC", "IGC"};
		tableModel = new DefaultTableModel(col, 0);   // The 0 argument is number rows.
		tableModel.addRow(col);
		
		JTable table = new JTable(tableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		getContentPane().add(table, gbc_table);
		
		ArrayList<String[]> userAntrop = SearchData.search("Antropometricas", "Paciente_ID", Integer.toString(currentUser.getID()));
		
		fillTable(userAntrop, tableModel);
			
		JButton btnCrearGrafica = new JButton("Generar Grafica");
		GridBagConstraints gbc_btnCrearGrafica = new GridBagConstraints();
		gbc_btnCrearGrafica.anchor = GridBagConstraints.EAST;
		gbc_btnCrearGrafica.fill = GridBagConstraints.VERTICAL;
		gbc_btnCrearGrafica.gridx = 0;
		gbc_btnCrearGrafica.gridy = 1;
		getContentPane().add(btnCrearGrafica, gbc_btnCrearGrafica);
		
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
				URL url = ClassLoader.getSystemResource("HistorialPacienteHelp.html");
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
	private void fillTable(ArrayList<String[]> userAntrop, DefaultTableModel table) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userAntrop.size(); i++) {
			String fecha = userAntrop.get(i)[0];
			String talla = userAntrop.get(i)[1];
			String peso = userAntrop.get(i)[2];
			String cintura = userAntrop.get(i)[3];
			String cadera = userAntrop.get(i)[4];
			String pecho = userAntrop.get(i)[5];
			String p_esc = userAntrop.get(i)[6];
			String p_bic = userAntrop.get(i)[7];
			String p_tri = userAntrop.get(i)[8];
			String p_abd = userAntrop.get(i)[9];
			String imc = userAntrop.get(i)[10];
			String igc = userAntrop.get(i)[11];
			
			Object[] data = {fecha, talla, peso, cintura, cadera, pecho, p_esc,
					p_bic, p_tri, p_abd, imc, igc};
			
			table.addRow(data);
			
		}
	}
	private void initTable(DefaultTableModel tableModel) {
		String col[] = {"Fecha","Talla","Peso", "Cintura", "Cadera", "Pecho"
				, "ESCAP", "BICEP", "TRICEP", "ABDOM", "IMC", "IGC"};
		tableModel = new DefaultTableModel(col, 0);   // The 0 argument is number rows.

		JTable table = new JTable(tableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		getContentPane().add(table, gbc_table);
	}
}
