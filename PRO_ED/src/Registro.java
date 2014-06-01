
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JComboBox;

public class Registro {
	
	private String Socio;
	private int HoraIn;
	private int HoraOut;
	public int in;
	public int out;
	public String Resultado;
	public String textIn;
	public String textOut;

	public Registro(JComboBox R) {
		Socio="";
		HoraIn=0;
		HoraOut=0;
	
	}
	public void setSocio(String s){Socio=s;}
	public void setHoraIn(int i){HoraIn=i;}
	public void setHoraOut(int o){HoraOut=o;}
	public String getSocio(){return Socio;}
	public int getHoraIn(){return HoraIn;}
	public int getHoraOut(){return HoraOut;}
	public String toString(){return Socio;}
	
}
