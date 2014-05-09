import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class FichaPolicia extends JFrame {

	// Elementos de la pantalla
	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Edad;
	private JTextField Altura;
	private JTextField Crimen;
	

	// ComboBox para guardar delincuentes
	private JComboBox<Delincuente> delincuentes;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaPolicia frame = new FichaPolicia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FichaPolicia() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		delincuentes = new JComboBox<Delincuente>();
		delincuentes.setBounds(10, 49, 414, 20);
		contentPane.add(delincuentes);

		JLabel lblNombreDelicuente = new JLabel("Ficha");
		lblNombreDelicuente.setBounds(10, 25, 308, 14);
		contentPane.add(lblNombreDelicuente);

		JLabel lblApellidosNombre = new JLabel("Apellidos, Nombre");
		lblApellidosNombre.setBounds(10, 80, 158, 14);
		contentPane.add(lblApellidosNombre);

		Nombre = new JTextField();
		Nombre.setBounds(10, 105, 414, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 136, 88, 14);
		contentPane.add(lblEdad);

		Edad = new JTextField();
		Edad.setColumns(10);
		Edad.setBounds(10, 161, 88, 20);
		contentPane.add(Edad);

		JLabel lblAltura = new JLabel("Altura (cm)");
		lblAltura.setBounds(10, 197, 88, 14);
		contentPane.add(lblAltura);

		Altura = new JTextField();
		Altura.setColumns(10);
		Altura.setBounds(10, 222, 88, 20);
		contentPane.add(Altura);

		JLabel lblCrimen = new JLabel("Crimen");
		lblCrimen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrimen.setBounds(336, 136, 88, 14);
		contentPane.add(lblCrimen);

		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqu� realizaremos los siguientes pasos
				// 1.- Comprobaremos que todos los campos est�n completados
				if ((Nombre.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "El campo Apellidos, Nombre est� vac�o");
				}
				else if((Edad.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "El campo Edad est� vac�o");
				}
				else if((Altura.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "El campo Altura est� vac�o");	
				}
				else if((Crimen.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "El campo Crimen est� vac�o");	
				}
				else{
				// 2.- Crearemos un nuevo objeto delincuente
				
				Delincuente k=new Delincuente(delincuentes);
				
				k.setNombre(String.valueOf(Nombre.getText()));
				k.setEdad(Integer.valueOf(Edad.getText()));
				k.setAltura(Integer.valueOf(Altura.getText()));
				k.setCrimen(String.valueOf(Crimen.getText()));
				
				
				// 3.- Lo almacenaremos en el ComboBox
				delincuentes.addItem(k);
				}
			}
		});
		botonGuardar.setBounds(10, 272, 89, 23);
		contentPane.add(botonGuardar);

		Crimen = new JTextField();
		Crimen.setBounds(148, 161, 276, 20);
		contentPane.add(Crimen);
		Crimen.setColumns(10);
	}
}