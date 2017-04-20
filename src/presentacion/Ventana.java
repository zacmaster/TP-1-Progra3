package presentacion;

//import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

//import InterfazGrafica.JuegoGrafica;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;

public class Ventana{

	JFrame frame;
	private Tablero tablero;
	private int ancho = 295;
	private int alto = 410;
	private int cantidadDeMovimientos = 0;

	public Ventana() {
		initialize();
	}

	private void initialize() {
		ventanaJuego();
		tablero = new Tablero(ancho);
		frame.getContentPane().add(tablero.getTablero());
		
		JLabel textoMovimientos = new JLabel();
		textoMovimientos.setText("Cantidad de movimientos: ");
		textoMovimientos.setFont(new Font("Arial",Font.PLAIN, 18));
		textoMovimientos.setForeground(Color.white);
		textoMovimientos.setBounds(2,345,240,40);
		frame.getContentPane().add(textoMovimientos);
		
		JLabel cantidadDeMovimientos = new JLabel();
		cantidadDeMovimientos.setText(this.cantidadDeMovimientos+"");
		cantidadDeMovimientos.setFont(new Font("Arial",Font.PLAIN, 18));
		cantidadDeMovimientos.setForeground(Color.white);
		cantidadDeMovimientos.setBounds(250,345,240,40);
		frame.getContentPane().add(cantidadDeMovimientos);
		
		
		
		
		
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					tablero.moverIzquierda();
					break;
				case KeyEvent.VK_RIGHT:
					tablero.moverDerecha();
					break;
				case KeyEvent.VK_UP:
					tablero.moverArriba();
					break;
				case KeyEvent.VK_DOWN:
					tablero.moverAbajo();
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
				}
				
			}

		});
		
	}
	
	private void ventanaJuego() {
		frame = new JFrame();
		Imagen iconoVentana = new Imagen("/Images/zeta_logo.png"); 
		frame.setIconImage(iconoVentana.getImageIcon().getImage());
		frame.setTitle("Sliding Puzzle");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0,102,204));
		frame.setBounds(400, 100, ancho, alto);
		frame.getContentPane().setForeground(Color.RED);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
