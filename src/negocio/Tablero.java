package negocio;

import java.util.ArrayList;
import java.util.Collections;

public class Tablero {
	private final int cantidadDeCeldas = 16;
	private ArrayList<Celda> celdas;
	private ArrayList<Integer> valores = new ArrayList<Integer>();
	private int posicionCero;
	
	public Tablero(){
		for (int i = 0; i < 16; i++) {
			valores.add(i);
		}
		Collections.shuffle(valores);
		celdas = new ArrayList<Celda>();
		for (int i = 0; i < cantidadDeCeldas; i++) {
			celdas.add(new Celda(valores.get(i)));
		}
		posicionCero = getPosicionCero();
	}
	
	
	public String mostrarValores(){
		StringBuilder sb = new StringBuilder();
		sb.append("Valores: \n");
		for (int i = 0; i < cantidadDeCeldas; i++) {
			
			sb.append(celdas.get(i).getValor()+" ");
			
			if(i== 3 || i==7 || i==11){
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	
	public int getPosicionCero(){
		int posicionDelCero = -1;
		int i = 0;
		while(i < celdas.size()){
			if(celdas.get(i).getValor() == 0){
				posicionDelCero = i;
				break;
			}
			i++;
		}
		return posicionDelCero;
	}
	
	public void moverIzquierda(){
		posicionCero = getPosicionCero();
		if(posicionCero != 3 && posicionCero != 7 && posicionCero != 11 && posicionCero != 15){
			int aux = -1;
			aux = celdas.get(posicionCero+1).getValor();
			celdas.get(posicionCero).setValor(aux);
			celdas.get(posicionCero+1).setValor(0);
		}
	}
	public void moverDerecha(){
		posicionCero = getPosicionCero();
		if(posicionCero != 0 && posicionCero != 4 && posicionCero != 8 && posicionCero != 12){
			int aux = -1;
			aux = celdas.get(posicionCero-1).getValor();
			celdas.get(posicionCero).setValor(aux);
			celdas.get(posicionCero-1).setValor(0);
		}
	}
	public void moverArriba(){
		posicionCero = getPosicionCero();
		if(posicionCero != 12 && posicionCero != 13 && posicionCero != 14 && posicionCero != 15){
			int aux = -1;
			aux = celdas.get(posicionCero+4).getValor();
			celdas.get(posicionCero).setValor(aux);
			celdas.get(posicionCero+4).setValor(0);
			
		}
	}
	
	public void moverAbajo(){
		posicionCero = getPosicionCero();
		if(posicionCero != 0 && posicionCero != 1 && posicionCero != 2 && posicionCero != 3){
			int aux = -1;
			aux = celdas.get(posicionCero-4).getValor();
			celdas.get(posicionCero).setValor(aux);
			celdas.get(posicionCero-4).setValor(0);
			
		}
	}
	
	public boolean seGano(){
		boolean gano = true;
		for (int i = 0; i < cantidadDeCeldas; i++) {
			if(i != 15){
				if(i+1 != celdas.get(i).getValor())gano = false;
					
			}
		}
		return gano;
	}
	
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}


		

}
