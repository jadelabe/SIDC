package gui.tabs;

import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import database.classes.Profesional_Sanitario;

import java.awt.GridBagLayout;

public class GestionConsultaTab extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 * @param currentUser 
	 */
	public GestionConsultaTab(Profesional_Sanitario currentUser) {
		setFrameIcon(null);
		setBounds(100, 100, 626, 483);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntmAyuda = new JMenu("Ayuda");
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(mntmAyuda);
		
	}

}
