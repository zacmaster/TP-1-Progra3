package presentacion;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
public class Tablero extends JPanel{

	private JPanel panel;
	private ArrayList<Celda> celdas = new ArrayList<Celda>();
	private final int cantidadDeCeldas = 16;
	private int posicionXCelda = 2;
	private int posicionYCelda = 2;
	private int distanciaCelda = 71;
	private negocio.Tablero tableroNegocio = null;
	
	public Tablero(){
		tableroNegocio = new negocio.Tablero();
//		tableroNegocio.ganar();
		panel = new JPanel();
		panel.setBackground(new Color(0,102,204));
		panel.setBounds(0, 0, 300, 294);
		panel.setLayout(null);
		
		for (int i = 0; i < cantidadDeCeldas; i++) {
			
			celdas.add(new Celda(posicionXCelda,posicionYCelda,
			tableroNegocio.getCeldas().get(i).getValor()));
			
			panel.add(celdas.get(i).getCeldaPanel());
			posicionXCelda+=distanciaCelda;
			
			if(i == 3){
				posicionXCelda = 2;
				posicionYCelda += distanciaCelda;
			}
			else if(i == 7){
				posicionXCelda = 2;
				posicionYCelda += distanciaCelda;
			}
			else if(i == 11){
				posicionXCelda = 2;
				posicionYCelda += distanciaCelda;
				
			}
		}
	}
	
	public void actualizarTablero(){
		for(int i = 0; i < celdas.size(); i++){
			if(celdas.get(i).getNumeroDeCelda() != tableroNegocio.getCeldas().get(i).getValor()){
				celdas.get(i).setNumeroDeCelda(tableroNegocio.getCeldas().get(i).getValor());
				celdas.get(i).setImagen(tableroNegocio.getCeldas().get(i).getValor());
			}
		}
	}
	
	public boolean moverIzquierda(){
		boolean seMovio = false;
		if(tableroNegocio.moverIzquierda()){
			actualizarTablero();
			seMovio = true;
		}
		return seMovio;
		
	}
	public boolean moverDerecha(){
		boolean seMovio = false;
		if(tableroNegocio.moverDerecha()){
			actualizarTablero();
			seMovio = true;
		}
		return seMovio;
	}
	public boolean moverArriba(){
		boolean seMovio = false;
		if(tableroNegocio.moverArriba()){
			actualizarTablero();
			seMovio = true;
		}
		return seMovio;
	}
	public boolean moverAbajo(){
		boolean seMovio = false;
		if(tableroNegocio.moverAbajo()){
			actualizarTablero();
			seMovio = true;
		}
		return seMovio;
	}
	
	public JPanel getTablero(){
		return panel;
	}
	public boolean seGano(){
		return tableroNegocio.seGano();
	}
	public void reiniciar(){
		tableroNegocio = new negocio.Tablero();
		actualizarTablero();
	}
}
