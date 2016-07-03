package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarDatosDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTextField txtNuevonombre;
	private static JTextField txtNuevoApellido;
	private static JTextField txtNuevadirec;
	private static JTextField txtNuevotelf;

	/**
	 * Create the dialog.
	 */
	public ModificarDatosDialog(String user) {
		setSize(439, 259);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtNuevoApellido = new JTextField();
			txtNuevoApellido.setColumns(10);
		}
		{
			txtNuevonombre = new JTextField();
			txtNuevonombre.setColumns(10);
		}

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellidos = new JLabel("Apellidos");
		JLabel lblDireccin = new JLabel("Dirección");

		txtNuevadirec = new JTextField();
		txtNuevadirec.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");

		txtNuevotelf = new JTextField();
		txtNuevotelf.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblApellidos).addComponent(lblNombre)
												.addComponent(lblDireccin).addComponent(lblTelefono)
												.addComponent(txtNuevonombre, GroupLayout.DEFAULT_SIZE, 254,
														Short.MAX_VALUE)
												.addComponent(txtNuevoApellido).addComponent(txtNuevadirec)
												.addComponent(txtNuevotelf))
										.addContainerGap(155, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblNombre)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNuevonombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApellidos)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNuevoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDireccin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNuevadirec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTelefono)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNuevotelf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
						String[] data = getModificaciones();
						try {
							System.out.println(user);
							Database.updateInfo("UPDATE paciente SET nombre='" + data[0] + "' WHERE email LIKE '%" + user + "%'");
							Database.updateInfo("UPDATE paciente SET apellidos='" + data[1] + "' WHERE email LIKE '%" + user + "%'");
							Database.updateInfo("UPDATE paciente SET direccion='" + data[2] + "' WHERE email LIKE '%" + user + "%'");
							Database.updateInfo("UPDATE paciente SET telefono='" + data[3] + "' WHERE email LIKE '%" + user + "%'");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
	public static String[] getModificaciones() {
		String newData[] = new String[4];
		newData[0] = txtNuevonombre.getText();
		newData[1] = txtNuevoApellido.getText();
		newData[2] = txtNuevadirec.getText();
		newData[3] = txtNuevotelf.getText();
	
		return newData;
		
	}
	public static void createAndShowDialog(String user) {
		ModificarDatosDialog dialog = new ModificarDatosDialog(user);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
