package presentacion;
import java.awt.Color;

import javax.swing.JPanel;
public class Tablero extends JPanel{
	/**
	 * 
	 */
	private JPanel panel;
	private Celda[][] matriz;
	private final int cantidadDeColumnas = 4;
	private int posicionXCelda = 2;
	private int posicionYCelda = 2;
	private int distanciaCelda = 73;
	private int numeroCasillero = 1;
	
	public Tablero(int anchoVentana){
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 60, 300, 294);
		panel.setLayout(null);
		matriz = new Celda[cantidadDeColumnas][cantidadDeColumnas];
		
		for(int i = 0; i < cantidadDeColumnas; i++){
			for(int j = 0; j < cantidadDeColumnas; j++){
				matriz[i][j] = new Celda(posicionXCelda, posicionYCelda,0 ,numeroCasillero);
				matriz[i][j].setId(numeroCasillero);
				matriz[i][j].setText(matriz[i][j].getId()+"");
				
				panel.add(matriz[i][j].getCeldaPanel());
				posicionXCelda+=distanciaCelda;
				numeroCasillero++;
			}
			posicionXCelda = 2;
			posicionYCelda+=distanciaCelda;
		}
	}
	public JPanel getTablero(){
		return panel;
	}
}
