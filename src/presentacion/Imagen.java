package presentacion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagen {
	private ImageIcon imageIcon;
	private BufferedImage img = null;
	private int ancho;
	private int alto;
	
	Imagen(String nombreArchivo, int ancho, int alto){
//		Se lee las imagenes desde la carpeta fuente
		try {
			img = ImageIO.read(getClass().getResource("/Images/"+nombreArchivo+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.alto = alto;
		this.ancho = ancho;
//		Se escala la imagen
		Image dimg = img.getScaledInstance(ancho, alto,
		        Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(dimg);
		
	}
//	Este constructor se hizo para ponerle un logo a la ventana:
	Imagen(String archivoConExtension){
		try {
			img = ImageIO.read(getClass().getResource(archivoConExtension));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(16, 16,
		        Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(dimg);
	}
		
	
	public ImageIcon getImageIcon(){
		return this.imageIcon;
	}
//	Con este método se cambia la imagen
	public void setImage(int numeroDeImagenDeCelda){
		try {
			img = ImageIO.read(getClass().getResource("/Images/"+numeroDeImagenDeCelda+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(ancho, alto,
		        Image.SCALE_SMOOTH);
		
		imageIcon = new ImageIcon(dimg);
	}
	
}
