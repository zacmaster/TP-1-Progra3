package presentacion;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

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
