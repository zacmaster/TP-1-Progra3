package presentacion;

import java.awt.Panel;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

public class Celda extends JPanel{
	private Panel panel;
	private Label label;
	private int id;
	private int ancho;
	private int alto;
	
	public Celda(int x, int y){
		id = -1;
		alto = 71;
		ancho = 71;
		panel = new Panel();
		panel.setBounds(x, y, ancho, alto);
		panel.setLayout(null);
		panel.setBackground(Color.gray);
		label = new Label("");
		label.setForeground(Color.BLACK);
		label.setBounds(25, 22, 30, 30);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		
		
		panel.add(label);
		
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
