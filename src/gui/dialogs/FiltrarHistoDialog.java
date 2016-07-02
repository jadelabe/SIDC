package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FiltrarHistoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTextField txtNamePacient;
	private static JTextField txtLastNamePacient;

	/**
	 * Create the dialog.
	 */
	public FiltrarHistoDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Nombre");
		
		txtNamePacient = new JTextField();
		txtNamePacient.setColumns(10);
		
		txtLastNamePacient = new JTextField();
		txtLastNamePacient.setColumns(10);
		
		JLabel label_1 = new JLabel("Apellidos");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamePacient, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLastNamePacient, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGap(1)
					.addComponent(label)
					.addGap(7)
					.addComponent(txtNamePacient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(label_1)
					.addGap(8)
					.addComponent(txtLastNamePacient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public String[] createAndShowDialog(String[] filtro) {
		FiltrarHistoDialog dialog = new FiltrarHistoDialog();
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setVisible(true);
	    
	    filtro[0] = getNameField();
	    filtro[1] = getLastNameField();
	    
		return filtro;
		
	}
	public static String getNameField() {
		
		return txtNamePacient.getText();
	}
	
	public static String getLastNameField() {
		
		return txtLastNamePacient.getText();
	}

}
