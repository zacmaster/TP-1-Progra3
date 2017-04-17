package presentacion;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
public class Tablero extends JPanel{
	/**
	 * 
	 */
	private JPanel panel;
	private ArrayList<Celda> matriz;
	private final int cantidadDeCeldas = 16;
	private int posicionXCelda = 2;
	private int posicionYCelda = 2;
	private int distanciaCelda = 73;
	private negocio.Tablero tableroNegocio = null;
	
	public Tablero(int anchoVentana){
		tableroNegocio = new negocio.Tablero();
		
		panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(0, 60, 300, 294);
		panel.setLayout(null);
		matriz = new ArrayList<Celda>();
		
		for (int i = 0; i < cantidadDeCeldas; i++) {
			
			matriz.add(new Celda(posicionXCelda,posicionYCelda,
			0, tableroNegocio.getCeldas().get(i).getValor()));
			
			panel.add(matriz.get(i).getCeldaPanel());
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
		for(int i = 0; i < matriz.size(); i++){
			if(matriz.get(i).getNumeroDeCelda() != tableroNegocio.getCeldas().get(i).getValor()){
				matriz.get(i).setNumeroDeCelda(tableroNegocio.getCeldas().get(i).getValor());
				matriz.get(i).setImagen(tableroNegocio.getCeldas().get(i).getValor());
			}
		}
	}
	public void moverIzquierda(){
		tableroNegocio.moverIzquierda();
		actualizarTablero();
	}
	public void moverDerecha(){
		tableroNegocio.moverDerecha();
		actualizarTablero();
	}
	public void moverArriba(){
		tableroNegocio.moverArriba();
		actualizarTablero();
	}
	public void moverAbajo(){
		tableroNegocio.moverAbajo();
		actualizarTablero();
	}
	
	public JPanel getTablero(){
		return panel;
	}
	public negocio.Tablero getTableroN() {
		return tableroNegocio;
	}
}
