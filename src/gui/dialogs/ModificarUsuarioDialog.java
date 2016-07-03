package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import database.Database;

public class ModificarUsuarioDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCurrentUser;
	private JTextField txtNewUser;
	private JTextField txConfirmUser;
	/**
	 * Create the dialog.
	 */
	public ModificarUsuarioDialog() {
		setSize( 439, 259);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtNewUser = new JTextField();
			txtNewUser.setColumns(10);
		}
		{
			txtCurrentUser = new JTextField();
			txtCurrentUser.setColumns(10);
		}

		JLabel lblCurrentUser = new JLabel("Email Actual");

		JLabel lblApellidos = new JLabel("Nuevo Email");
		JLabel lblNewUser2 = new JLabel("Repita nuevo Email");

		txConfirmUser = new JTextField();
		txConfirmUser.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblApellidos)
						.addComponent(lblCurrentUser)
						.addComponent(lblNewUser2)
						.addComponent(txtCurrentUser, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
						.addComponent(txtNewUser)
						.addComponent(txConfirmUser))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblCurrentUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCurrentUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblApellidos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNewUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewUser2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txConfirmUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						try {
							Database.updateInfo("update login set email = replace(email, '"+ txtCurrentUser.getText() +
									"', '" + txtNewUser.getText() + "')");
							Database.updateInfo("update paciente set email = replace(email, '"+ txtCurrentUser.getText() +
									"', '" + txtNewUser.getText() + "')");
						} catch (Exception e) {
							e.printStackTrace();
						}
						dispose();
						
					}
				});
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
		ModificarUsuarioDialog dialog = new ModificarUsuarioDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

}
