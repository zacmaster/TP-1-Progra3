package presentacion;
import javax.swing.JLabel;

import java.awt.Panel;
import javax.swing.JPanel;

import java.awt.Color;

public class Celda extends JPanel{
	
	private Panel panel;
	private JLabel label;
	private int ancho;
	private int alto;
	private Imagen imagen = null;
	private Integer numeroDeCelda;
	
	public Celda(int x, int y, Integer numeroDeCelda){
		alto = 71;
		ancho = 71;
		this.numeroDeCelda = numeroDeCelda;
		panel = new Panel();
		panel.setBounds(x, y, ancho, alto);
		panel.setLayout(null);
//		panel.setBackground(Color.black);
		panel.setBackground(new Color(0,102,204));
		label = new JLabel();
		label.setBounds(0, 0, 71, 71);
		String celdaTexto = this.numeroDeCelda.toString();
		imagen = new Imagen(celdaTexto,ancho, alto);
		label.setIcon(imagen.getImageIcon());
		
		
		panel.add(label);
		
	}
	public Panel getCeldaPanel(){
		return panel;
	}
	public int getAncho(){
		return ancho;
	}
	
	public int getNumeroDeCelda() {
		return numeroDeCelda;
	}
	public void setNumeroDeCelda(int numeroDeCelda) {
		this.numeroDeCelda = numeroDeCelda;
	}
	public void setImagen(Integer numeroDeImagen){
			imagen.setImage(numeroDeImagen.toString());
			label.setIcon(imagen.getImageIcon());
	}
}
