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
	private int numeroCasillero = 0;
	private negocio.Tablero tableroNegocio = null;
	public Tablero(int anchoVentana){
		tableroNegocio = new negocio.Tablero();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 60, 300, 294);
		panel.setLayout(null);
		matriz = new ArrayList<Celda>();
		
		for (int i = 0; i < matriz.size(); i++) {
			matriz.add(new Celda(posicionXCelda,posicionYCelda,
			0, tableroNegocio.getCeldas().get(i).getValor()));
			panel.add(matriz.get(i).getCeldaPanel());
			posicionXCelda+=distanciaCelda;
			if(i == 4){
				posicionXCelda = 2;
				posicionYCelda += distanciaCelda;
			}
			else if(i == 8){
				posicionXCelda = 2;
				posicionYCelda += distanciaCelda;
			}
			else if(i == 12){
				posicionXCelda = 2;
				posicionYCelda += distanciaCelda;
				
			}
		}
		
//		for(int i = 0; i < cantidadDeColumnas; i++){
//			for(int j = 0; j < cantidadDeColumnas; j++){
//				matriz[i][j] = new Celda(posicionXCelda, posicionYCelda,0 ,tableroNegocio.getCeldas().get(i).getValor());
//				matriz[i][j].setId(numeroCasillero);
////				matriz[i][j].setText(matriz[i][j].getId()+"");
//				
//				panel.add(matriz[i][j].getCeldaPanel());
//				posicionXCelda+=distanciaCelda;
//				numeroCasillero++;
//			}
//			posicionXCelda = 2;
//			posicionYCelda+=distanciaCelda;
//		}
	}
//	public void actualizarTablero(){
//		for(int i = 0; i < cantidadDeColumnas; i++){
//			for(int j = 0; j < cantidadDeColumnas; j++){
//				if(matriz[i][j].getNumeroDeCelda() != tableroNegocio.getCeldas()[i][j].getValor()){
//					matriz[i][j].setNumeroDeCelda(tableroNegocio.getCeldas()[i][j].getValor());
//					matriz[i][j].setImagen(tableroNegocio.getCeldas()[i][j].getValor());
//					
//				}
//			}
//		}
//	}
	public void actualizarTablero(){
		for(int i = 0; i < matriz.size(); i++){
			if(matriz.get(i).getNumeroDeCelda() != tableroNegocio.getCeldas().get(i).getValor()){
				matriz.get(i).setNumeroDeCelda(tableroNegocio.getCeldas().get(i).getValor());
				matriz.get(i).setImagen(tableroNegocio.getCeldas().get(i).getValor());
			}
		}
	}
	public JPanel getTablero(){
		return panel;
	}
	public negocio.Tablero getTableroN() {
		return tableroNegocio;
	}
}
