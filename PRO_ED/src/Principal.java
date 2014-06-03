import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;



//ESTA ES LA VENTANA PRINCIPAL (MAIN) DESDE LA QUE LANZAREMOS LA APLICACION.
public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Hin;
	private JTextField Hout;
	private JTextField Total;
	private JComboBox<Registro> socios;
	private int in;
	private int out;
	private int resultado;
	private int sumatorio;
	private String Resultado;
	private String textIn;
	private String textOut;
	private Registro r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Reserva pista de padel");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setBounds(10, 11, 422, 14);
		contentPane.add(lblSocio);
		
		socios = new JComboBox<Registro>();
		socios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				r=(Registro) socios.getItemAt(socios.getSelectedIndex());
				Nombre.setText(String.valueOf(r.getSocio()));
				Hin.setText(String.valueOf(r.getHoraIn()));
				Hout.setText(String.valueOf(r.getHoraOut()));	
				Total.setText(String.valueOf(r.getTotal()));
		}	
		});
		
		socios.setBounds(10, 26, 422, 20);
		contentPane.add(socios);
		
		JLabel lblNombreYApellidos = new JLabel("Nombre y Apellidos");
		lblNombreYApellidos.setBounds(10, 59, 422, 14);
		contentPane.add(lblNombreYApellidos);
		
		Nombre = new JTextField();
		Nombre.setBounds(10, 72, 422, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada");
		lblHoraDeEntrada.setBounds(10, 103, 110, 14);
		contentPane.add(lblHoraDeEntrada);
		
		Hin = new JTextField();
		Hin.setBounds(130, 100, 30, 20);
		contentPane.add(Hin);
		Hin.setColumns(2);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de salida");
		lblHoraDeSalida.setBounds(10, 128, 110, 14);
		contentPane.add(lblHoraDeSalida);
		
		Hout = new JTextField();
		Hout.setBounds(130, 125, 30, 20);
		contentPane.add(Hout);
		Hout.setColumns(2);
		
		JLabel lblTotalDeHoras = new JLabel("Total de horas");
		lblTotalDeHoras.setBounds(10, 153, 110, 14);
		contentPane.add(lblTotalDeHoras);
		
		Total = new JTextField();
		Total.setEditable(false);
		Total.setBounds(130, 150, 77, 20);
		contentPane.add(Total);
		Total.setColumns(10);
		
		JButton btnGuardar = new JButton("Nuevo socio");
		btnGuardar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				if ((Nombre.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "�Falta introducir nombre y apellidos!");
					}
				else if((Hin.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "�Falta introducir hora de entrada!");
					}
				else if((Hout.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "�Falta introducir hora de salida!");
					}
				else{
					Registro r = new Registro(socios);
					r.setSocio(String.valueOf(Nombre.getText()));
					r.setHoraIn(Integer.valueOf(Hin.getText()));
					r.setHoraOut(Integer.valueOf(Hout.getText()));
					//Calculo matem�tico:
					textIn=Hin.getText();
					in=Integer.parseInt(textIn);
					
					textOut=Hout.getText();
					out=Integer.parseInt(textOut);
					
					resultado= out-in;
					
					Resultado=String.valueOf(resultado);
					Total.setText(Resultado);
					
					//Almacena el calculo anterior				
					r.setTotal(String.valueOf(Total.getText()));
					socios.addItem(r);
				}	
			}
		});
		btnGuardar.setBounds(22, 207, 112, 23);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("Registrar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((Nombre.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "�Falta introducir nombre y apellidos!");
					}
				else if((Hin.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "�Falta introducir hora de entrada!");
					}
				else if((Hout.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "�Falta introducir hora de salida!");
					}
				else{
					
					r.setSocio(String.valueOf(Nombre.getText()));
					r.setHoraIn(Integer.valueOf(Hin.getText()));
					r.setHoraOut(Integer.valueOf(Hout.getText()));
				}		
			//Hacer que el resto de la modificacion se sume al resultado anterior.
				try{
					textIn=Hin.getText();
					in=Integer.parseInt(textIn);
					
					textOut=Hout.getText();
					out=Integer.parseInt(textOut);
					
					resultado= out-in;
					
					Resultado=String.valueOf(resultado);
					Total.setText(Resultado);
					}
				catch(NumberFormatException exception)
				{
				JOptionPane.showMessageDialog(null, "�ERROR!");
				}
			}
		});
		btnModificar.setBounds(162, 203, 112, 31);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Borrar socio");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ventana para confirmar eliminar:
				if (JOptionPane.showConfirmDialog(new JFrame(), 
						"�Est�s seguro?", "BORRAR SOCIO", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
					
			socios.removeItem(r=socios.getItemAt(socios.getSelectedIndex()));
		}
		});
		btnEliminar.setBounds(304, 207, 112, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblH = new JLabel(":00 H");
		lblH.setBounds(162, 103, 46, 14);
		contentPane.add(lblH);
		
		JLabel lblH_1 = new JLabel(":00 H");
		lblH_1.setBounds(162, 128, 46, 14);
		contentPane.add(lblH_1);
	}
}
