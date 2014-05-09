import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JComboBox;


public class Delincuente {
	
	private String Nombre;
	private int Edad;
	private int Altura;
	private String Crimen;
	
	
	
	public Delincuente(JComboBox c) {
		Nombre="";
		Edad=0;
		Altura=0;
		Crimen="";
	}
	//Falta por crear
	//Los métodos de guardado y recuperación
	public void setNombre(String a){
		Nombre=a;
	}
	public void setEdad(int b){
		Edad=b;
	}
	public void setAltura(int c){
		Altura=c;
	}
	public void setCrimen(String d){
		Crimen=d;
	}
	
	public String getNombre(){
		return Nombre;
	}
	public int getEdad(){
		return Edad;
	}
	public int getAltura(){
		return Altura;
	}
	public String getCrimen(){
		return Crimen;
	}
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	public String toString(){
		return Nombre;
	}
}
