package presentacion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagen {
	private String[] opciones = {"Clasico","Cerati","Abecedario","Metallica","Playa"};
	private String opcion;
	private ImageIcon imageIcon;
	private BufferedImage img = null;
	private int ancho;
	private int alto;
	
	
	Imagen(int numeroDeImagen, int numeroDeCelda, int anchoCelda, int altoCelda){
		this.opcion = opciones[numeroDeImagen];
		try {
			img = ImageIO.read(getClass().getResource("/Images/"+opcion+"/"+numeroDeCelda+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		alto = altoCelda;
		ancho = anchoCelda;
		Image dimg = img.getScaledInstance(ancho, alto,
		        Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(dimg);
		
	}
	
	public ImageIcon getImageIcon(){
		return this.imageIcon;
	}
	public void setImage(int numeroDeImagenDeCelda){
		try {
			img = ImageIO.read(getClass().getResource("/Images/"+opcion+"/"+numeroDeImagenDeCelda+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(ancho, alto,
		        Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(dimg);
	}
	
}
