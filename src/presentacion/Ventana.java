package presentacion;

import java.awt.EventQueue;
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
import java.awt.CardLayout;

public class Ventana{

	private JFrame frame;
	private Tablero tablero;
	private negocio.Tablero tableroN;
	private int ancho = 300;
//	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaJuego();
//		tablero = new Tablero(ancho);
		tableroN = new negocio.Tablero();
		System.out.println(tableroN.mostrarValores());
		System.out.println(tableroN.getPosicionCero());
//		frame.getContentPane().add(tablero.getTablero());
		
		
		
		
		
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					tableroN.moverIzquierda();
					System.out.println(tableroN.mostrarValores());
					break;
				case KeyEvent.VK_RIGHT:
					tableroN.moverDerecha();
					System.out.println(tableroN.mostrarValores());
					break;
				case KeyEvent.VK_UP:
					tableroN.moverArriba();
					System.out.println(tableroN.mostrarValores());
					break;
				case KeyEvent.VK_DOWN:
					tableroN.moverAbajo();
					System.out.println(tableroN.mostrarValores());
					break;
				}
			}

		});
		
	}
	
	private void ventanaJuego() {
		frame = new JFrame();
//		frame.getContentPane().setLayout(null);
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(46,204,113));
//		frame.setBounds(400, 100, ancho, 450);
//		frame.getContentPane().setForeground(Color.RED);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
