package negocio;

public class Celda {
	private static int next_id = 0;
	private int id;
	private int valor;
	
	public Celda(int valor){
		this.id = ++Celda.next_id;
		this.valor = valor;
	}
	public int getId(){
		return id;
	}
	public int getValor(){
		return valor;
	}
	public void setValor(int valor){
		this.valor = valor;
	}
}
