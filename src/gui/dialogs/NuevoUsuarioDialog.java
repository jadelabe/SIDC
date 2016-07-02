package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import database.classes.Paciente;
import database.classes.Profesional_Sanitario;
import database.operations.InsertData;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Date;
//import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class NuevoUsuarioDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNuevonombre;
	private JTextField txtNuevoApellido;
	private JTextField txtNuevadirec;
	private JTextField txtNuevotelf;
	private JTextField textField;
	private JTextField txtPassword;
	private JTextField txtConfirmaPass;
	private JDateChooser dateChoser;

	/*public static void main(String[] args) {
		try {
			NuevoUsuarioDialog dialog = new NuevoUsuarioDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public NuevoUsuarioDialog() {
		setSize(463, 528);
		setLocationRelativeTo(null);
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

		JLabel lblCorreoElectronico = new JLabel("Correo Electronico");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("Contraseña");

		txtPassword = new JTextField();
		txtPassword.setColumns(10);

		JLabel lblRepiteContrasea = new JLabel("Repite Contraseña");

		txtConfirmaPass = new JTextField();
		txtConfirmaPass.setColumns(10);

		dateChoser = new JDateChooser();
		dateChoser.setVisible(true);

		JLabel lblFecha = new JLabel("Fecha Nacimiento");

		ButtonGroup rol = new ButtonGroup();
		JRadioButton rdbtnProfesional = new JRadioButton("Profesional");
		JRadioButton rdbtnPaciente = new JRadioButton("Paciente");

		rol.add(rdbtnPaciente);
		rol.add(rdbtnProfesional);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtNuevotelf, Alignment.LEADING)
										.addComponent(txtNuevadirec, Alignment.LEADING)
										.addComponent(lblApellidos, Alignment.LEADING)
										.addComponent(lblNombre, Alignment.LEADING)
										.addComponent(txtNuevonombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 254,
												Short.MAX_VALUE)
										.addComponent(txtNuevoApellido, Alignment.LEADING)
										.addComponent(lblCorreoElectronico, Alignment.LEADING)
										.addComponent(textField, Alignment.LEADING)
										.addComponent(lblContrasea, Alignment.LEADING)
										.addComponent(txtConfirmaPass, Alignment.LEADING)
										.addComponent(txtPassword, Alignment.LEADING)
										.addComponent(lblRepiteContrasea, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
												230, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccin, Alignment.LEADING)
								.addComponent(lblTelefono, Alignment.LEADING)).addComponent(lblFecha)
						.addComponent(dateChoser, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnProfesional)
								.addComponent(rdbtnPaciente))
						.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblNombre)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNuevonombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnProfesional))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblApellidos)
						.addComponent(rdbtnPaciente))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtNuevoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblCorreoElectronico).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblContrasea).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblRepiteContrasea).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtConfirmaPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblDireccin).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtNuevadirec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblTelefono).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtNuevotelf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblFecha).addPreferredGap(ComponentPlacement.RELATED).addComponent(dateChoser,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(25, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if (txtPassword.getText().equals(txtConfirmaPass.getText())) {
								if (rdbtnPaciente.isSelected()) {
								//	Timestamp bday = new Timestamp(dateChoser.getDate().getTime());
									Paciente p = new Paciente(txtNuevonombre.getText(), txtNuevoApellido.getText(),
											textField.getText(), txtNuevadirec.getText(),
											new Date(dateChoser.getDate().getTime()), 0,
											Integer.parseInt(txtNuevotelf.getText()));

									InsertData.writePaciente(p, 0);

								} else if (rdbtnProfesional.isSelected()) {
									Profesional_Sanitario ps = new Profesional_Sanitario(txtNuevadirec.getText(),
											txtNuevonombre.getText(), txtNuevoApellido.getText(),
											txtNuevadirec.getText(), Integer.parseInt(txtNuevotelf.getText()));
									InsertData.writeProfesionalSanitario(ps);
								}
								else{
									//no se selecciono tipo de usuario
								}

								setVisible(false);
							} else {
								// contrase�as no coinciden
							}

						} catch (Exception e) {
							System.out.println(e);
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

	public static void createAndShowDialog() {
		NuevoUsuarioDialog dialog = new NuevoUsuarioDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
