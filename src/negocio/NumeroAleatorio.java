package negocio;
import java.util.ArrayList;
public class NumeroAleatorio {
	private int valorInicial;
	private int valorFinal;
	private ArrayList<Integer> listaNumero;
	
	public NumeroAleatorio(int valorInicial, int valorFinal){
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		listaNumero = new ArrayList<Integer>();
	}
	
	private int numeroAleatorio(){
		return (int)(Math.random()*(valorFinal-valorInicial+1)+valorInicial);
	}
	public int generar(){
		if(listaNumero.size() < (valorFinal - valorInicial) +1){
			int numero = numeroAleatorio();
			if(listaNumero.isEmpty()){
				listaNumero.add(numero);
				return numero;
			}
			if(listaNumero.contains(numero)){
				return generar();
			}
			else{
				listaNumero.add(numero);
				return numero;
			}
		}
		return -1;
	}
}
