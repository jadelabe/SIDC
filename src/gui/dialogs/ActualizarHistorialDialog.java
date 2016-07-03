package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.classes.Antropometricas;
import database.classes.Historial;
import database.operations.InsertData;
import database.operations.SearchData;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarHistorialDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmail;
	private JTextField txtTalla;
	private JTextField txtPeso;
	private JTextField txtCintura;
	private JTextField txtCadera;
	private JTextField txtPecho;
	private JTextField txtPlieEscapular;
	private JTextField txtPlieBicipital;
	private JTextField txtPlieTricipital;
	private JTextField txtPliAbdominal;
	private JTextField txtIMC;
	private JTextField txtIGC;
	private JTextField txtTMB;
	/**
	 * Create the dialog.
	 */
	public ActualizarHistorialDialog() {
		setBounds(100, 100, 387, 287);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Email");
			lblNewLabel.setBounds(111, 14, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setBounds(162, 11, 86, 20);
			contentPanel.add(txtEmail);
			txtEmail.setColumns(10);
		}
		
		JLabel label = new JLabel("Talla");
		label.setBounds(10, 42, 46, 14);
		contentPanel.add(label);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(61, 39, 86, 20);
		contentPanel.add(txtTalla);
		
		JLabel label_1 = new JLabel("Peso");
		label_1.setBounds(10, 70, 46, 14);
		contentPanel.add(label_1);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(61, 67, 86, 20);
		contentPanel.add(txtPeso);
		
		JLabel label_2 = new JLabel("Cintura");
		label_2.setBounds(10, 100, 46, 14);
		contentPanel.add(label_2);
		
		txtCintura = new JTextField();
		txtCintura.setColumns(10);
		txtCintura.setBounds(61, 97, 86, 20);
		contentPanel.add(txtCintura);
		
		JLabel label_3 = new JLabel("Cadera");
		label_3.setBounds(10, 128, 46, 14);
		contentPanel.add(label_3);
		
		txtCadera = new JTextField();
		txtCadera.setColumns(10);
		txtCadera.setBounds(61, 125, 86, 20);
		contentPanel.add(txtCadera);
		
		JLabel label_4 = new JLabel("Pecho");
		label_4.setBounds(10, 156, 46, 14);
		contentPanel.add(label_4);
		
		txtPecho = new JTextField();
		txtPecho.setColumns(10);
		txtPecho.setBounds(61, 153, 86, 20);
		contentPanel.add(txtPecho);
		
		JLabel label_5 = new JLabel("Pliegue Escapular");
		label_5.setBounds(157, 92, 113, 14);
		contentPanel.add(label_5);
		
		txtPlieEscapular = new JTextField();
		txtPlieEscapular.setColumns(10);
		txtPlieEscapular.setBounds(280, 97, 86, 20);
		contentPanel.add(txtPlieEscapular);
		
		JLabel label_6 = new JLabel("Pliegue Bicipital");
		label_6.setBounds(157, 120, 113, 14);
		contentPanel.add(label_6);
		
		txtPlieBicipital = new JTextField();
		txtPlieBicipital.setColumns(10);
		txtPlieBicipital.setBounds(280, 125, 86, 20);
		contentPanel.add(txtPlieBicipital);
		
		JLabel label_7 = new JLabel("Pliegue Tricipital");
		label_7.setBounds(157, 67, 113, 14);
		contentPanel.add(label_7);
		
		txtPlieTricipital = new JTextField();
		txtPlieTricipital.setColumns(10);
		txtPlieTricipital.setBounds(280, 67, 86, 20);
		contentPanel.add(txtPlieTricipital);
		
		txtPliAbdominal = new JTextField();
		txtPliAbdominal.setColumns(10);
		txtPliAbdominal.setBounds(280, 39, 86, 20);
		contentPanel.add(txtPliAbdominal);
		
		JLabel label_8 = new JLabel("Pliegue Abdominal");
		label_8.setBounds(157, 42, 113, 14);
		contentPanel.add(label_8);
		
		txtIMC = new JTextField();
		txtIMC.setColumns(10);
		txtIMC.setBounds(208, 156, 86, 20);
		contentPanel.add(txtIMC);
		
		JLabel label_9 = new JLabel("IMC");
		label_9.setBounds(157, 159, 46, 14);
		contentPanel.add(label_9);
		
		txtIGC = new JTextField();
		txtIGC.setColumns(10);
		txtIGC.setBounds(61, 181, 86, 20);
		contentPanel.add(txtIGC);
		
		JLabel label_10 = new JLabel("IGC");
		label_10.setBounds(10, 184, 46, 14);
		contentPanel.add(label_10);
		
		txtTMB = new JTextField();
		txtTMB.setColumns(10);
		txtTMB.setBounds(208, 181, 86, 20);
		contentPanel.add(txtTMB);
		
		JLabel label_11 = new JLabel("TMB");
		label_11.setBounds(157, 184, 46, 14);
		contentPanel.add(label_11);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						ArrayList<String[]> info = SearchData.search("paciente", "email", txtEmail.getText());
						int id = Integer.parseInt(info.get(0)[0]);
						Antropometricas a = new Antropometricas(null, Float.parseFloat(txtTalla.getText()), Float.parseFloat(txtPeso.getText()),  Float.parseFloat(txtCintura.getText())
								,  Float.parseFloat(txtCadera.getText()),  Float.parseFloat(txtPecho.getText()),  Float.parseFloat(txtPlieEscapular.getText()),  Float.parseFloat(txtPlieBicipital.getText())
								,  Float.parseFloat(txtPlieTricipital.getText()),  Float.parseFloat(txtPliAbdominal.getText()),  Float.parseFloat(txtIMC.getText()),  Float.parseFloat(txtIGC.getText())
								,  Float.parseFloat(txtTMB.getText()), id);
						
						try {
							InsertData.writeAntropometricas(a);
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
							Date fecha = new Date(formatter.parse(SearchData.search("antropometricas", "Paciente_ID",  Integer.toString(id)).get(0)[0]).getTime());
							Historial h  = new Historial(info.get(0)[1], info.get(0)[2], id, fecha);
							InsertData.writeHistorial(h);
						} catch (Exception e) {
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

	public static void createAndShowDialog() {
		ActualizarHistorialDialog dialog = new ActualizarHistorialDialog();
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setVisible(true);
	}
}
