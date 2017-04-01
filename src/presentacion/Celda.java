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
	
	public Celda(int x, int y,int numeroDeImagen){
		id = -1;
		alto = 71;
		ancho = 71;
		panel = new Panel();
		panel.setBounds(x, y, ancho, alto);
		panel.setLayout(null);
		panel.setBackground(Color.black);
		label = new JLabel();
		label.setBounds(0, 0, 71, 71);
//		label.setForeground(Color.BLACK);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource("/Images/Clasico/"+numeroDeImagen+".png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(this.ancho, this.alto,
		        Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		

		label.setIcon(imageIcon);
//		label.setFont(new Font("Dialog", Font.BOLD, 20));
		
		
		panel.add(label);
		validate();
		
	}
	public void encender(int numero){
//		panel.setBackground(Color.gray);
		label.setText(numero+"");
		
	}
	public void apagar(){
		panel.setBackground(Color.black);
		label.setText("");
	}
	public Panel getCeldaPanel(){
		return panel;
	}
	public void setText(String texto){
		label.setText(texto);
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
	
}
