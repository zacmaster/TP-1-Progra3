package negocio;

public class Tablero {
	private Celda[][] celdas;
	private final int cantidadDeCeldas = 16;
	private int contador;
	Tablero(){
		contador = 0;
		celdas = new Celda[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				celdas[i][j] = new Celda(contador);
				contador++;
			}
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("IDs \n");
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas.length; j++) {
				sb.append(celdas[i][j].getId()+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Tablero tb = new Tablero();
		System.out.println(tb);
	}

}
