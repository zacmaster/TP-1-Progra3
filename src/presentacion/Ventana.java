package presentacion;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//import InterfazGrafica.JuegoGrafica;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Tablero _tablero;
	private final int _ANCHO = 295;
	private final int _ALTO = 370;
	private int _cantidadMovimientos = 0;
	JLabel _etiquetaCantMov;
	private JMenuBar _barraMenu;
	private JMenu _menu, _menuAyuda;
	private JMenuItem _mReiniciar,_mSalir, _mComoJugar;
	

	public Ventana() {
		initialize();
	}

	private void initialize() {
		ventanaJuego();
		_tablero = new Tablero();
		getContentPane().add(_tablero);
		cargarBarraMenu();
		
		
		
		
		
		
		JLabel textoMovimientos = new JLabel();
		textoMovimientos.setText("Cantidad de movimientos: ");
		textoMovimientos.setFont(new Font("Arial",Font.PLAIN, 18));
		textoMovimientos.setForeground(Color.white);
		textoMovimientos.setBounds(2,283,240,40);
		getContentPane().add(textoMovimientos);
		
		_etiquetaCantMov = new JLabel();
		_etiquetaCantMov.setText(this._cantidadMovimientos+"");
		_etiquetaCantMov.setFont(new Font("Arial",Font.PLAIN, 18));
		_etiquetaCantMov.setForeground(Color.white);
		_etiquetaCantMov.setBounds(250,283,240,40);
		getContentPane().add(_etiquetaCantMov);
		
		
		
		
		
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				if(!_tablero.seGano()){
					mover(e);
					_etiquetaCantMov.setText(_cantidadMovimientos+"");
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "Has ganado!!");
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
		});
		}
	
	
	
	private void mover(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			if(_tablero.moverIzquierda()){
				_cantidadMovimientos++;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(_tablero.moverDerecha()){
				_cantidadMovimientos++;
			}
			break;
		case KeyEvent.VK_UP:
			if(_tablero.moverArriba()){
				_cantidadMovimientos++;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(_tablero.moverAbajo()){
				_cantidadMovimientos++;
			}
			break;
		}
	}
	
	
	
	
	private void cargarBarraMenu(){
		inicializarElementosMenu();
		
		
		
		_mComoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(new JFrame(), "Deslize las piezas usando las flechas del teclado"
				+ " \npara que queden ordenadas del 1 al 15.");
			}
		});
		_menuAyuda.add(_mComoJugar);
		
		_barraMenu.add(_menu);
		
		_mReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		_menu.add(_mReiniciar);
		
		_mSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		_menu.add(_mSalir);
		setJMenuBar(_barraMenu);
		
		_barraMenu.add(_menuAyuda);
	}

	private void inicializarElementosMenu() {
		_barraMenu = new JMenuBar();
		
		_menu = new JMenu("Juego");
		_mReiniciar = new JMenuItem("Reiniciar");
		_mSalir = new JMenuItem("Salir");
		_menuAyuda= new JMenu("Ayuda");
		
		_mComoJugar = new JMenuItem("Como Jugar");
	}

	
	private void reiniciar(){
		_tablero.reiniciar();
		_cantidadMovimientos = 0;
		_etiquetaCantMov.setText(this._cantidadMovimientos+"");
		
	}
			
	private void ventanaJuego() {
		Imagen iconoVentana = new Imagen("/Images/zeta_logo.png"); 
		setIconImage(iconoVentana.getImageIcon().getImage());
		setTitle("Sliding Puzzle");
		getContentPane().setLayout(null);
		setResizable(false);
		getContentPane().setBackground(new Color(0,102,204));
		setBounds(400, 100, _ANCHO, _ALTO);
		getContentPane().setForeground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
