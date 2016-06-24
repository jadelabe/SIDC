package gui.tabs;

import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JTable;

import database.classes.Profesional_Sanitario;
import gui.dialogs.ActualizarHistorialDialog;
import gui.dialogs.FiltrarHistoDialog;
import gui.frames.HelpWindow;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionHistorialesTab extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the frame.
	 * @param currentUser 
	 */
	public GestionHistorialesTab(Profesional_Sanitario currentUser) {
		setFrameIcon(null);
		setSize(700, 550);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{117, 180, 145, 165, 0};
		gridBagLayout.rowHeights = new int[]{396, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
				
						table = new JTable();
						GridBagConstraints gbc_table = new GridBagConstraints();
						gbc_table.fill = GridBagConstraints.BOTH;
						gbc_table.insets = new Insets(0, 0, 5, 0);
						gbc_table.gridwidth = 4;
						gbc_table.gridx = 0;
						gbc_table.gridy = 0;
						getContentPane().add(table, gbc_table);
		
				JButton btnFiltrar = new JButton("Filtrar");
				btnFiltrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FiltrarHistoDialog.createAndShowDialog();
					}
				});
				GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
				gbc_btnFiltrar.anchor = GridBagConstraints.NORTH;
				gbc_btnFiltrar.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnFiltrar.insets = new Insets(0, 0, 0, 5);
				gbc_btnFiltrar.gridx = 0;
				gbc_btnFiltrar.gridy = 1;
				getContentPane().add(btnFiltrar, gbc_btnFiltrar);
		
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
				getContentPane().add(btnActualizarHistorial, gbc_btnActualizarHistorial);
		
				JButton btnGenerarGrfica = new JButton("Generar Gráfica");
				GridBagConstraints gbc_btnGenerarGrfica = new GridBagConstraints();
				gbc_btnGenerarGrfica.anchor = GridBagConstraints.NORTH;
				gbc_btnGenerarGrfica.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnGenerarGrfica.gridx = 3;
				gbc_btnGenerarGrfica.gridy = 1;
				getContentPane().add(btnGenerarGrfica, gbc_btnGenerarGrfica);

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
				URL url = ClassLoader.getSystemResource("GestionHistorialesHelp.html");
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