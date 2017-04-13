package presentacion;
import javax.swing.JLabel;

import java.awt.Panel;
import javax.swing.JPanel;

import java.awt.Color;

public class Celda extends JPanel{
	private Panel panel;
	private JLabel label;
	private int id;
	private int ancho;
	private int alto;
	private Imagen imagen = null;
	private int numeroDeCelda;
	public Celda(int x, int y,int numeroDeImagen, int numeroDeCelda){
		id = -1;
		alto = 71;
		ancho = 71;
		this.numeroDeCelda = numeroDeCelda;
		panel = new Panel();
		panel.setBounds(x, y, ancho, alto);
		panel.setLayout(null);
		panel.setBackground(Color.black);
		label = new JLabel();
		label.setBounds(0, 0, 71, 71);
		
		imagen = new Imagen(numeroDeImagen, numeroDeCelda,ancho, alto);
		label.setIcon(imagen.getImageIcon());
		
		
		panel.add(label);
		validate();
		
	}
	public Panel getCeldaPanel(){
		return panel;
	}
	public int getAncho(){
		return ancho;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public int getNumeroDeCelda() {
		return numeroDeCelda;
	}
	public void setNumeroDeCelda(int numeroDeCelda) {
		this.numeroDeCelda = numeroDeCelda;
	}
	public void setImagen(int numeroDeImagen){
			imagen.setImage(numeroDeImagen);
			label.setIcon(imagen.getImageIcon());
	}
}
