package negocio;

import java.util.ArrayList;

public class Tablero {
	private int cantidadDeColumnas = 4;
	private Celda[][] celdas;
	private int contador;
//	private 
	private Tupla<Integer,Integer>posicionCero;
	public Tablero(){
		NumeroAleatorio numeroAleatorio = new NumeroAleatorio(0,15);
		contador = 0;
		celdas = new Celda[cantidadDeColumnas][cantidadDeColumnas];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				celdas[i][j] = new Celda(numeroAleatorio.generar());
				contador++;
			}
		}
		posicionCero = getPosicionCero();
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
		int i = 0;
		int j = 0;
		boolean bandera = false;
		while(i < celdas.length) {
			while(j < celdas[i].length){
				if(celdas[i][j].getValor() == 0){
					tupla = new Tupla<Integer, Integer>(i,j);
					bandera = true;
					break;
				}
				j++;
			}
			j = 0;
			i++;
			if(bandera){
				break;
			}
		}
		return tupla;
	}
	
	public void moverIzquierda(){
		posicionCero = getPosicionCero();
		if(!(posicionCero.x == cantidadDeColumnas-1)){
			int aux = -1;
			aux = celdas[posicionCero.y][posicionCero.x+1].getValor();
			celdas[posicionCero.y][posicionCero.x].setValor(aux);
			celdas[posicionCero.y][posicionCero.x+1].setValor(0);
		}
	}
	public void moverDerecha(){
		posicionCero = getPosicionCero();
		if(!(posicionCero.x == 0)){
			int aux = -1;
			aux = celdas[posicionCero.y][posicionCero.x-1].getValor();
			celdas[posicionCero.y][posicionCero.x].setValor(aux);
			celdas[posicionCero.y][posicionCero.x-1].setValor(0);
//			System.out.println("esto vale aux"+aux);
		}
	}
	public void moverArriba(){
		posicionCero = getPosicionCero();
		if(!(posicionCero.y == cantidadDeColumnas-1)){
			int aux = -1;
			aux = celdas[posicionCero.y+1][posicionCero.x].getValor();
			celdas[posicionCero.y][posicionCero.x].setValor(aux);
			celdas[posicionCero.y+1][posicionCero.x].setValor(0);
//			System.out.println("esto vale aux"+aux);
		}
	}
	
	public void moverAbajo(){
		posicionCero = getPosicionCero();
		if(!(posicionCero.y == 0)){
			int aux = -1;
			aux = celdas[posicionCero.y-1][posicionCero.x].getValor();
			celdas[posicionCero.y][posicionCero.x].setValor(aux);
			celdas[posicionCero.y-1][posicionCero.x].setValor(0);
		}
	}
	
	public Celda[][] getCeldas() {
		return celdas;
	}

	public void setCeldas(Celda[][] celdas) {
		this.celdas = celdas;
	}

	public void cambiarValores(int id1, int id2){
		
	}
		
	public static void main(String[] args) {
		Tablero tb = new Tablero();
		System.out.println(tb.mostrarIds());
		System.out.println(tb.mostrarValores());
		System.out.println(tb.posicionCero.y+";"+ tb.posicionCero.x);
	}

}
