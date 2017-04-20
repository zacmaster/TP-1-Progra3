package presentacion;

//import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

//import InterfazGrafica.JuegoGrafica;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private int alto = 370;
	private int cantidadDeMovimientos = 0;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuReiniciar,menuSalir, menuComoJugar;

	public Ventana() {
		initialize();
	}

	private void initialize() {
		ventanaJuego();
		tablero = new Tablero(ancho);
		frame.getContentPane().add(tablero.getTablero());
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Juego");
		menuBar.add(menu);
		
		menuReiniciar = new JMenuItem("Reiniciar");
		menuReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablero.reiniciar();
			}
		});
		menu.add(menuReiniciar);
		
		menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuSalir);
		frame.setJMenuBar(menuBar);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		menuComoJugar = new JMenuItem("Como Jugar");
		menuComoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Deslize las piezas usando las flechas del teclado"
				+ " \npara que queden ordenadas del 1 al 15.");
			}
		});
		menuAyuda.add(menuComoJugar);
		
		
		
		
		
		
		
		
		
		
		JLabel textoMovimientos = new JLabel();
		textoMovimientos.setText("Cantidad de movimientos: ");
		textoMovimientos.setFont(new Font("Arial",Font.PLAIN, 18));
		textoMovimientos.setForeground(Color.white);
		textoMovimientos.setBounds(2,280,240,40);
		frame.getContentPane().add(textoMovimientos);
		
		JLabel cantidadDeMovimientos = new JLabel();
		cantidadDeMovimientos.setText(this.cantidadDeMovimientos+"");
		cantidadDeMovimientos.setFont(new Font("Arial",Font.PLAIN, 18));
		cantidadDeMovimientos.setForeground(Color.white);
		cantidadDeMovimientos.setBounds(250,280,240,40);
		frame.getContentPane().add(cantidadDeMovimientos);
		
		
		
		
		if(!tablero.seGano()){
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

		}
	private void mover(String direccion){
		
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
