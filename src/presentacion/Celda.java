package presentacion;

import javax.swing.JButton;
import javax.swing.JLabel;


import java.awt.Color;
import java.awt.Insets;

public class Celda extends JButton{
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private int ancho;
	private int alto;
	private Imagen imagen = null;
	private Integer numeroDeCelda;
	
	public Celda(int x, int y, Integer numeroDeCelda){
		
		alto = 71;
		ancho = 71;
		this.numeroDeCelda = numeroDeCelda;
		
		setBounds(x, y, ancho, alto);
		
		configuracion();
		
		
		
		setEnabled(false);
		setBackground(new Color(0,102,204));
		
		label = new JLabel();
		label.setBounds(0, 0, 71, 71); imagen = new Imagen(this.numeroDeCelda.toString(),ancho, alto);
		label.setIcon(imagen.getImageIcon());
		
		add(label);
		
	}

	private void configuracion() {
		setBorder(null);
		setBorderPainted(false);
		setMargin(new Insets(0,0,0,0));
		
		setFocusPainted(false);
		setContentAreaFilled(false);
	}
	
	public int getNumeroDeCelda() {
		return numeroDeCelda;
	}
	public void setNumeroDeCelda(int numeroDeCelda) {
		this.numeroDeCelda = numeroDeCelda;
	}
	public void setImagen(Integer numeroDeImagen){
			imagen.setImage(numeroDeImagen);
			label.setIcon(imagen.getImageIcon());
	}
}
