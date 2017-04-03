package presentacion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagen {
	private String[] opciones = {"Clasico","Cerati","Abecedario","Playa"};
	ImageIcon imageIcon;
	Imagen(int numeroImagen, int anchoCelda, int altoCelda){
		String opcion = opciones[numeroImagen];
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource("/Images/Abecedario/"+opcion+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(anchoCelda, altoCelda,
		        Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(dimg);
		
	}
	public ImageIcon getImageIcon(){
		return this.imageIcon;
	}
	
}
