package negocio;

import java.util.ArrayList;

public class Tablero {
	private Celda[][] celdas;
	private final int cantidadDeCeldas = 16;
	private int contador;
	public Tablero(){
		NumeroAleatorio numeroAleatorio = new NumeroAleatorio(0,15);
		contador = 0;
		celdas = new Celda[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				celdas[i][j] = new Celda(numeroAleatorio.generar());
				contador++;
			}
		}
	}
	
	public String mostrarIds(){
		StringBuilder sb = new StringBuilder();
		sb.append("IDs: \n");
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas.length; j++) {
				sb.append(celdas[i][j].getId()+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String mostrarValores(){
		StringBuilder sb = new StringBuilder();
		sb.append("Valores: \n");
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas.length; j++) {
				sb.append(celdas[i][j].getValor()+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	public Tupla<Integer,Integer> getPosicionCero(){
		Tupla<Integer, Integer> tupla = null;
		int posicionI = 0;
		int posicionJ = 0;
		while(true){
			System.out.println(posicionI+""+posicionJ);
			if(celdas[posicionI][posicionJ].getValor() == 0){
				System.out.println("lo encontre");
				tupla = new Tupla<Integer, Integer>(posicionI,posicionJ);
				return tupla;
			}
			if (posicionJ == 3){
				posicionJ = 0;
				posicionI++;
			}
			posicionJ++;
		}
//		for (int i = 0; i < celdas.length; i++) {
//			for (int j = 0; j < celdas.length; j++) {
//				if(celdas[i][j].getValor() == 0){
//					tupla = new Tupla<Integer, Integer>(i,j);
//				}
//			}
//		}
	}
		
	public static void main(String[] args) {
		Tablero tb = new Tablero();
//		System.out.println(tb.mostrarIds());
		System.out.println(tb.mostrarValores());
		System.out.println(tb.getPosicionCero().x+";"+tb.getPosicionCero().y);
	}

}
